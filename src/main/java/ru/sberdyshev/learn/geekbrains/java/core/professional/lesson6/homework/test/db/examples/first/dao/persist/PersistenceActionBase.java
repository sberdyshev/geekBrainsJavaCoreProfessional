package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.dao.persist;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.dao.DaoCommand;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.dao.DaoManager;

public class PersistenceActionBase {
    protected DaoManager daoManager = null;

    public PersistenceActionBase(DaoManager manager){
        this.daoManager = manager;
    }

    public void doAction() {
        this.daoManager.transactionAndClose(new DaoCommand(){
            public Object execute(DaoManager manager){
                doPersistenceAction(manager);
            }
        });
    }

    protected void doPersistenceAction(DaoManager manager){
        //override this method in subclasses.
    }
}
