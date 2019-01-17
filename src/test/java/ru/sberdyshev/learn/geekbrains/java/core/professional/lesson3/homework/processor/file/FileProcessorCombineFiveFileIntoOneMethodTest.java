package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework.processor.file;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class FileProcessorCombineFiveFileIntoOneMethodTest {
    private final String rootPath = "C:\\Users\\SBerdyshev\\IdeaProjects\\geekBrainsJavaCoreProfessional\\src\\main\\resources\\";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private static void clearDestinationFile(String destinationFilePath) throws IOException {
        if (destinationFilePath != null) {
            File destinationFile = new File(destinationFilePath);
            if (destinationFile.exists()) {
                destinationFile.delete();
                destinationFile.createNewFile();
            }
        }
    }

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
    public void combineFiveFiles() throws IOException {
        final byte[] expectedArray = "12233\r\n3444455555\r\niwruoefhpiuewrhfeqihgoih348yt93fhq^^%#%)+^)*&$^%%#J:KJG:GP(T&^$%&#%RUFG".getBytes();

        String sourceFile1 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource1.txt";
        String sourceFile2 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource2.txt";
        String sourceFile3 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource3.txt";
        String sourceFile4 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource4.txt";
        String sourceFile5 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource5.txt";
        String destinationFile = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\destinationFile_combineFiveFiles.txt";
        clearDestinationFile(destinationFile);

        FileProcessor.combineFiveFilesIntoOne(sourceFile1, sourceFile2, sourceFile3, sourceFile4, sourceFile5, destinationFile);

        byte[] resultArray;
        FileInputStream fis = new FileInputStream(destinationFile);
        int byteArrayMaxLengh = 100;
        byte[] buffer = new byte[byteArrayMaxLengh];
        int actualLength = fis.read(buffer);
        if (actualLength == -1) {
            resultArray = new byte[0];
        } else {
            resultArray = new byte[actualLength];
        }
        for (int i = 0; i < actualLength; i++) {
            resultArray[i] = buffer[i];
        }
        assertEquals(new String(expectedArray), new String(resultArray));
    }

    @Test
    public void combineFiveFilesNullSourceFileNames() throws IOException {
        final byte[] expectedArray = "".getBytes();

        String sourceFile1 = null;
        String sourceFile2 = null;
        String sourceFile3 = null;
        String sourceFile4 = null;
        String sourceFile5 = null;
        String destinationFile = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\destinationFile_combineFiveFilesNullSourceFileNames.txt";
        clearDestinationFile(destinationFile);

        FileProcessor.combineFiveFilesIntoOne(sourceFile1, sourceFile2, sourceFile3, sourceFile4, sourceFile5, destinationFile);

        byte[] resultArray;
        FileInputStream fis = new FileInputStream(destinationFile);
        int byteArrayMaxLengh = 100;
        byte[] buffer = new byte[byteArrayMaxLengh];
        int actualLength = fis.read(buffer);
        if (actualLength == -1) {
            resultArray = new byte[0];
        } else {
            resultArray = new byte[actualLength];
        }
        for (int i = 0; i < actualLength; i++) {
            resultArray[i] = buffer[i];
        }
        assertEquals(new String(expectedArray), new String(resultArray));
    }

    @Test
    public void combineSourceFileNamesWithOneNullFileName() throws IOException {
        final byte[] expectedArray = "1224444".getBytes();

        String sourceFile1 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource1.txt";
        String sourceFile2 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource2.txt";
        String sourceFile3 = null;
        String sourceFile4 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource4.txt";
        String sourceFile5 = null;
        String destinationFile = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\destinationFile_combineSourceFileNamesWithOneNullFileName.txt";
        clearDestinationFile(destinationFile);

        FileProcessor.combineFiveFilesIntoOne(sourceFile1, sourceFile2, sourceFile3, sourceFile4, sourceFile5, destinationFile);

        byte[] resultArray;
        FileInputStream fis = new FileInputStream(destinationFile);
        int byteArrayMaxLengh = 100;
        byte[] buffer = new byte[byteArrayMaxLengh];
        int actualLength = fis.read(buffer);
        if (actualLength == -1) {
            resultArray = new byte[0];
        } else {
            resultArray = new byte[actualLength];
        }
        for (int i = 0; i < actualLength; i++) {
            resultArray[i] = buffer[i];
        }
        assertEquals(new String(expectedArray), new String(resultArray));
    }

    @Test
    public void combineFiveFilesInNullDestinationFileName() throws IOException {
        final String expectedOutput = "Имя конечного файла не определено";

        String sourceFile1 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource1.txt";
        String sourceFile2 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource2.txt";
        String sourceFile3 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource3.txt";
        String sourceFile4 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource4.txt";
        String sourceFile5 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource5.txt";
        String destinationFile = null;

        FileProcessor.combineFiveFilesIntoOne(sourceFile1, sourceFile2, sourceFile3, sourceFile4, sourceFile5, destinationFile);

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void combineFiveFilesNotExistedSourceFiles() throws IOException {
        final byte[] expectedArray = "2233\r\n34444".getBytes();

        String sourceFile1 = "file1";
        String sourceFile2 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource2.txt";
        String sourceFile3 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource3.txt";
        String sourceFile4 = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\testCombineFilesSource4.txt";
        String sourceFile5 = "fileX";
        String destinationFile = rootPath + "ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson3.homework\\task1\\destinationFile_combineFiveFilesNotExistedSourceFiles.txt";
        clearDestinationFile(destinationFile);

        FileProcessor.combineFiveFilesIntoOne(sourceFile1, sourceFile2, sourceFile3, sourceFile4, sourceFile5, destinationFile);

        byte[] resultArray;
        FileInputStream fis = new FileInputStream(destinationFile);
        int byteArrayMaxLengh = 100;
        byte[] buffer = new byte[byteArrayMaxLengh];
        int actualLength = fis.read(buffer);
        if (actualLength == -1) {
            resultArray = new byte[0];
        } else {
            resultArray = new byte[actualLength];
        }
        for (int i = 0; i < actualLength; i++) {
            resultArray[i] = buffer[i];
        }
        assertEquals(new String(expectedArray), new String(resultArray));
    }
}
