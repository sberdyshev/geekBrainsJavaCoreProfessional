package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ArrayProcessorLoadTest1 {
    boolean expectedResultOtherNumbers = false;
    static final List<Integer> sourceOtherNumbers;
    boolean expectedResultOnlyOnes = false;
    static final List<Integer> sourceOnlyOnes;
    Date beforeDate;
    Date afterDate;

    static {
        sourceOtherNumbers = new ArrayList<>();
        sourceOnlyOnes = new ArrayList<>();
        for (int i = 0; i < 150000000; i++) {
            sourceOnlyOnes.add(1);
            sourceOnlyOnes.add((int)Math.random()*10);
        }
    }

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
        boolean result = ArrayProcessor.checkFor1And4Classic(sourceOtherNumbers);

        assertThat(result).isEqualTo(expectedResultOtherNumbers);
    }

    @Test
    public void checkFor1And4ClassicSuccessFalseOnlyOnes() {
        System.out.println("ClassicSuccessFalseOnlyOnes");
        boolean result = ArrayProcessor.checkFor1And4Classic(sourceOnlyOnes);

        assertThat(result).isEqualTo(expectedResultOnlyOnes);
    }

    @Test
    public void checkFor1And4CountSuccessFalseOtherNumbers() {
        System.out.println("CountSuccessFalseOtherNumbers");
        boolean result = ArrayProcessor.checkFor1And4Count(sourceOtherNumbers);

        assertThat(result).isEqualTo(expectedResultOtherNumbers);
    }

    @Test
    public void checkFor1And4CountSuccessFalseOnlyOnes() {
        System.out.println("CountSuccessFalseOnlyOnes");
        boolean result = ArrayProcessor.checkFor1And4Count(sourceOnlyOnes);

        assertThat(result).isEqualTo(expectedResultOnlyOnes);
    }

    @Test
    public void checkFor1And4DistinctSuccessFalseOtherNumbers() {
        System.out.println("DistinctSuccessFalseOtherNumbers");
        boolean result = ArrayProcessor.checkFor1And4Distinct(sourceOtherNumbers);

        assertThat(result).isEqualTo(expectedResultOtherNumbers);
    }

    @Test
    public void checkFor1And4DistinctSuccessFalseOnlyOnes() {
        System.out.println("DistinctSuccessFalseOnlyOnes");
        boolean result = ArrayProcessor.checkFor1And4Distinct(sourceOnlyOnes);

        assertThat(result).isEqualTo(expectedResultOnlyOnes);
    }

    @Test
    public void checkFor1And4FilterSuccessFalseOtherNumbers() {
        System.out.println("FilterSuccessFalseOtherNumbers");
        boolean result = ArrayProcessor.checkFor1And4Filter(sourceOtherNumbers);

        assertThat(result).isEqualTo(expectedResultOtherNumbers);
    }

    @Test
    public void checkFor1And4FilterSuccessFalseOnlyOnes() {
        System.out.println("FilterSuccessFalseOnlyOnes");
        boolean result = ArrayProcessor.checkFor1And4Filter(sourceOnlyOnes);

        assertThat(result).isEqualTo(expectedResultOnlyOnes);
    }

}