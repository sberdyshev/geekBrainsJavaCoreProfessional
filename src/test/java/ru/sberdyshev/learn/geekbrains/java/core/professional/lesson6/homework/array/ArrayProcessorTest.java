package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


public class ArrayProcessorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void exctractElementsSuccessLongArrayTestCase() {
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(1, 7));

        List<Integer> source = new ArrayList<>(Arrays.asList(5, 4, 6, 8, 1, 3, 6, 2, 1, 7));
        List<Integer> result = ArrayProcessor.exctractElements(source);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void exctractElementsSuccessShortArrayTestCase() {
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(1, 3, 6));

        List<Integer> source = new ArrayList<>(Arrays.asList(5, 4, 6, 8, 1, 3, 6));
        List<Integer> result = ArrayProcessor.exctractElements(source);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void exctractElementsSuccessNoLeftsTestCase() {
        List<Integer> expectedResult = new ArrayList<>();

        List<Integer> source = new ArrayList<>(Arrays.asList(5, 4, 6, 8));
        List<Integer> result = ArrayProcessor.exctractElements(source);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void exctractElementsErrorShortArrayTestCase() {
        List<Integer> source = new ArrayList<>(Arrays.asList(5, 4, 6));

        Throwable thrown = catchThrowable(() -> {
            ArrayProcessor.exctractElements(source);
        });

        assertThat(thrown).hasMessage("Source array is too short").isInstanceOf(IllegalArgumentException.class)
                .hasNoCause();
    }

    @Test
    public void exctractElementsErrorNullArrayTestCase() {
        List<Integer> source = null;

        Throwable thrown = catchThrowable(() -> {
            ArrayProcessor.exctractElements(source);
        });

        assertThat(thrown).hasMessage("Source array can not be null").isInstanceOf(IllegalArgumentException.class)
                .hasNoCause();
    }


    @Test
    public void checkFor1And4ClassicSuccessFalseOtherNumbers() {
        List<Integer> source = new ArrayList<>(Arrays.asList(1,2,3,4));
        boolean expectedResult = false;

        boolean result = ArrayProcessor.checkFor1And4Classic(source);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void checkFor1And4ClassicSuccessFalseOnlyOnes() {
        List<Integer> source = new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1,1,1));
        boolean expectedResult = false;

        boolean result = ArrayProcessor.checkFor1And4Classic(source);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void checkFor1And4ClassicSuccessFalseOnlyFores() {
        List<Integer> source = new ArrayList<>(Arrays.asList(4,4,4,4,4,4,4));
        boolean expectedResult = false;

        boolean result = ArrayProcessor.checkFor1And4Classic(source);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void checkFor1And4ClassicSuccessTrue() {
        List<Integer> source = new ArrayList<>(Arrays.asList(1,4,1,4,4,4,4,1,1,1,1,4,1,4,4,4,1,4,4,1,1,1,1,1,4,4,1,1,4,1,4,1));
        boolean expectedResult = true;

        boolean result = ArrayProcessor.checkFor1And4Classic(source);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void checkFor1And4ClassicSuccessEmptySource() {
        List<Integer> source = new ArrayList<>();
        boolean expectedResult = false;

        boolean result = ArrayProcessor.checkFor1And4Classic(source);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void checkFor1And4ClassicNullSource() {
        List<Integer> source = null;

        Throwable thrown = catchThrowable(() -> {
            ArrayProcessor.checkFor1And4Classic(source);
        });

        assertThat(thrown).hasMessage("Source array can not be null").isInstanceOf(IllegalArgumentException.class)
                .hasNoCause();
    }
}