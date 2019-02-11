package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller;

import org.junit.Test;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.StudentDao;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command.Command;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command.CommandType;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentAppCLIControllerTest {

    @Test
    public void parseCommandAddStudent() {
        String sourceCommand = "/addStudent";
        Command expectedCommand = new Command(CommandType.ADD_STUDENT, new ArrayList<String>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }
}