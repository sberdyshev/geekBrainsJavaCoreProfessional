package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command.CommandType.*;

/**
 * @author sberdyshev
 */
public class Command {
    private final static Logger logger = LoggerFactory.getLogger(Command.class);
    @Getter
    private CommandType type;
    private List<String> arguments;

    public Command(CommandType type, List<String> arguments) {
        this.type = type;
        this.arguments = arguments;
    }

    public String getArgAtPos(int position) {
        return arguments != null ? arguments.get(position) : null;
    }

    private boolean checkEnoughArgs(int argsAmount) {
        boolean result = false;
        if (arguments != null && type != null) {
            if (arguments.size() == argsAmount)
                return true;
        }
        return result;
    }

    public boolean checkArgsAreCorrrect() {
        int argsAmount = arguments.size();
        if (!checkEnoughArgs(argsAmount)) {
            return false;
        }
        for (String argument : arguments) {
            if (argument == null)
                return false;
        }
        switch (type) {
            case GET_STUDENT:
                if (argsAmount == GET_STUDENT.getArgsAmount()) {
                    try {
                        Integer.parseInt(arguments.get(0));
                        logger.debug("Param {} is an integer. Amount of params {}. Expected amount {}. Arguments are correct.", arguments.get(0), argsAmount, GET_STUDENT.getArgsAmount());
                        return true;
                    } catch (NumberFormatException e) {
                        logger.debug("Param {} is not an integer. Amount of params {}. Expected amount {}. Arguments are not correct.", arguments.get(0), argsAmount, GET_STUDENT.getArgsAmount());
                        return false;
                    }
                } else {
                    logger.debug("Amount of params {}. Expected amount {}. Arguments are not correct.", argsAmount, GET_STUDENT.getArgsAmount());
                    return false;
                }
            case ADD_STUDENT:
                if (argsAmount == ADD_STUDENT.getArgsAmount()) {
                    try {
                        Integer.parseInt(arguments.get(0));
                        logger.debug("Param {} is an integer. Amount of params {}. Expected amount {}. Arguments are correct.", arguments.get(0), argsAmount, GET_STUDENT.getArgsAmount());
                        return true;
                    } catch (NumberFormatException e) {
                        logger.debug("Param {} is not an integer. Amount of params {}. Expected amount {}. Arguments are not correct.", arguments.get(0), argsAmount, GET_STUDENT.getArgsAmount());
                        return false;
                    }
                } else {
                    logger.debug("Amount of params {}. Expected amount {}. Arguments are not correct.", argsAmount, GET_STUDENT.getArgsAmount());
                    return false;
                }
            case EXIT:
                if (argsAmount == EXIT.getArgsAmount()) {
                    logger.debug("Amount of params {}. Expected amount {}. Arguments are correct.", argsAmount, GET_STUDENT.getArgsAmount());
                    return true;
                } else {
                    logger.debug("Amount of params {}. Expected amount {}. Arguments are not correct.", argsAmount, GET_STUDENT.getArgsAmount());
                    return false;
                }
            case HELP:
                if (argsAmount == HELP.getArgsAmount()) {
                    logger.debug("Amount of params {}. Expected amount {}. Arguments are correct.", argsAmount, GET_STUDENT.getArgsAmount());
                    return true;
                } else {
                    logger.debug("Amount of params {}. Expected amount {}. Arguments are not correct.", argsAmount, GET_STUDENT.getArgsAmount());
                    return false;
                }
            case NONE:
                logger.debug("Not supported command always has correct amount of arguments");
                return true;
            case GET_STUDENTS:
                if (argsAmount == GET_STUDENTS.getArgsAmount()) {
                    logger.debug("Amount of params {}. Expected amount {}. Arguments are correct.", argsAmount, GET_STUDENT.getArgsAmount());
                    return true;
                } else {
                    logger.debug("Amount of params {}. Expected amount {}. Arguments are not correct.", argsAmount, GET_STUDENT.getArgsAmount());
                    return false;
                }
            case UPDATE_STUDENT:
                if (argsAmount == ADD_STUDENT.getArgsAmount()) {
                    try {
                        Integer.parseInt(arguments.get(0));
                        logger.debug("Param {} is an integer. Amount of params {}. Expected amount {}. Arguments are correct.", arguments.get(0), argsAmount, GET_STUDENT.getArgsAmount());
                        return true;
                    } catch (NumberFormatException e) {
                        logger.debug("Param {} is not an integer. Amount of params {}. Expected amount {}. Arguments are not correct.", arguments.get(0), argsAmount, GET_STUDENT.getArgsAmount());
                        return false;
                    }
                } else {
                    logger.debug("Amount of params {}. Expected amount {}. Arguments are not correct.", argsAmount, GET_STUDENT.getArgsAmount());
                    return false;
                }
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong command type");
                logger.error(illegalArgumentException.getLocalizedMessage(), illegalArgumentException);
                break;
        }
        /*Class<?>[] paramClassTypeList = type.getParamClassTypeList();
        for (int i = 0; i < argsAmount; i++) {
            try {
                paramClassTypeList[i].cast(arguments.get(i));
            } catch (ClassCastException e) {
                logger.warn("Argument \"{}\" has wrong type \"{}\"", arguments.get(i), paramClassTypeList[i]);
                return false;
            }
        }*/
        return true;
    }
}
