package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.datasource;

import org.postgresql.ds.PGSimpleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author sberdyshev
 */
public class DataSourceFactory {
    private final static Logger logger = LoggerFactory.getLogger(DataSourceFactory.class);

    public static DataSource getPostgreSQLDataSource() {
        Properties props = new Properties();
        InputStream is = null;
        PGSimpleDataSource postgresqlDS = null;
        try {
            is = new BufferedInputStream(new FileInputStream("db.properties"));
            props.load(is);
            postgresqlDS = new PGSimpleDataSource();
            postgresqlDS.setDatabaseName(props.getProperty("POSTGRESQL_DB_NAME"));
            postgresqlDS.setPortNumber(Integer.getInteger(props.getProperty("POSTGRESQL_DB_PORT")));
            postgresqlDS.setServerName(props.getProperty("POSTGRESQL_DB_IP"));
            postgresqlDS.setUser(props.getProperty("POSTGRESQL_DB_USERNAME"));
            postgresqlDS.setPassword(props.getProperty("POSTGRESQL_DB_PASSWORD"));
        } catch (IOException e) {
            logger.error("Couldn't get connection to postresql", e);
        }
        return postgresqlDS;
    }
}
