package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.fruits.tools;

import org.jetbrains.annotations.NotNull;

/**
 * @author SBerdyshev
 */
public class ConstantHelper {

    public static final int BOX_FIRST_ELEMENT = 0;
    public static final String FRUITS_MOVING_STATUS_SUCCESS = "Fruits have been moved!";
    public static final String FRUITS_MOVING_STATUS_ERROR = "Fruits haven't been moved. Unknown error.";
    public static final String BOX_SHOW_WEIGHT_DESCRIPTION = "Weight of the box %s is %s";
    public static final String BOX_NO_NAME = "no name";
    public static final String BOX_EQUAL = "Boxes %s and %s are equal in weight";
    public static final String BOX_NOT_EQUAL = "Boxes %s and %s are not equal in weight";

    public static final String TECHNICAL_OPERATION_DESCRIPTION_ADDING_FRUIT = "Adding a fruit into box %s...";
    public static final String TECHNICAL_OPERATION_DESCRIPTION_MOVING_FRUITS_TO_ANOTHER_BOX = "Moving all fruits from box %s to box %s...";
    public static final String TECHNICAL_OPERATION_DESCRIPTION_COMPARING_BOXES = "Comparing box %s and box %s...";

    @NotNull
    public static String constructBoxWeightDescription(@NotNull final String boxName, final float weight) {
        return String.format(BOX_SHOW_WEIGHT_DESCRIPTION, boxName, weight);
    }

    @NotNull
    public static String constructAddingFruitOperationDescription(@NotNull final String boxName) {
        return String.format(TECHNICAL_OPERATION_DESCRIPTION_ADDING_FRUIT, boxName);
    }

    @NotNull
    public static String constructMovingFruitsToAnotherBoxOperationDescription(@NotNull final String sourceBoxName, @NotNull final String targetBoxName) {
        return String.format(TECHNICAL_OPERATION_DESCRIPTION_MOVING_FRUITS_TO_ANOTHER_BOX, sourceBoxName, targetBoxName);
    }

    @NotNull
    public static String constructComparingBoxesOperationDescription(@NotNull final String firstBoxName, @NotNull final String secondBoxName) {
        return String.format(TECHNICAL_OPERATION_DESCRIPTION_COMPARING_BOXES, firstBoxName, secondBoxName);
    }

    @NotNull
    public static String constructBoxEqualResultDescription(@NotNull final String firstBoxName, @NotNull final String secondBoxName) {
        return String.format(BOX_EQUAL, firstBoxName, secondBoxName);
    }

    @NotNull
    public static String constructBoxNotEqualResultDescription(@NotNull final String firstBoxName, @NotNull final String secondBoxName) {
        return String.format(BOX_NOT_EQUAL, firstBoxName, secondBoxName);
    }
}
