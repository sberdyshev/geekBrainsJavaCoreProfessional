package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework.handler.letter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LetterHandlerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void printLetter() throws InterruptedException {
        final String expectedResult = "ABCABCABC";

        LetterHandler letterHandler = new LetterHandler(3);
        new Thread(() -> letterHandler.printLetter("A", "C", true)).start();
        new Thread(() -> letterHandler.printLetter("B", "A", false)).start();
        new Thread(() -> letterHandler.printLetter("C", "B", false)).start();

        Thread.sleep(200);
        assertEquals(expectedResult, outContent.toString());
    }
}