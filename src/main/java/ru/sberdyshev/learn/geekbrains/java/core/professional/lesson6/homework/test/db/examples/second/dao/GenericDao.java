package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @param <T> - dao entity
 * @author sberdyshev
 */
public abstract class GenericDao<T> {
    protected final String tableName;
    protected Connection connection;

    public GenericDao(Connection connection, String tableName) {
        this.tableName = tableName;
        this.connection = connection;
    }

    public abstract int count() throws SQLException;

    public abstract List<T> getEntities() throws SQLException;

    public abstract T getEntity(Integer id) throws SQLException;

    public abstract boolean updateEntity(T entity) throws SQLException;

    public abstract boolean addEntity(T entity) throws SQLException;

    public abstract void commit() throws SQLException;

    public abstract void rollback() throws SQLException;

    public abstract void turnTransactionsHandlingOn() throws SQLException;

    public abstract void turnTransactionsHandlingOff() throws SQLException;
}
