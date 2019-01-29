package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.first;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.dao.DaoCommand;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.dao.DaoManager;

/**
 * @author sberdyshev
 */
public class App {
    public static void main(String[] args) {

        DaoManager daoManager = daoFactory.createDaoManager();
        Person person = (Person)
                daoManager.executeAndClose(new DaoCommand() {

                    public Object execute(DaoManager manager) {
                        return manager.getPersonDao().readPerson(666);
                    }
                });

        daoManager.transaction(new DaoCommand(){

            public Object execute(DaoManager manager){
                Person person = manager.getPersonDao().readPerson(666);
                person.setLastName("Nick");
                manager.getPersonDao().updatePerson(person);
            }

        });
    }


}
