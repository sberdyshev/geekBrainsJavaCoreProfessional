package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.tools;

/**
 * @author SBerdyshev
 */
public class ConstantHelper {


    public static final String LABEL_ARRAY = "Array: ";
    public static final String LABEL_LIST = "List: ";

    public static final String TECHNICAL_NEW_LINE = "\n";
    public static final String TECHNICAL_SEPARATOR = "--------------------------------------";
    public static final String TECHNICAL_SEPARATOR_SPACE = " ";
    public static final String TECHNICAL_TASK_SEPARATOR_START = TECHNICAL_NEW_LINE + TECHNICAL_SEPARATOR;
    public static final String TECHNICAL_TASK_SEPARATOR_END = TECHNICAL_SEPARATOR + TECHNICAL_NEW_LINE;
    public static final String TECHNICAL_TASK_NUMBER_STRING = "Task number %s";
    public static final Integer TECHNICAL_TASK_NUMBER_1 = 1;
    public static final Integer TECHNICAL_TASK_NUMBER_2 = 2;
    public static final Integer TECHNICAL_TASK_NUMBER_3 = 3;

    private ConstantHelper() {
    }

    public static void showTaskNumber(final Integer taskNumber) {
        final String fullTaskLine = String.format(TECHNICAL_TASK_NUMBER_STRING, taskNumber);
        System.out.println(TECHNICAL_TASK_SEPARATOR_START + fullTaskLine + TECHNICAL_TASK_SEPARATOR_END);
    }
}
