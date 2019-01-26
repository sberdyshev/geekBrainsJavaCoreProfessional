package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        for (int i = 0; i < 150000000; i++) {
            SOURCE_ONLY_ONES.add(1);
            SOURCE_ONLY_FOURS.add(4);
            int rand = (int) Math.random() * 10;
            if (rand > 5) {
                SOURCE_OK.add(4);
            } else {
                SOURCE_OK.add(1);
            }
            SOURCE_ONLY_ONES.add(rand);
            if (i%1500000==0) {
                System.out.println("..."+ i/1500000 + "%");
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
    public void checkFor1And4ClassicSuccessFalseOtherNumbers() {
        System.out.println("ClassicSuccessFalseOtherNumbers");
        boolean result = ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OTHER_NUMBERS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OTHER_NUMBERS);
    }

    @Test
    public void checkFor1And4ClassicSuccessFalseOnlyOnes() {
        System.out.println("ClassicSuccessFalseOnlyOnes");
        boolean result = ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_ONES);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_ONES);
    }

    @Test
    public void checkFor1And4CountSuccessFalseOtherNumbers() {
        System.out.println("CountSuccessFalseOtherNumbers");
        boolean result = ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Count(SOURCE_OTHER_NUMBERS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OTHER_NUMBERS);
    }

    @Test
    public void checkFor1And4CountSuccessFalseOnlyOnes() {
        System.out.println("CountSuccessFalseOnlyOnes");
        boolean result = ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_ONES);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_ONES);
    }

    @Test
    public void checkFor1And4DistinctSuccessFalseOtherNumbers() {
        System.out.println("DistinctSuccessFalseOtherNumbers");
        boolean result = ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OTHER_NUMBERS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OTHER_NUMBERS);
    }

    @Test
    public void checkFor1And4DistinctSuccessFalseOnlyOnes() {
        System.out.println("DistinctSuccessFalseOnlyOnes");
        boolean result = ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_ONES);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_ONES);
    }

    @Test
    public void checkFor1And4FilterSuccessFalseOtherNumbers() {
        System.out.println("FilterSuccessFalseOtherNumbers");
        boolean result = ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OTHER_NUMBERS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OTHER_NUMBERS);
    }

    @Test
    public void checkFor1And4FilterSuccessFalseOnlyOnes() {
        System.out.println("FilterSuccessFalseOnlyOnes");
        boolean result = ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_ONES);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_ONES);
    }

    @Test
    public void checkFor1And4ClassicSuccessFalseOnlyFours() {
        System.out.println("checkFor1And4ClassicSuccessFalseOnlyFours");
        boolean result = ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Classic(SOURCE_ONLY_FOURS);


        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_FOURS);
    }

    @Test
    public void checkFor1And4ClassicSuccessTrue() {
        System.out.println("checkFor1And4ClassicSuccessTrue");
        boolean result = ArrayProcessor.checkFor1And4Classic(SOURCE_OK);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OK);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OK);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OK);
        ArrayProcessor.checkFor1And4Classic(SOURCE_OK);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OK);
    }

    @Test
    public void checkFor1And4FilterSuccessFalseOnlyFours() {
        System.out.println("checkFor1And4FilterSuccessFalseOnlyFours");
        boolean result = ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Filter(SOURCE_ONLY_FOURS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_FOURS);
    }

    @Test
    public void checkFor1And4FilterSuccessTrue() {
        System.out.println("checkFor1And4FilterSuccessTrue");
        boolean result = ArrayProcessor.checkFor1And4Filter(SOURCE_OK);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OK);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OK);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OK);
        ArrayProcessor.checkFor1And4Filter(SOURCE_OK);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OK);
    }

    @Test
    public void checkFor1And4DistinctSuccessFalseOnlyFours() {
        System.out.println("checkFor1And4DistinctSuccessFalseOnlyFours");
        boolean result = ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_ONLY_FOURS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_FOURS);
    }

    @Test
    public void checkFor1And4DistinctSuccessTrue() {
        System.out.println("checkFor1And4DistinctSuccessTrue");
        boolean result = ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);
        ArrayProcessor.checkFor1And4Distinct(SOURCE_OK);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OK);
    }

    @Test
    public void checkFor1And4CountSuccessFalseOnlyFours() {
        System.out.println("checkFor1And4CountSuccessFalseOnlyFours");
        boolean result = ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);
        ArrayProcessor.checkFor1And4Count(SOURCE_ONLY_FOURS);

        assertThat(result).isEqualTo(EXPECTED_RESULT_ONLY_FOURS);
    }

    @Test
    public void checkFor1And4CountSuccessTrue() {
        System.out.println("checkFor1And4CountSuccessTrue");
        boolean result = ArrayProcessor.checkFor1And4Count(SOURCE_OK);
        ArrayProcessor.checkFor1And4Count(SOURCE_OK);
        ArrayProcessor.checkFor1And4Count(SOURCE_OK);
        ArrayProcessor.checkFor1And4Count(SOURCE_OK);
        ArrayProcessor.checkFor1And4Count(SOURCE_OK);

        assertThat(result).isEqualTo(EXPECTED_RESULT_OK);
    }

}