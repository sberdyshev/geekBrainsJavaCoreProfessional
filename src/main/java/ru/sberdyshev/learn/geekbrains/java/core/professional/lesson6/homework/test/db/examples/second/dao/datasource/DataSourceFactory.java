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
        logger.debug("Trying to get postgresql data source");
        Properties props = new Properties();
        InputStream is;
        PGSimpleDataSource postgresqlDS = null;
        try {
            is = new BufferedInputStream(new FileInputStream("C:\\Users\\SBerdyshev\\IdeaProjects\\geekBrainsJavaCoreProfessional\\src\\main\\resources\\db.properties"));
            props.load(is);
            postgresqlDS = new PGSimpleDataSource();
            String postgresqlDbName = props.getProperty("POSTGRESQL_DB_NAME");
            Integer postgresqlDbPort = Integer.parseInt(props.getProperty("POSTGRESQL_DB_PORT"));
            String postgresqlDbUsername = props.getProperty("POSTGRESQL_DB_USERNAME");
            String postgresqlDbPassword = props.getProperty("POSTGRESQL_DB_PASSWORD");
            String postgresqlDbIp = props.getProperty("POSTGRESQL_DB_IP");
            postgresqlDS.setDatabaseName(postgresqlDbName);
            postgresqlDS.setPortNumber(postgresqlDbPort);
            postgresqlDS.setServerName(postgresqlDbIp);
            postgresqlDS.setUser(postgresqlDbUsername);
            postgresqlDS.setPassword(postgresqlDbPassword);
            logger.debug("Got postgresql data source with db name \"{}\", db port \"{}\", db ip \"{}\", db username \"{}\", db password \"{}\"", postgresqlDbName, postgresqlDbPort, postgresqlDbIp, postgresqlDbUsername, postgresqlDbPassword);
        } catch (IOException e) {
            logger.error("Couldn't get connection to postresql", e);
        }
        return postgresqlDS;
    }
}
