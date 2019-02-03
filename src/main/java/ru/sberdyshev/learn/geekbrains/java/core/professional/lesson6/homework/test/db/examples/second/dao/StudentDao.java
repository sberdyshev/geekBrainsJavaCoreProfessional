package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.table.Table;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.entity.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

    @Override
    public List<Student> getEntities() throws SQLException {
        return null;
    }

    @Override
    public Student getEntity(Integer id) throws SQLException {
        return null;
    }

    @Override
    public boolean updateEntity(Student entity) throws SQLException {
        return false;
    }

    @Override
    public boolean addEntity(Student entity) throws SQLException, IllegalArgumentException {
        return false;
    }
}
