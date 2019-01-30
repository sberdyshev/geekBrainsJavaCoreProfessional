package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author sberdyshev
 * @param <T> - dao entity
 */
public abstract class GenericDao<T> {
    public abstract int count() throws SQLException;
    public abstract List<T> getEntities() throws SQLException;
    public abstract T getEntity() throws SQLException;
    public abstract boolean updateEntity(T entity) throws SQLException;
    public abstract boolean addEntity(T entity) throws SQLException;

    private final String tableName;
    private Connection connection;

    public GenericDao(Connection connection, String tableName) {
        this.tableName = tableName;
        this.connection = connection;
    }


}
