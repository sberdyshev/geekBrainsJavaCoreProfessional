package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sberdyshev
 */
public class ArrayProcessor {

    public static List<Integer> exctractElements(List<Integer> source) {
        if (source == null) {
            throw new IllegalArgumentException("Source array can not be null");
        }
        int sourceSize = source.size();
        if (sourceSize < 4) {
            throw new IllegalArgumentException("Source array is too short");
        }
        List<Integer> result = new ArrayList<>();
        int resultSize = sourceSize % 4;
        for (int i = 0; i < resultSize; i++) {
            Integer sourceElement = source.get(sourceSize - (resultSize - i));
            result.add(sourceElement);
        }

        return result;
    }

    public static boolean checkFor1And4Classic(List<Integer> source) {
        if (source == null) {
            throw new IllegalArgumentException("Source array can not be null");
        }
        if (source.size() == 0) {
            return false;
        }
        boolean is4found = false;
        boolean is1found = false;

        for (Integer element : source) {
            int elementValue = element.intValue();
            boolean isElementEquals4 = elementValue == 4;
            boolean isElementEquals1 = elementValue == 1;
            if (!isElementEquals1 && !isElementEquals4) {
                return false;
            } else {
                if (!is1found && isElementEquals1) {
                    is1found = true;
                }
                if (!is4found && isElementEquals4) {
                    is4found = true;
                }
            }
        }

        return (is1found && is4found);
    }

    public static boolean checkFor1And4Filter(List<Integer> source) {
        if (source == null) {
            throw new IllegalArgumentException("Source array can not be null");
        }
        if (source.size() == 0) {
            return false;
        }
        List<Integer> result = source.stream()
                .filter(element -> (element != null && (element.equals(4) || element.equals(1))))
                .collect(Collectors.toList());
        if (result.size() != source.size()) {
            return false;
        } else {
            return (result.stream().anyMatch(element -> element == 4)&&(result.stream().anyMatch(element -> element == 1)));
        }
    }

    public static boolean checkFor1And4Distinct(List<Integer> source) {
        if (source == null) {
            throw new IllegalArgumentException("Source array can not be null");
        }
        if (source.size() == 0) {
            return false;
        }
        boolean is4found = false;
        boolean is1found = false;
        List<Integer> result = source.stream()
                .distinct()
                .collect(Collectors.toList());
        if (result.size() != 2) {
            return false;
        } else {
            int element1 = result.get(0);
            int element2 = result.get(1);
            if (element1 == 1 || element2 == 1) {
                is1found = true;
            }
            if (element1 == 4 || element2 == 4) {
                is4found = true;
            }
            return is1found && is4found;
        }
    }

    public static boolean checkFor1And4Count(List<Integer> source) {
        if (source == null) {
            throw new IllegalArgumentException("Source array can not be null");
        }
        if (source.size() == 0) {
            return false;
        }
        long amountOf4 = source.stream()
                .filter(element -> !(element != null && (element.equals(4)))).count();
        long amountOf1 = source.stream()
                .filter(element -> !(element != null && (element.equals(1)))).count();
        if (amountOf4 > 0 && amountOf1 > 0 && (amountOf1 + amountOf4) == source.size()) {
            return true;
        } else {
            return false;
        }
    }
}
