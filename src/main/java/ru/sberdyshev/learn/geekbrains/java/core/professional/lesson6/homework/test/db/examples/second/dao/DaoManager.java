package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.datasource.DataSourceFactory;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.table.Table;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author sberdyshev
 */
public class DaoManager {
    private final static Logger logger = LoggerFactory.getLogger(DaoManager.class);

    private DataSource dataSource;
    private Connection connection;

    private DaoManager() {
        this.dataSource = DataSourceFactory.getPostgreSQLDataSource();
    }

    public static DaoManager getInstance() {
        return DAOManagerSingleton.INSTANCE.get();
    }

    public void open() throws SQLException {
        try {
            if (this.connection == null || this.connection.isClosed())
                this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("Connection opening error", e);
            throw e;
        }
    }

    public void close() throws SQLException {
        try {
            if (this.connection != null && !this.connection.isClosed())
                this.connection.close();
        } catch (SQLException e) {
            logger.error("Connection closing error", e);
            throw e;
        }
    }

    public GenericDao getDao(Table table) throws SQLException {
        try {
            if (this.connection == null || this.connection.isClosed())
                this.open();
        } catch (SQLException e) {
            logger.error("Couldn't open a connection to the DB", e);
            throw e;
        }
        switch (table) {
            case STUDENT:
                return new StudentDao(this.connection, Table.STUDENT);
            default:
                String errorDescr = "Trying to link to an unexistant table.";
                SQLException e = new SQLException(errorDescr);
                logger.error(errorDescr, e);
                throw e;
        }
    }

    private static class DAOManagerSingleton {

        public static final ThreadLocal<DaoManager> INSTANCE;

        static {
            ThreadLocal<DaoManager> dm;
            dm = ThreadLocal.withInitial(() -> new DaoManager());
            INSTANCE = dm;
        }
    }
}
