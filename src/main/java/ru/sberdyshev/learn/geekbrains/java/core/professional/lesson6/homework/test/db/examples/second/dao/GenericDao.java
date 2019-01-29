package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author sberdyshev
 * @param <T> - dao entity
 */
public abstract class GenericDao<T> {
    public abstract int count() throws SQLException;

    //todo private?
    //Protected
    protected final String tableName;
    protected Connection con;

    //todo private?
    protected GenericDao(Connection con, String tableName) {
        this.tableName = tableName;
        this.con = con;
    }
}
