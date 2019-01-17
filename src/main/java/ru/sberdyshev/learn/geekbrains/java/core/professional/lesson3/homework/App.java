package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework.control.CLIController;

public class App {
    public static void main(String[] args) {
//        FileProcessor.readFileIntoConsole("NotAFile.file");
        CLIController fileProcessor = new CLIController();
        fileProcessor.startReading();
    }
}
