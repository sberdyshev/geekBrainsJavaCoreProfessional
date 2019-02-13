package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller;

import org.junit.Test;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.StudentDao;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command.Command;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command.CommandType;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sberdyshev
 */
public class StudentAppCLIControllerTest {

    @Test
    public void parseCommandShitCommand() {
        String sourceCommand = "1349-ryn3914ny0rt109c3y4r-c12 3r102 r021-nr03n712=r3 ";
        Command expectedCommand = new Command(CommandType.NONE, new ArrayList<>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandAddStudentNoArgs() {
        String sourceCommand = "/addStud";
        Command expectedCommand = new Command(CommandType.ADD_STUDENT, new ArrayList<>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandAddStudentWrongFormat() {
        String sourceCommand = "/addStudent";
        Command expectedCommand = new Command(CommandType.NONE, new ArrayList<>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandAddStudentNotEnoughArgs() {
        String sourceCommand = "/addStud 3 String";
        Command expectedCommand = new Command(CommandType.ADD_STUDENT, new ArrayList<>(Arrays.asList("3", "String")));
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandAddStudentEnoughArgs() {
        String sourceCommand = "/addStud 3 String String2";
        Command expectedCommand = new Command(CommandType.ADD_STUDENT, new ArrayList<>(Arrays.asList("3", "String", "String2")));
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandAddStudentTooManyArgs() {
        String sourceCommand = "/addStud 3 String 4 5";
        Command expectedCommand = new Command(CommandType.ADD_STUDENT, new ArrayList<>(Arrays.asList("3", "String", "4", "5")));
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandUpdateStudentNoArgs() {
        String sourceCommand = "/updStud";
        Command expectedCommand = new Command(CommandType.UPDATE_STUDENT, new ArrayList<>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandUpdateStudentWrongFormat() {
        String sourceCommand = "/updStudent";
        Command expectedCommand = new Command(CommandType.NONE, new ArrayList<>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandUpdateStudentNotEnoughArgs() {
        String sourceCommand = "/updStud 3 String";
        Command expectedCommand = new Command(CommandType.UPDATE_STUDENT, new ArrayList<>(Arrays.asList("3", "String")));
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandUpdateStudentEnoughArgs() {
        String sourceCommand = "/updStud 3 String String2";
        Command expectedCommand = new Command(CommandType.UPDATE_STUDENT, new ArrayList<>(Arrays.asList("3", "String", "String2")));
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandUpdateStudentTooManyArgs() {
        String sourceCommand = "/updStud 3 String 4 5";
        Command expectedCommand = new Command(CommandType.UPDATE_STUDENT, new ArrayList<>(Arrays.asList("3", "String", "4", "5")));
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandGetStudentNoArgs() {
        String sourceCommand = "/getStud";
        Command expectedCommand = new Command(CommandType.GET_STUDENT, new ArrayList<>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandGetStudentWrongFormat() {
        String sourceCommand = "/getStudent";
        Command expectedCommand = new Command(CommandType.NONE, new ArrayList<>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandGetStudentEnoughArgs() {
        String sourceCommand = "/getStud 3";
        Command expectedCommand = new Command(CommandType.GET_STUDENT, new ArrayList<>(Arrays.asList("3")));
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandGetStudentTooManyArgs() {
        String sourceCommand = "/getStud 3 String 4 5";
        Command expectedCommand = new Command(CommandType.GET_STUDENT, new ArrayList<>(Arrays.asList("3", "String", "4", "5")));
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandGetAllStudentsOkNoArgs() {
        String sourceCommand = "/getAllStuds";
        Command expectedCommand = new Command(CommandType.GET_STUDENTS, new ArrayList<>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandGetAllStudentsWrongFormat() {
        String sourceCommand = "/getAllStudents";
        Command expectedCommand = new Command(CommandType.NONE, new ArrayList<>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandGetAllStudentsTooManyArgs() {
        String sourceCommand = "/getAllStuds 3 String 4 5";
        Command expectedCommand = new Command(CommandType.GET_STUDENTS, new ArrayList<>(Arrays.asList("3", "String", "4", "5")));
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandExitOkNoArgs() {
        String sourceCommand = "/exit";
        Command expectedCommand = new Command(CommandType.EXIT, new ArrayList<>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandExitWrongFormat() {
        String sourceCommand = "/exitplease";
        Command expectedCommand = new Command(CommandType.NONE, new ArrayList<>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandExitTooManyArgs() {
        String sourceCommand = "/exit 3 String 4 5";
        Command expectedCommand = new Command(CommandType.EXIT, new ArrayList<>(Arrays.asList("3", "String", "4", "5")));
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandHelpOkNoArgs() {
        String sourceCommand = "/help";
        Command expectedCommand = new Command(CommandType.HELP, new ArrayList<>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandHelpWrongFormat() {
        String sourceCommand = "/helpplease";
        Command expectedCommand = new Command(CommandType.NONE, new ArrayList<>());
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }

    @Test
    public void parseCommandHelpTooManyArgs() {
        String sourceCommand = "/help 3 String 4 5";
        Command expectedCommand = new Command(CommandType.HELP, new ArrayList<>(Arrays.asList("3", "String", "4", "5")));
        StudentDao studentDao = null;
        StudentAppCLIController studentAppCLIController = new StudentAppCLIController(3, studentDao);
        Command actualCommand = studentAppCLIController.parse(sourceCommand);
        assertThat(actualCommand.getType()).isEqualTo(expectedCommand.getType());
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }
}