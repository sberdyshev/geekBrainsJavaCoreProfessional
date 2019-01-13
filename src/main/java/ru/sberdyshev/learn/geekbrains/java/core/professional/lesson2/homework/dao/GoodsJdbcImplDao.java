package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.dao;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.constants.JdbcPostgresConnectionConstants;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.model.Good;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sberdyshev
 */
public class GoodsJdbcImplDao implements GoodsDao {

    @Override
    public List<Good> getAllGoods() {
        ArrayList<Good> goods = new ArrayList<>();
        String query = "SELECT ID, PRODID, TITLE, COST FROM GOODS";
        try (Connection goodsConnection = DriverManager.getConnection(JdbcPostgresConnectionConstants.getUrl(), JdbcPostgresConnectionConstants.getUser(), JdbcPostgresConnectionConstants.getPassword())) {
            PreparedStatement statement = goodsConnection.prepareStatement(query);
            ResultSet queryResult = statement.executeQuery();
            while (queryResult.next()) {
                int id = queryResult.getInt(1);
                int prodid = queryResult.getInt(2);
                String title = queryResult.getString(3);
                double cost = queryResult.getDouble(4);
                goods.add(new Good(id, prodid, title, cost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public List<Good> getGoodsWithSpecificPrice(double lowestPrice, double highestPrice) {
        ArrayList<Good> goods = new ArrayList<>();
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
                goods.add(new Good(id, prodid, title, cost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
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
    public boolean fillGoods() {
        boolean result = false;
        String query = "INSERT INTO goods (id, prodid, title, cost) VALUES (?, ?, ?, ?);";
        try (Connection goodsConnection = DriverManager.getConnection(JdbcPostgresConnectionConstants.getUrl(), JdbcPostgresConnectionConstants.getUser(), JdbcPostgresConnectionConstants.getPassword())) {
            for (int i = 1; i <= 10000; i++) {
                PreparedStatement statement = goodsConnection.prepareStatement(query);
                statement.setInt(1, i);
                statement.setInt(2, i);
                statement.setString(3, "товар" + i);
                statement.setDouble(4, i);
                result = statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
