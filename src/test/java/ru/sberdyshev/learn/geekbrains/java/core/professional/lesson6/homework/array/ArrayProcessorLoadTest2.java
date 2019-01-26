package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ArrayProcessorLoadTest2 {

    static List<Integer> sourceOnlyFours = null;
    static List<Integer> sourceOk = null;

    static {
        sourceOnlyFours = new ArrayList<>();
        sourceOk = new ArrayList<>();
        for (int i = 0; i < 150000000; i++) {
            sourceOnlyFours.add(4);
            int rand = (int) Math.random() * 10;
            if (rand > 5) {
                sourceOk.add(4);
            } else {
                sourceOk.add(1);
            }
        }
    }

    boolean expectedResultOnlyFours = false;
    boolean expectedResultOk = true;
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
    public void checkFor1And4ClassicSuccessFalseOnlyFours() {
        System.out.println("checkFor1And4ClassicSuccessFalseOnlyFours");
        boolean result = ArrayProcessor.checkFor1And4Classic(sourceOnlyFours);

        assertThat(result).isEqualTo(expectedResultOnlyFours);
    }

    @Test
    public void checkFor1And4ClassicSuccessTrue() {
        System.out.println("checkFor1And4ClassicSuccessTrue");
        boolean result = ArrayProcessor.checkFor1And4Classic(sourceOk);

        assertThat(result).isEqualTo(expectedResultOk);
    }

    @Test
    public void checkFor1And4FilterSuccessFalseOnlyFours() {
        System.out.println("checkFor1And4FilterSuccessFalseOnlyFours");
        boolean result = ArrayProcessor.checkFor1And4Filter(sourceOnlyFours);

        assertThat(result).isEqualTo(expectedResultOnlyFours);
    }

    @Test
    public void checkFor1And4FilterSuccessTrue() {
        System.out.println("checkFor1And4FilterSuccessTrue");
        boolean result = ArrayProcessor.checkFor1And4Filter(sourceOk);

        assertThat(result).isEqualTo(expectedResultOk);
    }

    @Test
    public void checkFor1And4DistinctSuccessFalseOnlyFours() {
        System.out.println("checkFor1And4DistinctSuccessFalseOnlyFours");
        boolean result = ArrayProcessor.checkFor1And4Distinct(sourceOnlyFours);

        assertThat(result).isEqualTo(expectedResultOnlyFours);
    }

    @Test
    public void checkFor1And4DistinctSuccessTrue() {
        System.out.println("checkFor1And4DistinctSuccessTrue");
        boolean result = ArrayProcessor.checkFor1And4Distinct(sourceOk);

        assertThat(result).isEqualTo(expectedResultOk);
    }

    @Test
    public void checkFor1And4CountSuccessFalseOnlyFours() {
        System.out.println("checkFor1And4CountSuccessFalseOnlyFours");
        boolean result = ArrayProcessor.checkFor1And4Count(sourceOnlyFours);

        assertThat(result).isEqualTo(expectedResultOnlyFours);
    }

    @Test
    public void checkFor1And4CountSuccessTrue() {
        System.out.println("checkFor1And4CountSuccessTrue");
        boolean result = ArrayProcessor.checkFor1And4Count(sourceOk);

        assertThat(result).isEqualTo(expectedResultOk);
    }
}