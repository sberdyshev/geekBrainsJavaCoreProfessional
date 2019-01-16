package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework.processor.file;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FileProcessorReadHugeFileByPagesMethodTest {
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
    public void readHugeFileByPages() {
    }

    @Test
    public void readHugeFileByPagesNullFileName() {
    }

    @Test
    public void readHugeFileByPagesNotExistedFile() {
    }

    @Test
    public void readHugeFileByPagesPageNumberTooFar() {
    }

    @Test
    public void readHugeFileByPagesPageNumberNegative() {
    }

    @Test
    public void readHugeFileByPagesPageNumberZero() {
    }
}
