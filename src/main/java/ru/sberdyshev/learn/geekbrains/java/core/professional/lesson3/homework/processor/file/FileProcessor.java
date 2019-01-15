package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework.processor.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileProcessor {

    public static void readFileIntoConsole(String fileName) {
        if (fileName == null) {
            System.out.println("Имя файла не определено");
        } else {
            try {
                FileInputStream fis = new FileInputStream(fileName);
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
    }

    public static void combineFiveFilesIntoOne(String sourceFileName1,String sourceFileName2,String sourceFileName3,String sourceFileName4,String sourceFileName5,String destinationFile) {
    }

}
