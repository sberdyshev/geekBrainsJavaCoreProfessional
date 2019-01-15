package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework.processor.file;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class FileProcessorTest {
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
        FileProcessor.readFileIntoConsole("C:\\Users\\SBerdyshev\\IdeaProjects\\geekBrainsJavaCoreProfessional\\src\\main\\resources\\ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testFile.txt");
        assertEquals("1111111",outContent.toString());
    }

    @Test
    public void readBigFileIntoConsole() {
        FileProcessor.readFileIntoConsole("C:\\Users\\SBerdyshev\\IdeaProjects\\geekBrainsJavaCoreProfessional\\src\\main\\resources\\ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testBigFile.txt");
        assertEquals("1111111\r\n11111111111111\r\n1111111\r\n1111111\r\n1111111",outContent.toString());
    }

    @Test
    public void readNullFileIntoConsole() {
        FileProcessor.readFileIntoConsole(null);
        assertEquals("Имя файла не определено\r\n",outContent.toString());
    }

    @Test
    public void readNonExistedFileIntoConsole() {
        FileProcessor.readFileIntoConsole("NotAFile.file");
        assertEquals("Файл не найден\r\n",outContent.toString());
    }

    @Test
    public void combineFiveFiles() {
        String sourceFile1 = "C:\\Users\\SBerdyshev\\IdeaProjects\\geekBrainsJavaCoreProfessional\\src\\main\\resources\\ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource1.txt";
        String sourceFile2 = "C:\\Users\\SBerdyshev\\IdeaProjects\\geekBrainsJavaCoreProfessional\\src\\main\\resources\\ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource2.txt";
        String sourceFile3 = "C:\\Users\\SBerdyshev\\IdeaProjects\\geekBrainsJavaCoreProfessional\\src\\main\\resources\\ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource3.txt";
        String sourceFile4 = "C:\\Users\\SBerdyshev\\IdeaProjects\\geekBrainsJavaCoreProfessional\\src\\main\\resources\\ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource4.txt";
        String sourceFile5 = "C:\\Users\\SBerdyshev\\IdeaProjects\\geekBrainsJavaCoreProfessional\\src\\main\\resources\\ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource5.txt";
        String destinationFile = "C:\\Users\\SBerdyshev\\IdeaProjects\\geekBrainsJavaCoreProfessional\\src\\main\\resources\\ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\destinationFile.txt";
        FileProcessor.combineFiveFilesIntoOne(sourceFile1,sourceFile2,sourceFile3,sourceFile4,sourceFile5,destinationFile);
        if (destinationFile == null) {
            System.out.println("Имя файла не определено");
        } else {
            try {
                FileInputStream fis = new FileInputStream(destinationFile);
                int byteArrayMaxLengh = 50;
                byte[] buffer = new byte[byteArrayMaxLengh];
                int actualLength = fis.read(buffer);
                byte[] resultArray = new byte[actualLength];
                for (int i = 0; i < actualLength; i++) {
                    resultArray[i] = buffer[i];
                }
                for (byte a : resultArray)
                    System.out.print((char) a);
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        assertEquals("12233\r\n3444455555\r\niwruoefhpiuewrhfeqihgoih348yt93fhq^^%#%)+^)*&$^%%#J:KJG:GP(T&^$%&#%RUFG",outContent.toString());
    }
}
