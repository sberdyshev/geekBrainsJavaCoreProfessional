package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.dao;

/**
 * @author sberdyshev
 */
public class DaoManager {
//    protected Connection connection = null;
//    protected PersonDao personDao = null;
//
//    public DaoManager(Connection connection) {
//        this.connection = connection;
//    }
//
//    public PersonDao getPersonDao() {
//        if (this.personDao == null) {
//            this.personDao = new PersonDao(this.connection);
//        }
//        return this.personDao;
//    }
//
//    public Object transaction(DaoCommand command) {
//        try {
//            this.connection.setAutoCommit(false);
//            Object returnValue = command.execute(this);
//            this.connection.commit();
//            return returnValue;
//        } catch (Exception e) {
//            this.connection.rollback();
//            throw e; //or wrap it before rethrowing it
//        } finally {
//            this.connection.setAutoCommit(true);
//        }
//    }
//
//    public Object transactionAndClose(DaoCommand command){
//        executeAndClose(new DaoCommand(){
//            public Object execute(DaoManager manager){
//                manager.transaction(command);
//            }
//        });
//    }

    protected DataSource dataSource = null;
    protected Connection connection = null;

    protected PersonDao  personDao  = null;

    public DaoManager(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public PersonDao getPersonDaoTx(){
        if(this.personDao == null){
            this.personDao = new PersonDao(getTxConnection());
        }
        return this.personDao;
    }

    protected Connection getConnection(){
        if(this.connection == null){
            this.connection = dataSource.getConnection();
        }
    }

    protected Connection getTxConnection(){
        getConnection().setAutoCommit(false);
    }

    public Object transaction(DaoCommand command){
        try{
            Object returnValue = command.execute(this);
            getConnection().commit();
            return returnValue;
        } catch(Exception e){
            getConnection().rollback();
            throw e; //or wrap it before rethrowing it
        } finally {
            getConnection().setAutoCommit(true);
        }
    }

    public Object executeAndClose(DaoCommand command){
        try{
            return command.execute(this);
        } finally {
            getConnction().close();
        }
    }

    public Object transactionAndClose(DaoCommand command){
        executeAndClose(new DaoCommand(){
            public Object execute(DaoManager manager){
                manager.transaction(command);
            }
        });
    }
}