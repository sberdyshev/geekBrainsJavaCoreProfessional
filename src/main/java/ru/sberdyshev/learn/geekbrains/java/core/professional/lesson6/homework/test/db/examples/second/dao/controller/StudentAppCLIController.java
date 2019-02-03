package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command.Command;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command.CommandType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sberdyshev
 */
public class StudentAppCLIController implements CLIController {
    private final int maxTryCount;

    public StudentAppCLIController(int maxTryCount) {
        this.maxTryCount = maxTryCount;
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
//        GoodsDao goodsJdbcCaller = new GoodsJdbcImplDao();
        boolean isExit = false;
        int tryCount = 0;
        do {
            showEnterCommandInvitation();
            Command command = parse(scanner.nextLine());
            if (command.checkWrongArgs()) {
                showWrongArgsMessage();
                tryCount += 1;
            } else {
                switch (command.getType()) {
                    case EXIT:
                        processExit();
                        isExit = true;
                        break;
                    case ADD_STUDENT: {
                        tryCount = 0;
                        String title = command.getArgAtPos(0);
                        Double cost = Double.parseDouble(command.getArgAtPos(1));
                        int updatedRows = goodsJdbcCaller.changeGoodPrice(title, cost);
                        if (updatedRows > 0) {
                            System.out.println("Обновлено " + updatedRows + " строк.");
                        } else {
                            System.out.println("Данные не обновлены.");
                        }
                        break;
                    }
                    case GET_STUDENT: {
                        boolean foundSmth = false;
                        Double lowestCost = Double.parseDouble(command.getArgAtPos(0));
                        Double highestCost = Double.parseDouble(command.getArgAtPos(1));
                        List<Good> goods = goodsJdbcCaller.getGoodsWithSpecificPrice(lowestCost, highestCost);
                        for (Good good : goods) {
                            System.out.println("Товар: " + good.getTitle() + ". Цена: " + good.getCost() + ".");
                            foundSmth = true;
                            tryCount = 0;
                        }
                        if (!foundSmth) {
                            System.out.println("Не нашлось подходящих товаров. Попробуйте еще раз.");
                            tryCount += 1;
                        }
                        break;
                    }
                    case GET_STUDENTS: {
                        String title = command.getArgAtPos(0);
                        Double cost = goodsJdbcCaller.getGoodPrice(title);
                        if (cost != null) {
                            System.out.println("Цена на " + title + " - " + cost + ".");
                            tryCount = 0;
                        } else {
                            System.out.println("Не нашлось подходящих товаров. Попробуйте еще раз.");
                            tryCount += 1;
                        }
                        break;
                    }
                    case UPDATE_STUDENT: {
                        String title = command.getArgAtPos(0);
                        Double cost = goodsJdbcCaller.getGoodPrice(title);
                        if (cost != null) {
                            System.out.println("Цена на " + title + " - " + cost + ".");
                            tryCount = 0;
                        } else {
                            System.out.println("Не нашлось подходящих товаров. Попробуйте еще раз.");
                            tryCount += 1;
                        }
                        break;
                    }
                    case HELP: {
                        String title = command.getArgAtPos(0);
                        Double cost = goodsJdbcCaller.getGoodPrice(title);
                        if (cost != null) {
                            System.out.println("Цена на " + title + " - " + cost + ".");
                            tryCount = 0;
                        } else {
                            System.out.println("Не нашлось подходящих товаров. Попробуйте еще раз.");
                            tryCount += 1;
                        }
                        break;
                    }
                    default: {
                        if (tryCount == maxTryCount) {
                            showExaustedTriesMessage();
                            showGoodBuyMessage();
                            isExit = true;
                        } else {
                            tryCount += 1;
                            showWrongCommandMessage();
                        }
                        break;
                    }
                }
            }
        } while (!isExit);
    }

    @Override
    public Command parse(String line) {
        for (CommandType commandType : CommandType.values()) {
            if (line.startsWith(commandType.getCommandName())) {
                List<String> args = getArgs(line, commandType);
                return new Command(commandType, args);
            }
        }
        return null;
    }

    private List<String> getArgs(String line, CommandType commandType) {
        List<String> args = new ArrayList<>();
        String lineWithoutCommand = line.substring(commandType.getCommandDescr().length());
        int leadingIndexOfWhiteSpaceForAPreviousCommand = 0;
        int leadingIndexOfWhiteSpace = 0;
        int trailingIndexOfWhiteSpace = 0;
        for (int i = 0; i < commandType.getArgsAmount(); i++) {
            leadingIndexOfWhiteSpace = lineWithoutCommand.indexOf(' ', leadingIndexOfWhiteSpaceForAPreviousCommand);
            trailingIndexOfWhiteSpace = lineWithoutCommand.indexOf(' ', leadingIndexOfWhiteSpace + 1);
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

    private void processGetStudent() {

    }

    private void processGetAllStudents() {

    }

    private void processAddStudent() {

    }

    private void processUpdateStudent() {

    }

    private void processHelp() {

    }

    private void processExit() {
        showGoodBuyMessage();
    }
}
