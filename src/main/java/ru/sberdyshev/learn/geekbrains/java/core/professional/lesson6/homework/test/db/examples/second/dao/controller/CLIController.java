package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command.Command;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command.CommandType;

/**
 * @author sberdyshev
 */
public interface CLIController extends Controller {
    public Command parse(String line);

    public default void showEnterCommandInvitation() {
        System.out.print("Enter your command: ");
    }

    @Override
    public default void showCommands() {
        CommandType[] commandList = CommandType.values();
        for (CommandType commandType: commandList) {
            System.out.println("Команда: " + commandType.getCommandName() + ". Описание: " + commandType.getCommandDescr());
        }
    }
}
