package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;
        Command command = (Command) o;
        return getType() == command.getType() &&
                Objects.equals(arguments, command.arguments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), arguments);
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
            logger.debug("Command type {}. Amount of params {}. Expected amount {}. Arguments are incorrect.", type, argsAmount, type.getArgsAmount());
            return false;
        }
        for (int i = 0; i < arguments.size(); i++) {
            if (arguments.get(i) == null) {
                logger.debug("Command type {}. Argument #{} is null. Arguments are incorrect.", type, i + 1);
                return false;
            }
        }
        switch (type) {
            case GET_STUDENT:
                if (argsAmount == GET_STUDENT.getArgsAmount()) {
                    try {
                        Integer.parseInt(arguments.get(0));
                        logger.debug("Command type {}. Param {} is an integer. Amount of params {}. Expected amount {}. Arguments are correct.", type, arguments.get(0), argsAmount, GET_STUDENT.getArgsAmount());
                        return true;
                    } catch (NumberFormatException e) {
                        logger.debug("Command type {}. Param {} is not an integer. Amount of params {}. Expected amount {}. Arguments are not correct.", type, arguments.get(0), argsAmount, GET_STUDENT.getArgsAmount());
                        return false;
                    }
                } else {
                    logger.debug("Command type {}. Amount of params {}. Expected amount {}. Arguments are not correct.", type, argsAmount, GET_STUDENT.getArgsAmount());
                    return false;
                }
            case ADD_STUDENT:
                if (argsAmount == ADD_STUDENT.getArgsAmount()) {
                    try {
                        Integer.parseInt(arguments.get(0));
                        logger.debug("Command type {}. Param {} is an integer. Amount of params {}. Expected amount {}. Arguments are correct.", type, arguments.get(0), argsAmount, ADD_STUDENT.getArgsAmount());
                        return true;
                    } catch (NumberFormatException e) {
                        logger.debug("Command type {}. Param {} is not an integer. Amount of params {}. Expected amount {}. Arguments are not correct.", type, arguments.get(0), argsAmount, ADD_STUDENT.getArgsAmount());
                        return false;
                    }
                } else {
                    logger.debug("Command type {}. Amount of params {}. Expected amount {}. Arguments are not correct.", type, argsAmount, ADD_STUDENT.getArgsAmount());
                    return false;
                }
            case EXIT:
                if (argsAmount == EXIT.getArgsAmount()) {
                    logger.debug("Command type {}. Amount of params {}. Expected amount {}. Arguments are correct.", type, argsAmount, EXIT.getArgsAmount());
                    return true;
                } else {
                    logger.debug("Command type {}. Amount of params {}. Expected amount {}. Arguments are not correct.", type, argsAmount, EXIT.getArgsAmount());
                    return false;
                }
            case HELP:
                if (argsAmount == HELP.getArgsAmount()) {
                    logger.debug("Command type {}. Amount of params {}. Expected amount {}. Arguments are correct.", type, argsAmount, HELP.getArgsAmount());
                    return true;
                } else {
                    logger.debug("Command type {}. Amount of params {}. Expected amount {}. Arguments are not correct.", type, argsAmount, HELP.getArgsAmount());
                    return false;
                }
            case NONE:
                logger.debug("Command type {}. Not supported command always has correct amount of arguments", type);
                return true;
            case GET_STUDENTS:
                if (argsAmount == GET_STUDENTS.getArgsAmount()) {
                    logger.debug("Command type {}. Amount of params {}. Expected amount {}. Arguments are correct.", type, argsAmount, GET_STUDENTS.getArgsAmount());
                    return true;
                } else {
                    logger.debug("Command type {}. Amount of params {}. Expected amount {}. Arguments are not correct.", type, argsAmount, GET_STUDENTS.getArgsAmount());
                    return false;
                }
            case UPDATE_STUDENT:
                if (argsAmount == ADD_STUDENT.getArgsAmount()) {
                    try {
                        Integer.parseInt(arguments.get(0));
                        logger.debug("Command type {}. Param {} is an integer. Amount of params {}. Expected amount {}. Arguments are correct.", type, arguments.get(0), argsAmount, UPDATE_STUDENT.getArgsAmount());
                        return true;
                    } catch (NumberFormatException e) {
                        logger.debug("Command type {}. Param {} is not an integer. Amount of params {}. Expected amount {}. Arguments are not correct.", type, arguments.get(0), argsAmount, UPDATE_STUDENT.getArgsAmount());
                        return false;
                    }
                } else {
                    logger.debug("Command type {}. Amount of params {}. Expected amount {}. Arguments are not correct.", type, argsAmount, UPDATE_STUDENT.getArgsAmount());
                    return false;
                }
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong command type " + type);
                logger.error(illegalArgumentException.getLocalizedMessage(), illegalArgumentException);
                break;
        }
        return true;
    }
}
