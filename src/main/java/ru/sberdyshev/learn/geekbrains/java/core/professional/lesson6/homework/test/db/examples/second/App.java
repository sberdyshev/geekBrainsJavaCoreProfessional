package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.DaoManager;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.StudentDao;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.table.Table;

import java.sql.SQLException;

/**
 * @author sberdyshev
 */
public class App {
    public static void main(String[] args) {
        DaoManager daoManager = DaoManager.getInstance();
        StudentDao studentDao;
        try {
            studentDao = (StudentDao) daoManager.getDao(Table.STUDENT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentDao
    }
}
