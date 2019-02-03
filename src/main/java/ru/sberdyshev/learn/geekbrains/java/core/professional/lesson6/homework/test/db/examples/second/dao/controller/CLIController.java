package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command.Command;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command.CommandType;

/**
 * @author sberdyshev
 */
public interface CLIController extends Controller {
    Command parse(String line);

    default void showEnterCommandInvitation() {
        System.out.print("Enter your command: ");
    }

    default void showWrongArgsMessage() {
        System.out.println("Wrong amount or type af arguments, try one more time.");
    }

    default void showGoodBuyMessage() {
        System.out.println("Thank you for using this, buy-buy!");
    }

    default void showExaustedTriesMessage() {
        System.out.println("You entered too many wrong commands. You are tired, probably. Try next time.");
    }

    default void showWrongCommandMessage() {
        System.out.println("Wrong command. Try " + CommandType.HELP.getCommandName());
    }

    @Override
    default void showCommands() {
        CommandType[] commandList = CommandType.values();
        for (CommandType commandType : commandList) {
            System.out.println("Command: " + commandType.getCommandName() + ". Description: " + commandType.getCommandDescr());
        }
    }
}
