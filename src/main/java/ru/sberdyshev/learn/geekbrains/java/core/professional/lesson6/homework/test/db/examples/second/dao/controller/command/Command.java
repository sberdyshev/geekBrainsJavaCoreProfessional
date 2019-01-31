package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author sberdyshev
 */
public class Command {
    @Getter
    private CommandType commandType;
    private List<String> arguments;
    private final static Logger logger = LoggerFactory.getLogger(Command.class);

    public Command(CommandType commandType, List<String> arguments) {
        this.commandType = commandType;
        this.arguments = arguments;
    }

    public String getArgAtPos(int position) {
        return arguments != null ? arguments.get(position) : null;
    }

    private boolean checkEnoughArgs() {
        boolean result = false;
        if (arguments != null && commandType != null) {
            if (arguments.size() == commandType.getArgsAmount())
                return true;
        }
//        for (int i = 0; i < argsAmount; i++) {
//            try {
//                String arg = arguments.get(i);
//                if (arg == null) {
//                    result = false;
//                }
//            } catch (IndexOutOfBoundsException e) {
//                result = false;
//            }
//        }
        return result;
    }

    public boolean checkWrongArgs() {
        int argsAmount = arguments.size();
        if(!checkEnoughArgs()) {
            return false;
        }
        Class<?>[] paramClassTypeList = commandType.getParamClassTypeList();
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
