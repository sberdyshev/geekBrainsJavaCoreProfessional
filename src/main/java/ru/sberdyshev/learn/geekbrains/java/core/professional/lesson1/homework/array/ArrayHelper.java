package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.array;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.array.tools.ConstantHelper.*;
import static ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.tools.ConstantHelper.*;

/**
 * @author SBerdyshev
 */
public class ArrayHelper {
    private ArrayHelper() {
    }

    @NotNull
    public static <T> T[] swapTwoElements(@NotNull T[] sourceArray, @NotNull final int positionOfFirstElement, @NotNull final int positionOfSecondElement) {
        System.out.println(TECHNICAL_NEW_LINE + TECHNICAL_OPERATION_DESCRIPTION_SWAPPING_ELEMENTS);
        final int sourceArrayLength = sourceArray.length;
        final boolean isFirstElementOutOfBounds = (positionOfFirstElement >= sourceArrayLength) || (positionOfFirstElement < ARRAY_INITIAL_BORDER);
        final boolean isSecondElementOutOfBounds = (positionOfSecondElement >= sourceArrayLength) || (positionOfSecondElement < ARRAY_INITIAL_BORDER);

        if (isFirstElementOutOfBounds || isSecondElementOutOfBounds) {
            throw new ArrayIndexOutOfBoundsException(constructArrayOutOfBoundsException(sourceArrayLength, positionOfFirstElement, positionOfSecondElement));
        } else {
            final T firstElement = sourceArray[positionOfFirstElement];
            sourceArray[positionOfFirstElement] = sourceArray[positionOfSecondElement];
            sourceArray[positionOfSecondElement] = firstElement;
        }
        return sourceArray;
    }

    public static <T> void printOneDimentionalArray(@NotNull final T[] sourceArray) {
        System.out.println(TECHNICAL_NEW_LINE + LABEL_ARRAY);
        for (T element : sourceArray) {
            System.out.print(element + TECHNICAL_SEPARATOR_SPACE);
        }
        System.out.println();
    }

    public static <T> void printList(@NotNull final List<T> list) {
        System.out.println(TECHNICAL_NEW_LINE + LABEL_LIST);
        System.out.println(list);
    }

    public static <T> ArrayList<T> createArrayListFromArray(@NotNull final T[] sourceArray) {
        System.out.println(TECHNICAL_NEW_LINE + TECHNICAL_OPERATION_DESCRIPTION_BUILD_ARRAYLIST);
        return new ArrayList<T>(Arrays.asList(sourceArray));
    }

}
