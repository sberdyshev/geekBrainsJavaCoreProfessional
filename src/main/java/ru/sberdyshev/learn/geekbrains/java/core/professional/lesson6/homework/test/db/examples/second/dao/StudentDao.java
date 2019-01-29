package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.table.Table;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.entity.Student;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author sberdyshev
 */
public class StudentDao extends GenericDao<Student> {

    protected StudentDao(Connection con, Table tableName) {
        super(con, tableName.toString());
    }

    @Override
    public int count() throws SQLException {
        return 0;
    }
}
