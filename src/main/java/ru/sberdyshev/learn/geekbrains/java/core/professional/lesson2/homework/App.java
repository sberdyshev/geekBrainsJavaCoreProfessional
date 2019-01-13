package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.constants.AppConstants;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.control.Command;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.control.CommandController;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.dao.GoodsDao;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.dao.GoodsJdbcImplDao;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.model.Good;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GoodsDao goodsJdbcCaller = new GoodsJdbcImplDao();
        boolean isExit = false;
        int tryCount = 0;
        do {
            System.out.print("Введите вашу команду: ");
            Command command = CommandController.parse(scanner.nextLine());
            if (command.checkWrongArgs()) {
                System.out.println("Неверный тип аргументов или аргументов не хватает, попробуйте еще");
                tryCount += 1;
            } else {
                switch (command.getType()) {
                    case EXIT:
                        System.out.println("Спасибо за использование, до свидания!");
                        isExit = true;
                        break;
                    case NONE:
                        if (tryCount == AppConstants.getTryCount()) {
                            System.out.println("Вы ввели слишком много неверных команд. Возможно, вы устали. Попробуйте в другой раз. До свидания.");
                            isExit = true;
                        } else {
                            tryCount += 1;
                            System.out.println("Неверная команда, попробуйте еще.");
                        }
                        break;
                    case CHANGE_COST: {
                        tryCount = 0;
                        String title = command.getArgAtPos(0);
                        Double cost = Double.parseDouble(command.getArgAtPos(1));
                        int updatedRows = goodsJdbcCaller.changeGoodPrice(title, cost);
                        if (updatedRows > 0) {
                            System.out.println("Обновлено " + updatedRows + " строк.");
                        } else {
                            System.out.println("Данные не обновлены.");
                        }
                    }
                    break;
                    case GET_GOODS_IN_A_COST_RANGE: {
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
                    }
                    break;
                    case GET_COST: {
                        String title = command.getArgAtPos(0);
                        Double cost = goodsJdbcCaller.getGoodPrice(title);
                        if (cost != null) {
                            System.out.println("Цена на " + title + " - " + cost + ".");
                            tryCount = 0;
                        } else {
                            System.out.println("Не нашлось подходящих товаров. Попробуйте еще раз.");
                            tryCount += 1;
                        }

                    }
                    break;
                }
            }

        } while (!isExit);
    }
}

