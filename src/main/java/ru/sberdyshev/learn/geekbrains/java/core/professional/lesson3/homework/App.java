package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework.processor.file.FileProcessor;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        FileProcessor.readFileIntoConsole("NotAFile.file");
    }
}
