package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.control;

import java.util.ArrayList;
import java.util.List;

public class CommandController {

    public static final String getCostCLICommand = "/цена ";
    public static final String changeCostCLICommand = "/сменитьцену ";
    public static final String getGoodsInACostRangeCLICommand = "/товарыпоцене ";
    public static final String exitCLICommand = "/выход";

    private CommandController() {
    }

    public static Command parse(String line) {
        if (line.startsWith(getCostCLICommand)) {
            List<String> args = getArgs(line, 1);
            return new Command(CommandType.GET_COST, args);
        } else if ((line.startsWith(changeCostCLICommand))) {
            List<String> args = getArgs(line, 2);
            return new Command(CommandType.CHANGE_COST, args);
        } else if ((line.startsWith(getGoodsInACostRangeCLICommand))) {
            List<String> args = getArgs(line, 2);
            return new Command(CommandType.GET_GOODS_IN_A_COST_RANGE, args);
        } else if ((line.startsWith(exitCLICommand))) {
            return new Command(CommandType.EXIT);
        } else {
            return new Command(CommandType.NONE);
        }
    }

    public static List<String> getArgs(String line, int argsAmount) {
        ArrayList<String> args = new ArrayList<>();
        int leadingIndexOfWhiteSpaceForAPreviousCommand = 0;
        int leadingIndexOfWhiteSpace = 0;
        int trailingIndexOfWhiteSpace = 0;
        for (int i = 0; i < argsAmount; i++) {
            leadingIndexOfWhiteSpace = line.indexOf(' ', leadingIndexOfWhiteSpaceForAPreviousCommand+1);
            trailingIndexOfWhiteSpace = line.indexOf(' ', leadingIndexOfWhiteSpace+1);
            String arg = null;
            if (leadingIndexOfWhiteSpace >= trailingIndexOfWhiteSpace) {
                arg = line.substring(leadingIndexOfWhiteSpace).trim();
            } else {
                arg = line.substring(leadingIndexOfWhiteSpace, trailingIndexOfWhiteSpace).trim();
            }
            if ("".equals(arg)) {
                arg = null;
            }
            args.add(arg);
            leadingIndexOfWhiteSpaceForAPreviousCommand = leadingIndexOfWhiteSpace;
        }
        return args;
    }
}
