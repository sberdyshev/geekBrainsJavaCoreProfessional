package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.array.ArrayHelper;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.fruits.Apple;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.fruits.Box;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.fruits.Orange;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.array.ArrayHelper.createArrayListFromArray;
import static ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.tools.ConstantHelper.*;
import static ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.tools.TestData.*;

/**
 * @author SBerdyshev
 */
public class App {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        showTaskNumber(TECHNICAL_TASK_NUMBER_1);

        String[] strArray = new String[]{TEST_DATA_STRING_ARRAY_ELEMENT_1, TEST_DATA_STRING_ARRAY_ELEMENT_2, TEST_DATA_STRING_ARRAY_ELEMENT_3, TEST_DATA_STRING_ARRAY_ELEMENT_4};
        Integer[] intArray = new Integer[]{TEST_DATA_INTEGER_ARRAY_ELEMENT_1, TEST_DATA_INTEGER_ARRAY_ELEMENT_2, TEST_DATA_INTEGER_ARRAY_ELEMENT_3, TEST_DATA_INTEGER_ARRAY_ELEMENT_4};

        ArrayHelper.printOneDimentionalArray(strArray);
        ArrayHelper.swapTwoElements(strArray, TEST_DATA_TASK_1_TEST_1_START_POSITION, TEST_DATA_TASK_1_TEST_1_END_POSITION);
        ArrayHelper.printOneDimentionalArray(strArray);
        ArrayHelper.printOneDimentionalArray(intArray);
        ArrayHelper.swapTwoElements(intArray, TEST_DATA_TASK_1_TEST_2_START_POSITION, TEST_DATA_TASK_1_TEST_2_END_POSITION);
        ArrayHelper.printOneDimentionalArray(intArray);
//        ArrayHelper.swapTwoElements(intArray, TEST_DATA_TASK_1_TEST_3_START_POSITION, TEST_DATA_TASK_1_TEST_3_END_POSITION);

        showTaskNumber(TECHNICAL_TASK_NUMBER_2);
        List<String> strArrayList = createArrayListFromArray(strArray);
        List<Integer> intArrayList = createArrayListFromArray(intArray);
        ArrayHelper.printList(strArrayList);
        ArrayHelper.printList(intArrayList);

        showTaskNumber(TECHNICAL_TASK_NUMBER_3);
        Box<Apple> appleBox1 = new Box<Apple>(Apple.class, TEST_DATA_TASK_3_TEST_1_AMOUNT_OF_FRUITS, TEST_DATA_TASK_3_TEST_1_BOX_NAME);
        appleBox1.showWeight();
        Box<Apple> appleBox2 = new Box<Apple>(Apple.class, TEST_DATA_TASK_3_TEST_2_AMOUNT_OF_FRUITS, TEST_DATA_TASK_3_TEST_2_BOX_NAME);
        appleBox2.showWeight();
        Box<Orange> orangeBox1 = new Box<Orange>(Orange.class, TEST_DATA_TASK_3_TEST_3_AMOUNT_OF_FRUITS, TEST_DATA_TASK_3_TEST_3_BOX_NAME);
        orangeBox1.showWeight();
        Box<Orange> orangeBox2 = new Box<Orange>(Orange.class, TEST_DATA_TASK_3_TEST_4_AMOUNT_OF_FRUITS, TEST_DATA_TASK_3_TEST_4_BOX_NAME);
        orangeBox2.showWeight();
        System.out.println(TECHNICAL_NEW_LINE);

        appleBox2.compare(appleBox1);
        appleBox2.compare(orangeBox1);
        appleBox2.compare(orangeBox2);
        System.out.println(TECHNICAL_NEW_LINE);

        appleBox1.fillBoxWithAnotherBox(appleBox2);
        appleBox1.showWeight();
        appleBox2.showWeight();
        System.out.println(TECHNICAL_NEW_LINE);

        orangeBox2.showWeight();
        orangeBox2.addFruit(new Orange());
        orangeBox2.showWeight();
        System.out.println(TECHNICAL_NEW_LINE);
    }
}
