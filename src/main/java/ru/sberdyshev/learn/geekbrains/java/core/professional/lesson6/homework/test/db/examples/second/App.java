package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.DaoManager;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.StudentDao;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.StudentAppCLIController;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.table.Table;

import java.sql.SQLException;

/**
 * @author sberdyshev
 */
public class App {
    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        DaoManager daoManager = DaoManager.getInstance();
        StudentDao studentDao;
        try {
            studentDao = (StudentDao) daoManager.getDao(Table.STUDENT);
            StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
            studentAppCLIController.start();
        } catch (SQLException e) {
            logger.error("Couldn't get student dao", e);
        } catch (IllegalStateException e) {
            logger.error("Smth went wrong", e);
        }
    }
}
