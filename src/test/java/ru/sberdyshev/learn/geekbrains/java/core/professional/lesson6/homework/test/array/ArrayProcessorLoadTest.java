package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class ArrayProcessorLoadTest {
    static final List<Integer> SOURCE_ONLY_FOURS;
    static final List<Integer> SOURCE_OK;
    static final List<Integer> SOURCE_OTHER_NUMBERS;
    static final List<Integer> SOURCE_ONLY_ONES;
    static final boolean EXPECTED_RESULT_ONLY_ONES = false;
    static final boolean EXPECTED_RESULT_OTHER_NUMBERS = false;
    static final boolean EXPECTED_RESULT_ONLY_FOURS = false;
    static final boolean EXPECTED_RESULT_OK = true;

    static {
        System.out.println("Loading...");
        SOURCE_OTHER_NUMBERS = new ArrayList<>();
        SOURCE_ONLY_ONES = new ArrayList<>();
        SOURCE_ONLY_FOURS = new ArrayList<>();
        SOURCE_OK = new ArrayList<>();
        Random rnd = new Random();
        int maxListSize = 150000000;
//        int maxListSize = 15;
        for (int i = 0; i < maxListSize; i++) {
            SOURCE_ONLY_ONES.add(1);
            SOURCE_ONLY_FOURS.add(4);
            int rand = rnd.nextInt(10);
            if (rand > 5) {
                SOURCE_OK.add(4);
            } else {
                SOURCE_OK.add(1);
            }
            SOURCE_ONLY_ONES.add(rand);
            if (i % 1500000 == 0) {
                System.out.println("..." + i / 1500000 + "%");
            }
        }
        System.out.println("Ready!");
    }

    Date beforeDate;
    Date afterDate;

    @Before
    public void showTimeBefore() {
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        System.out.println("Time before: " + ts);
        beforeDate = new Date();
    }

    @After
    public void showTimeAfter() {
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        System.out.println("Time after: " + ts);
        afterDate = new Date();
        double diff = (afterDate.getTime() - beforeDate.getTime());
        System.out.println("Difference: " + diff + "\r\n");
    }

    @Test
    public void checkFor1And4SuccessFalseOtherNumbersClassic() {
        System.out.println("ClassicSuccessFalseOtherNumbers");
        boolean result = ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OTHER_NUMBERS);
    }

    @Test
    public void checkFor1And4SuccessFalseOnlyOnesClassic() {
        System.out.println("ClassicSuccessFalseOnlyOnes");
        boolean result = ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_ONES);
    }

    @Test
    public void checkFor1And4SuccessFalseOtherNumbersCount() {
        System.out.println("CountSuccessFalseOtherNumbers");
        boolean result = ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OTHER_NUMBERS);
    }

    @Test
    public void checkFor1And4SuccessFalseOnlyOnesCount() {
        System.out.println("CountSuccessFalseOnlyOnes");
        boolean result = ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_ONES);
    }

    @Test
    public void checkFor1And4SuccessFalseOtherNumbersDistinct() {
        System.out.println("DistinctSuccessFalseOtherNumbers");
        boolean result = ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OTHER_NUMBERS);
    }

    @Test
    public void checkFor1And4SuccessFalseOnlyOnesDistinct() {
        System.out.println("DistinctSuccessFalseOnlyOnes");
        boolean result = ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_ONES);
    }

    @Test
    public void checkFor1And4SuccessFalseOtherNumbersFilter() {
        System.out.println("FilterSuccessFalseOtherNumbers");
        boolean result = ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OTHER_NUMBERS);
    }

    @Test
    public void checkFor1And4SuccessFalseOnlyOnesFilter() {
        System.out.println("FilterSuccessFalseOnlyOnes");
        boolean result = ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_ONES);
    }

    @Test
    public void checkFor1And4SuccessFalseOnlyFoursClassic() {
        System.out.println("checkFor1And4ClassicSuccessFalseOnlyFours");
        boolean result = ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);


        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_FOURS);
    }

    @Test
    public void checkFor1And4SuccessTrueClassic() {
        System.out.println("checkFor1And4ClassicSuccessTrue");
        boolean result = ArrayProcessor.checkFor1And4Classic(SOURCE_OK);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OK);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OK);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OK);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OK);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OK);
    }

    @Test
    public void checkFor1And4SuccessFalseOnlyFoursFilter() {
        System.out.println("checkFor1And4FilterSuccessFalseOnlyFours");
        boolean result = ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_FOURS);
    }

    @Test
    public void checkFor1And4SuccessTrueFilter() {
        System.out.println("checkFor1And4FilterSuccessTrue");
        boolean result = ArrayProcessor.checkFor1And4Filter(SOURCE_OK);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OK);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OK);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OK);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OK);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OK);
    }

    @Test
    public void checkFor1And4SuccessFalseOnlyFoursDistinct() {
        System.out.println("checkFor1And4DistinctSuccessFalseOnlyFours");
        boolean result = ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_FOURS);
    }

    @Test
    public void checkFor1And4SuccessTrueDistinct() {
        System.out.println("checkFor1And4DistinctSuccessTrue");
        boolean result = ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OK);
    }

    @Test
    public void checkFor1And4SuccessFalseOnlyFoursCount() {
        System.out.println("checkFor1And4CountSuccessFalseOnlyFours");
        boolean result = ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_FOURS);
    }

    @Test
    public void checkFor1And4SuccessTrueCount() {
        System.out.println("checkFor1And4CountSuccessTrue");
        boolean result = ArrayProcessor.checkFor1And4Count(SOURCE_OK);
        ArrayProcessor.checkFor1And4Count(SOURCE_OK);
        ArrayProcessor.checkFor1And4Count(SOURCE_OK);
        ArrayProcessor.checkFor1And4Count(SOURCE_OK);
        ArrayProcessor.checkFor1And4Count(SOURCE_OK);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OK);
    }

    @Test
    public void checkFor1And4CountAll() {
        System.out.println("Count ALL");
        boolean resultSuccessTrue = ArrayProcessor.checkFor1And4Count(SOURCE_OK);
        ArrayProcessor.checkFor1And4Count(SOURCE_OK);
        ArrayProcessor.checkFor1And4Count(SOURCE_OK);
        ArrayProcessor.checkFor1And4Count(SOURCE_OK);
        ArrayProcessor.checkFor1And4Count(SOURCE_OK);
        boolean resultSuccessFalseOnlyFours = ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);
        boolean resultSuccessFalseOtherNumbers = ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);
        boolean resultSuccessFalseOnlyOnes = ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);

        assertThat(resultSuccessFalseOnlyFours).isEqualTo(EXPECTED_RESULT_ONLY_FOURS);
        assertThat(resultSuccessFalseOnlyOnes).isEqualTo(EXPECTED_RESULT_ONLY_ONES);
        assertThat(resultSuccessFalseOtherNumbers).isEqualTo(EXPECTED_RESULT_OTHER_NUMBERS);
        assertThat(resultSuccessTrue).isEqualTo(EXPECTED_RESULT_OK);
    }

    @Test
    public void checkFor1And4DistinctAll() {
        System.out.println("Distinct ALL");
        boolean resultSuccessTrue = ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);
        boolean resultSuccessFalseOnlyFours = ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);
        boolean resultSuccessFalseOtherNumbers = ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);
        boolean resultSuccessFalseOnlyOnes = ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);

        assertThat(resultSuccessFalseOnlyFours).isEqualTo(EXPECTED_RESULT_ONLY_FOURS);
        assertThat(resultSuccessFalseOnlyOnes).isEqualTo(EXPECTED_RESULT_ONLY_ONES);
        assertThat(resultSuccessFalseOtherNumbers).isEqualTo(EXPECTED_RESULT_OTHER_NUMBERS);
        assertThat(resultSuccessTrue).isEqualTo(EXPECTED_RESULT_OK);
    }

    @Test
    public void checkFor1And4FilterAll() {
        System.out.println("Filter ALL");
        boolean resultSuccessTrue = ArrayProcessor.checkFor1And4Filter(SOURCE_OK);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OK);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OK);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OK);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OK);
        boolean resultSuccessFalseOnlyFours = ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);
        boolean resultSuccessFalseOtherNumbers = ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);
        boolean resultSuccessFalseOnlyOnes = ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);

        assertThat(resultSuccessFalseOnlyFours).isEqualTo(EXPECTED_RESULT_ONLY_FOURS);
        assertThat(resultSuccessFalseOnlyOnes).isEqualTo(EXPECTED_RESULT_ONLY_ONES);
        assertThat(resultSuccessFalseOtherNumbers).isEqualTo(EXPECTED_RESULT_OTHER_NUMBERS);
        assertThat(resultSuccessTrue).isEqualTo(EXPECTED_RESULT_OK);
    }

    @Test
    public void checkFor1And4ClassicAll() {
        System.out.println("Classic ALL");
        boolean resultSuccessTrue = ArrayProcessor.checkFor1And4Classic(SOURCE_OK);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OK);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OK);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OK);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OK);
        boolean resultSuccessFalseOnlyFours = ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);
        boolean resultSuccessFalseOtherNumbers = ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);
        boolean resultSuccessFalseOnlyOnes = ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);

        assertThat(resultSuccessFalseOnlyFours).isEqualTo(EXPECTED_RESULT_ONLY_FOURS);
        assertThat(resultSuccessFalseOnlyOnes).isEqualTo(EXPECTED_RESULT_ONLY_ONES);
        assertThat(resultSuccessFalseOtherNumbers).isEqualTo(EXPECTED_RESULT_OTHER_NUMBERS);
        assertThat(resultSuccessTrue).isEqualTo(EXPECTED_RESULT_OK);
    }

}