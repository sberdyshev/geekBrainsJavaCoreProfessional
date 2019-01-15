package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.dao.jdbc;

import lombok.Setter;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.constants.JdbcPostgresConnectionConstants;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.dao.ProductsDao;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sberdyshev
 */
public class ProductsJdbcImplDao implements ProductsDao {

    private static final String getAllGoodsQuery = "SELECT ID, PRODID, TITLE, COST FROM GOODS";
    private static final String getGoodsWithSpecificPriceQuery = "SELECT ID, PRODID, TITLE, COST FROM GOODS WHERE COST >= ? AND COST <= ?";
    private static final String getGoodPriceQuery = "SELECT COST FROM GOODS WHERE TITLE = ?";
    private static final String changeGoodPriceQuery = "UPDATE GOODS SET COST = ? WHERE TITLE = ?";
    private static final String fillGoodsQuery = "INSERT INTO goods (id, prodid, title, cost) VALUES (?, ?, ?, ?);";

    private PreparedStatement getAllGoodsStatement;
    private PreparedStatement getGoodsWithSpecificPriceStatement;
    private PreparedStatement getGoodPriceStatement;
    private PreparedStatement changeGoodPriceStatement;
    private PreparedStatement fillGoodsStatement;

    @Setter
    private Connection goodsConnection;

    public ProductsJdbcImplDao(Connection goodsConnection) {
        this.goodsConnection = goodsConnection;
    }

    @Override
    public List<Product> getAllGoods() {
        ArrayList<Product> products = new ArrayList<>();
        String query = "SELECT ID, PRODID, TITLE, COST FROM GOODS";
        try (Connection goodsConnection = DriverManager.getConnection(JdbcPostgresConnectionConstants.getUrl(), JdbcPostgresConnectionConstants.getUser(), JdbcPostgresConnectionConstants.getPassword())) {
            PreparedStatement statement = goodsConnection.prepareStatement(query);
            ResultSet queryResult = statement.executeQuery();
            while (queryResult.next()) {
                int id = queryResult.getInt(1);
                int prodid = queryResult.getInt(2);
                String title = queryResult.getString(3);
                double cost = queryResult.getDouble(4);
                products.add(new Product(id, prodid, title, cost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> getGoodsWithSpecificPrice(double lowestPrice, double highestPrice) {
        ArrayList<Product> products = new ArrayList<>();
        String query = "SELECT ID, PRODID, TITLE, COST FROM GOODS WHERE COST >= ? AND COST <= ?";
        try (Connection goodsConnection = DriverManager.getConnection(JdbcPostgresConnectionConstants.getUrl(), JdbcPostgresConnectionConstants.getUser(), JdbcPostgresConnectionConstants.getPassword())) {
            PreparedStatement statement = goodsConnection.prepareStatement(query);
            statement.setDouble(1, lowestPrice);
            statement.setDouble(2, highestPrice);
            ResultSet queryResult = statement.executeQuery();
            while (queryResult.next()) {
                int id = queryResult.getInt(1);
                int prodid = queryResult.getInt(2);
                String title = queryResult.getString(3);
                double cost = queryResult.getDouble(4);
                products.add(new Product(id, prodid, title, cost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Double getGoodPrice(String title) {
        Double cost = null;
        String query = "SELECT COST FROM GOODS WHERE TITLE = ?";
        try (Connection goodsConnection = DriverManager.getConnection(JdbcPostgresConnectionConstants.getUrl(), JdbcPostgresConnectionConstants.getUser(), JdbcPostgresConnectionConstants.getPassword())) {
            PreparedStatement statement = goodsConnection.prepareStatement(query);
            statement.setString(1, title);
            ResultSet queryResult = statement.executeQuery();
            while (queryResult.next()) {
                cost = queryResult.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cost;
    }

    @Override
    public int changeGoodPrice(String title, double cost) {
        int updatedRows = 0;
        String query = "UPDATE GOODS SET COST = ? WHERE TITLE = ?";
        try (Connection goodsConnection = DriverManager.getConnection(JdbcPostgresConnectionConstants.getUrl(), JdbcPostgresConnectionConstants.getUser(), JdbcPostgresConnectionConstants.getPassword())) {
            PreparedStatement statement = goodsConnection.prepareStatement(query);
            statement.setDouble(1, cost);
            statement.setString(2, title);
            updatedRows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedRows;
    }

    @Override
    public int fillGoods() {
        int result = 0;
        String query = "INSERT INTO goods (id, prodid, title, cost) VALUES (?, ?, ?, ?);";
        try (Connection goodsConnection = DriverManager.getConnection(JdbcPostgresConnectionConstants.getUrl(), JdbcPostgresConnectionConstants.getUser(), JdbcPostgresConnectionConstants.getPassword())) {
            for (int i = 1; i <= 10000; i++) {
                PreparedStatement statement = goodsConnection.prepareStatement(query);
                statement.setInt(1, i);
                statement.setInt(2, i);
                statement.setString(3, "товар" + i);
                statement.setDouble(4, i);
                result = statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private boolean handleStatement(PreparedStatement ps, String query) {
        boolean result = false;
        try {
            if (ps == null || ps.isClosed()) {
                ps = goodsConnection.prepareStatement(query);
            }
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private ResultSet executeQuery(PreparedStatement ps, String query) {
        ResultSet result = null;
        try {
            result = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Операция неуспешна.");
            e.printStackTrace();
        }
        return result;
    }

    private int executeUpdate(PreparedStatement ps, String query) {
        int result = 0;
        try {
            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Операция неуспешна.");
            e.printStackTrace();
        }
        return result;
    }
}
