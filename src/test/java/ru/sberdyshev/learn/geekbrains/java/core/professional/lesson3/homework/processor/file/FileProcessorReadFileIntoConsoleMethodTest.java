package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework.processor.file;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class FileProcessorReadFileIntoConsoleMethodTest {
    private final String rootPath = "C:\\Users\\SBerdyshev\\IdeaProjects\\geekBrainsJavaCoreProfessional\\src\\main\\resources\\";
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
    public void readFileIntoConsole() {
        final String expectedResult = "1111111";

        FileProcessor.readFileIntoConsole(rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testFile.txt");

        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void readBigFileIntoConsole() {
        final String expectedResult = "1111111\r\n11111111111111\r\n1111111\r\n1111111\r\n1111111";

        FileProcessor.readFileIntoConsole(rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testBigFile.txt");

        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void readNullFileIntoConsole() {
        final String expectedResult = "Имя файла не определено\r\n";

        FileProcessor.readFileIntoConsole(null);

        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void readNonExistedFileIntoConsole() {
        final String expectedResult = "Файл не найден\r\n";

        FileProcessor.readFileIntoConsole("NotAFile.file");

        assertEquals(expectedResult, outContent.toString());
    }
}
