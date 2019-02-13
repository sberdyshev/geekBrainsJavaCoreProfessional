package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.table.Table;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sberdyshev
 */
public class StudentDao extends GenericDao<Student> {
    private final static Logger logger = LoggerFactory.getLogger(StudentDao.class);

    protected StudentDao(Connection con, Table tableName) {
        super(con, tableName.toString());
    }

    @Override
    public int count() throws SQLException {
        logger.debug("Called count() method");
        final String query = "SELECT COUNT(id) FROM " + tableName;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        int result = 0;
        if (resultSet.next()) {
            result = resultSet.getInt("COUNT");
        }
        logger.debug("Result of count() - {}", result);
        return result;
    }

    @Override
    public List<Student> getEntities() throws SQLException {
        logger.debug("Called getEntities() method");
        final String query = "SELECT ID, NAME, SCORE FROM " + tableName;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Student> result = new ArrayList<>();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            Integer score = resultSet.getInt("SCORE");
            Student student = new Student(id, name, score);
            logger.debug("Student {} with id {}, name {}, score {}", student, student.getId(), student.getName(), student.getScore());
            result.add(student);
        }
        return result;
    }

    @Override
    public Student getEntity(Integer id) throws SQLException {
        logger.debug("Called getEntity() method with id {}", id);
        final String query = "SELECT ID, NAME, SCORE FROM " + tableName + " WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Integer resultStudentID = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            Integer score = resultSet.getInt("SCORE");
            Student result = new Student(resultStudentID, name, score);
            logger.debug("Result of getEntity() - Student {} with id {}, name {}, score {}", result, result.getId(), result.getName(), result.getScore());
            return result;
        } else {
            Student result = null;
            logger.debug("Student with id {} is not found", id);
            return result;
        }
    }

    @Override
    public boolean updateEntity(Student entity) throws SQLException {
        logger.debug("Called updateEntity() method with Student entity with id {}, name {}, score {}", entity.getId(), entity.getName(), entity.getScore());
        final String query = "UPDATE " + tableName + " SET NAME = ?, SCORE = ? WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setInt(2, entity.getScore());
        preparedStatement.setInt(3, entity.getId());
        int updatedRows = preparedStatement.executeUpdate();
        boolean result = false;
        if (updatedRows == 1) {
            result = true;
        } else {
            result = false;
        }
        logger.debug("Result of updateEntity() - {}", result);
        return result;
    }

    @Override
    public boolean addEntity(Student entity) throws SQLException {
        logger.debug("Called addEntity() method with Student entity with id {}, name {}, score {}", entity.getId(), entity.getName(), entity.getScore());
        String query = "INSERT INTO " + tableName + " (ID, NAME, SCORE) VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, entity.getId());
        preparedStatement.setString(2, entity.getName());
        preparedStatement.setInt(3, entity.getScore());
        int addedRows = preparedStatement.executeUpdate();
        boolean result = false;
        if (addedRows == 1) {
            result = true;
        } else {
            result = false;
        }
        logger.debug("Result of addEntity() - {}", result);
        return result;
    }

    @Override
    public void commit() throws SQLException {
        if (!connection.isClosed() && !connection.getAutoCommit()) {
            connection.commit();
        }
    }

    @Override
    public void rollback() throws SQLException {
        if (!connection.isClosed() && !connection.getAutoCommit()) {
            connection.rollback();
        }
    }

    @Override
    public void turnTransactionsHandlingOn() throws SQLException {
        if (!connection.isClosed()) {
            connection.setAutoCommit(false);
        }
    }

    @Override
    public void turnTransactionsHandlingOff() throws SQLException {
        if (!connection.isClosed()) {
            connection.setAutoCommit(true);
        }
    }
}
