package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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

    private boolean checkEnoughArgs() {
        boolean result = false;
        if (arguments != null && type != null) {
            if (arguments.size() == type.getArgsAmount())
                return true;
        }
        return result;
    }

    public boolean checkWrongArgs() {
        int argsAmount = arguments.size();
        if (!checkEnoughArgs()) {
            return false;
        }
        Class<?>[] paramClassTypeList = type.getParamClassTypeList();
        for (int i = 0; i < argsAmount; i++) {
            try {
                paramClassTypeList[i].cast(arguments.get(i));
            } catch (ClassCastException e) {
                logger.warn("Argument \"{}\" has wrong type \"{}\"", arguments.get(i), paramClassTypeList[i]);
                return false;
            }
        }
        return true;
    }
}
