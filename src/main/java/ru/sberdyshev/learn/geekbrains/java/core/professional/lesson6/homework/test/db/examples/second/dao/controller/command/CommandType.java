package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sberdyshev
 */
@Getter
public enum CommandType {
    GET_STUDENT("/getStud", "Get student info. Format - \"/getStud <id (integer)>\".", 1, Integer.class),
    GET_STUDENTS("/getAllStuds", "Get all student info. Format - \"/getAllStuds\".", 0),
    ADD_STUDENT("/addStud", "Add student. Format - \"/addStud <id (integer)> <name (string)> <average score (string)>\".", 3, Integer.class, String.class, String.class),
    UPDATE_STUDENT("/updStud", "Update student info. Format - \"/updStud <current id (integer)> <new name (string)> <new average score (string)>\".", 3, Integer.class, String.class, String.class),
    HELP("/help", "Get command list. Format - \"/help\".", 0),
    EXIT("/exit", "Exit. Format - \"/exit\".", 0),
    NONE(null, null, 0);

    private final static Logger logger = LoggerFactory.getLogger(CommandType.class);
    private String commandName;
    private String commandDescr;
    private int argsAmount;
    private Class<?>[] paramClassTypeList;

    public int getArgsAmount() {
        return argsAmount;
    }

    CommandType(String commandName, String commandDescr, int argsAmount, Class<?>... paramClassTypeList) {
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
