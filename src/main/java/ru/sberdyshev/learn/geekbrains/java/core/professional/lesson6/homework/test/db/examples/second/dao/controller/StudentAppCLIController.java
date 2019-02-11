package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.StudentDao;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command.Command;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command.CommandType;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sberdyshev
 */
public class StudentAppCLIController implements CLIController {
    private final static Logger logger = LoggerFactory.getLogger(StudentAppCLIController.class);
    private final int maxTryCount;
    private final StudentDao studentDao;

    public StudentAppCLIController(int maxTryCount, StudentDao studentDao) {
        this.maxTryCount = maxTryCount;
        this.studentDao = studentDao;
    }

    @Override
    public void start() throws IllegalStateException {
        logger.debug("StudentAppCLIController started");
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        int tryCount = 0;
        do {
            showEnterCommandInvitation();
            String line = scanner.nextLine();
            logger.debug("Line read \"{}\"", line);
            Command command = parse(line);
            if (command.checkArgsAreCorrrect()) {
                showWrongArgsMessage();
                tryCount += 1;
            } else {
                switch (command.getType()) {
                    case EXIT:
                        logger.debug("Choosed EXIT");
                        processExit();
                        isExit = true;
                        break;
                    case ADD_STUDENT: {
                        tryCount = 0;
                        logger.debug("Choosed ADD_STUDENT, tryCount = {}", tryCount);
                        processAddStudent(command);
                        break;
                    }
                    case GET_STUDENT: {
                        tryCount = 0;
                        logger.debug("Choosed GET_STUDENT, tryCount = {}", tryCount);
                        processGetStudent(command);
                        break;
                    }
                    case GET_STUDENTS: {
                        tryCount = 0;
                        logger.debug("Choosed GET_STUDENTS, tryCount = {}", tryCount);
                        processGetAllStudents();
                        break;
                    }
                    case UPDATE_STUDENT: {
                        tryCount = 0;
                        logger.debug("Choosed UPDATE_STUDENT, tryCount = {}", tryCount);
                        processUpdateStudent(command);
                        break;
                    }
                    case HELP: {
                        tryCount = 0;
                        logger.debug("Choosed HELP, tryCount = {}", tryCount);
                        processHelp();
                        break;
                    }
                    case NONE: {
                        tryCount += 1;
                        logger.debug("Wrong command, tryCount = {}", tryCount);
                        isExit = processWrongCommand(tryCount);
                        break;
                    }
                    default: {
                        IllegalStateException e = new IllegalStateException("Wrong command type: " + command.getType());
                        logger.error(e.getLocalizedMessage(), e);
                        throw e;
                    }
                }
            }
        } while (!isExit);
    }

    @Override
    public Command parse(String line) {
        logger.debug("Parsing line: {}", line);
        for (CommandType commandType : CommandType.values()) {
            if (commandType.equals(CommandType.NONE)) {
                continue;
            }
            boolean lineStartsWithCurrentCommand = line.startsWith(commandType.getCommandName());
            boolean commandHasArgs = line.length() > commandType.getCommandName().length();
            boolean commandSeparatedFromArgsWithSpace = line.startsWith(commandType.getCommandName() + " ");
            if (lineStartsWithCurrentCommand) {
                if (!commandHasArgs || (commandHasArgs && commandSeparatedFromArgsWithSpace)) {
                    List<String> args = getArgs(line, commandType);
                    logger.debug("Command type: {}", commandType);
                    logger.debug("Arguments: {}", args);
                    return new Command(commandType, args);
                } else {
                    break;
                }
            }
        }
        return new Command(CommandType.NONE, new ArrayList<>());
    }

    private List<String> getArgs(String line, CommandType commandType) {
        List<String> args = new ArrayList<>();
        int commandLength = commandType.getCommandName().length();
        String lineWithoutCommand;
        if (commandLength < line.length()) {
            lineWithoutCommand = line.substring(commandLength);
        } else {
            return args;
        }
        int leadingIndexOfWhiteSpaceForAPreviousCommand = 0;
        int leadingIndexOfWhiteSpace = 0;
        int trailingIndexOfWhiteSpace = 0;
        int spacesAmountInTheLine = (int) line.chars().filter(ch -> ch == ' ').count();
        for (int i = 0; i < spacesAmountInTheLine; i++) {
            leadingIndexOfWhiteSpace = lineWithoutCommand.indexOf(' ', leadingIndexOfWhiteSpaceForAPreviousCommand);
            trailingIndexOfWhiteSpace = lineWithoutCommand.indexOf(' ', leadingIndexOfWhiteSpace + 1);
            String arg;
            if (leadingIndexOfWhiteSpace >= trailingIndexOfWhiteSpace) {
                arg = lineWithoutCommand.substring(leadingIndexOfWhiteSpace).trim();
            } else {
                arg = lineWithoutCommand.substring(leadingIndexOfWhiteSpace, trailingIndexOfWhiteSpace).trim();
            }
            if ("".equals(arg)) {
                arg = null;
            }
            args.add(arg);
            if (trailingIndexOfWhiteSpace < 0) {
                break;
            }
            leadingIndexOfWhiteSpaceForAPreviousCommand = trailingIndexOfWhiteSpace;
        }
        return args;
    }

    private boolean processGetStudent(Command command) {
        Integer id = new Integer(command.getArgAtPos(0));
        try {
            Student student = studentDao.getEntity(id);
            System.out.println("Student with id \"" + student.getId() + "\", name \"" + student.getName() + "\", score \"" + student.getScore() + "\" added");
            logger.info("Got student with id \"{}\", name \"{}\", score \"{}\" added", student.getId(), student.getName(), student.getScore());
        } catch (SQLException e) {
            logger.error("Couldn't get student: " + e.getLocalizedMessage(), e);
            return false;
        } catch (IllegalArgumentException e) {
            logger.error("Couldn't get student: " + e.getLocalizedMessage(), e);
            return false;
        }
        return true;
    }

    private boolean processGetAllStudents() {
        try {
            List<Student> students = studentDao.getEntities();
            System.out.println("Got all students!");
            logger.info("Got all students!");
            for (Student student : students) {
                System.out.println("Student with id \"" + student.getId() + "\", name \"" + student.getName() + "\", score \"" + student.getScore() + "\" added");
                logger.info("Got student with id \"{}\", name \"{}\", score \"{}\" added", student.getId(), student.getName(), student.getScore());
            }
        } catch (SQLException e) {
            logger.error("Couldn't get students: " + e.getLocalizedMessage(), e);
            return false;
        }
        return true;
    }

    private boolean processAddStudent(Command command) {
        Integer id = new Integer(command.getArgAtPos(0));
        String name = command.getArgAtPos(1);
        Integer score = new Integer(command.getArgAtPos(2));
        Student student = new Student(id, name, score);
        try {
            studentDao.addEntity(student);
            logger.info("Student with id \"{}\", name \"{}\", score \"{}\" added", student.getId(), student.getName(), student.getScore());
        } catch (SQLException e) {
            logger.error("Couldn't add student: " + e.getLocalizedMessage(), e);
            return false;
        }
        return true;
    }

    private boolean processUpdateStudent(Command command) {
        Integer id = new Integer(command.getArgAtPos(0));
        String name = command.getArgAtPos(1);
        Integer score = new Integer(command.getArgAtPos(2));
        Student student = new Student(id, name, score);
        try {
            studentDao.updateEntity(student);
            logger.info("Student with id \"{}\" updated. New name - \"{}\", new score - \"{}\"", student.getId(), student.getName(), student.getScore());
        } catch (SQLException e) {
            logger.error("Couldn't update student: " + e.getLocalizedMessage(), e);
            return false;
        } catch (IllegalArgumentException e) {
            logger.error("Couldn't update student: " + e.getLocalizedMessage(), e);
            return false;
        }
        return true;
    }

    private void processHelp() {
        showHelpMessage();
    }

    private boolean processWrongCommand(int tryCount) {
        boolean isExit = false;
        if (tryCount >= maxTryCount) {
            showExaustedTriesMessage();
            showGoodBuyMessage();
            isExit = true;
        } else {
            showWrongCommandMessage();
        }
        return isExit;
    }

    private void processExit() {
        showGoodBuyMessage();
    }
}
