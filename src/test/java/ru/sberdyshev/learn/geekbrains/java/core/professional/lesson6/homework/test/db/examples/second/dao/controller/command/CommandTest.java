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
    public void checkArgsAreCorrrectAddStudentWrongNotEnoughArgs() {
        CommandType commandType = CommandType.ADD_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("Test"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectAddStudentWrongTooMuchArgs() {
        CommandType commandType = CommandType.ADD_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("Test", "Test", "Test", "Test"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectExitCorrect() {
        CommandType commandType = CommandType.EXIT;
        List<String> arguments = new ArrayList<>();
        boolean expectedResult = true;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectExitWrongOneNullArg() {
        CommandType commandType = CommandType.EXIT;
        List<String> arguments = new ArrayList<>();
        arguments.add(null);
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectExitWrongOneStringArg() {
        CommandType commandType = CommandType.EXIT;
        List<String> arguments = new ArrayList<>(Arrays.asList("3.56"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectHelpCorrect() {
        CommandType commandType = CommandType.HELP;
        List<String> arguments = new ArrayList<>();
        boolean expectedResult = true;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectHelpWrongOneNullArg() {
        CommandType commandType = CommandType.HELP;
        List<String> arguments = new ArrayList<>();
        arguments.add(null);
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectHelpWrongOneStringArg() {
        CommandType commandType = CommandType.HELP;
        List<String> arguments = new ArrayList<>(Arrays.asList("3.56"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectUpdateStudentCorrect() {
        CommandType commandType = CommandType.UPDATE_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("3", "String", "String"));
        boolean expectedResult = true;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectUpdateStudentWrongFirstArgSrtring() {
        CommandType commandType = CommandType.UPDATE_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("String", "String", "String"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectUpdateStudentWrongFirstArgDouble() {
        CommandType commandType = CommandType.UPDATE_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("3.56", "String", "String"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectUpdateStudentWrongFirstArgNull() {
        CommandType commandType = CommandType.UPDATE_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList(null, "String", "String"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectUpdateStudentWrongSecondArgNull() {
        CommandType commandType = CommandType.UPDATE_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("3", null, "String"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectUpdateStudentWrongThirdArgNull() {
        CommandType commandType = CommandType.UPDATE_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("3", "String", null));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectUpdateStudentWrongNoArgs() {
        CommandType commandType = CommandType.UPDATE_STUDENT;
        List<String> arguments = new ArrayList<>();
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectUpdateStudentWrongNotEnoughArgs() {
        CommandType commandType = CommandType.UPDATE_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("Test"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectUpdateStudentWrongTooMuchArgs() {
        CommandType commandType = CommandType.UPDATE_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("Test", "Test", "Test", "Test"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectGetStudentCorrect() {
        CommandType commandType = CommandType.GET_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("3"));
        boolean expectedResult = true;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectGetStudentWrongFirstArgSrtring() {
        CommandType commandType = CommandType.GET_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("String"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectGetStudentWrongFirstArgDouble() {
        CommandType commandType = CommandType.GET_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("3.56"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectGetStudentWrongFirstArgNull() {
        CommandType commandType = CommandType.GET_STUDENT;
        List<String> arguments = new ArrayList<>();
        arguments.add(null);
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectGetStudentWrongNoArgs() {
        CommandType commandType = CommandType.GET_STUDENT;
        List<String> arguments = new ArrayList<>();
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectGetStudentWrongTooMuchArgs() {
        CommandType commandType = CommandType.GET_STUDENT;
        List<String> arguments = new ArrayList<>(Arrays.asList("Test", "Test", "Test", "Test"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectGetStudentsCorrect() {
        CommandType commandType = CommandType.GET_STUDENTS;
        List<String> arguments = new ArrayList<>();
        boolean expectedResult = true;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectGetStudentsWrongOneNullArg() {
        CommandType commandType = CommandType.GET_STUDENTS;
        List<String> arguments = new ArrayList<>();
        arguments.add(null);
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void checkArgsAreCorrrectGetStudentsWrongOneStringArg() {
        CommandType commandType = CommandType.GET_STUDENTS;
        List<String> arguments = new ArrayList<>(Arrays.asList("3.56"));
        boolean expectedResult = false;
        Command command = new Command(commandType, arguments);
        boolean actualResult = command.checkArgsAreCorrrect();
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}