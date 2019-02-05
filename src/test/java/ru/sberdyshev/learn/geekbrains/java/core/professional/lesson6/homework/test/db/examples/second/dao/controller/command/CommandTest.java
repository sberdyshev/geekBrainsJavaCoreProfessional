package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {


    @Test
    public void checkArgsAreCorrrectAddStudentCorrect() {
        CommandType commandType = CommandType.ADD_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("3", "String", "String"));
        boolean expectedResult = true;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectAddStudentWrongFirstArgSrtring() {
        CommandType commandType = CommandType.ADD_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("String", "String", "String"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectAddStudentWrongFirstArgDouble() {
        CommandType commandType = CommandType.ADD_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("3.56", "String", "String"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectAddStudentWrongFirstArgNull() {
        CommandType commandType = CommandType.ADD_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList(null, "String", "String"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectAddStudentWrongSecondArgNull() {
        CommandType commandType = CommandType.ADD_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("3", null, "String"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectAddStudentWrongThirdArgNull() {
        CommandType commandType = CommandType.ADD_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("3", "String", null));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectAddStudentWrongNoArgs() {
        CommandType commandType = CommandType.ADD_STUDENT;
        List<String> arguments = new ArrayList<>();
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectAddStudentWrongNoArgs() {
        CommandType commandType = CommandType.ADD_STUDENT;
        List<String> arguments = new ArrayList<>();
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}