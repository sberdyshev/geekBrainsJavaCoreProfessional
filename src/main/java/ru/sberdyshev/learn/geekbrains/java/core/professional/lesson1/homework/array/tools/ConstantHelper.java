package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.array.tools;

import org.jetbrains.annotations.NotNull;

/**
 * @author SBerdyshev
 */
public class ConstantHelper {
    public static final int ARRAY_INITIAL_BORDER = 0;
    public static final String EXCEPTION_DESCRIPTION_ARRAY_OUT_OF_BOUNDS = "One of elements is out of bounds. Array size - %s, first element position - %s, second element position - %s";

    public static final String TECHNICAL_OPERATION_DESCRIPTION_SWAPPING_ELEMENTS = "Swapping two elements...";
    public static final String TECHNICAL_OPERATION_DESCRIPTION_BUILD_ARRAYLIST = "Building an ArrayList from an array...";

    @NotNull
    public static String constructArrayOutOfBoundsException(final int arraySize, final int firstElementPosition, final int secondElementPosition) {
        return String.format(EXCEPTION_DESCRIPTION_ARRAY_OUT_OF_BOUNDS, arraySize, firstElementPosition, secondElementPosition);
    }
}
