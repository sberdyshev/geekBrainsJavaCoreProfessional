package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author sberdyshev
 */
public class DaoManager {

    private DataSource dataSource;
    private Connection connection;

    private DaoManager() throws Exception {
        try {
            //TODO change code to general data source creation
            InitialContext ctx = new InitialContext();
            this.dataSource = (DataSource) ctx.lookup("jndi/MYSQL"); //The string should be the same name you're giving to your JNDI in Glassfish.
        } catch (Exception e) {
            throw e;
        }
    }

    public static DaoManager getInstance() {
        return DAOManagerSingleton.INSTANCE;
    }

    public void open() throws SQLException {
        try {
            if (this.connection == null || !this.connection.isOpen())
                this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void close() throws SQLException {
        try {
            if (this.connection != null && this.connection.isOpen())
                this.connection.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    private static class DAOManagerSingleton {

        public static final ThreadLocal<DaoManager> INSTANCE;

        static {
            ThreadLocal<DaoManager> dm;
            try {
                dm = new ThreadLocal<DaoManager>() {
                    @Override
                    protected DaoManager initialValue() {
                        try {
                            return new DaoManager();
                        } catch (Exception e) {
                            return null;
                        }
                    }
                };
            } catch (Exception e) {
                dm = null;
            }
            INSTANCE = dm;
        }
    }
}
