package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sberdyshev
 */
@Getter
public enum CommandType {
    GET_STUDENT("/получить студента", "Получить информацию о студенте. Формат - \"/получить студента <id>\".", 1, Integer.class),
    GET_STUDENTS("/получить студентов", "Получить информацию обо всех студентах. Формат - \"/получить студентов\".", 0),
    ADD_STUDENT("/добавить студента", "Добавить студента. Формат - \"/добавить студента <id> <имя студента> <средний балл студента>\".", 3, Integer.class, String.class, String.class),
    UPDATE_STUDENT("/обновить студента", "Обновить информацию о студенте. Формат - \"/обновить студента <id> <новое имя студента> <новый средний балл студента>\".", 3, Integer.class, String.class, String.class),
    SHOW_COMMANDS("/команды", "Получить список команд. Формат - \"/команды\".", 0),
    EXIT("/выход", "Выйти из приложения. Формат - \"/выход\".", 0);

    private final static Logger logger = LoggerFactory.getLogger(CommandType.class);
    private String commandName;
    private String commandDescr;
    private int argsAmount;
    private Class<?>[] paramClassTypeList;

    private CommandType(String commandName, String commandDescr, int argsAmount, Class<?>... paramClassTypeList) {
        if (paramClassTypeList.length != argsAmount) {
            IllegalArgumentException e = new IllegalArgumentException("Amount of args should be equal to amount of Class variables");
            throw e;
        }
        this.commandName = commandName;
        this.argsAmount = argsAmount;
        this.commandDescr = commandDescr;
        this.paramClassTypeList = paramClassTypeList;
    }
}
