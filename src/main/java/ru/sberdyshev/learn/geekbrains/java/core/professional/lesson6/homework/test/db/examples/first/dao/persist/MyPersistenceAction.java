package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.dao.persist;

public class MyPersistenceAction extends PersistenceActionBase {

    public MyPersistenceAction(DaoManager manager){
        super(manager);
    }

    public void doPersistenceAction(DaoManager manager){

        Person person = manager.getPersonDao().readPerson(666);
        person.setLastName("Nick");
        manager.getPersonDao().updatePerson(person);

    }
}
