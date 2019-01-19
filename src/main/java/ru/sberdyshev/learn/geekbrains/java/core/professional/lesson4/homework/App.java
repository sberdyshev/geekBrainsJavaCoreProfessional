package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework.handler.file.FileWriter;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework.handler.file.MyFile;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework.handler.letter.LetterHandler;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework.handler.printer.MultiFunctionPrinter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

//        LetterHandler letterHandler = new LetterHandler(3);
//        new Thread(() -> letterHandler.printLetter("A", "C", true)).start();
//        new Thread(() -> letterHandler.printLetter("B", "A", false)).start();
//        new Thread(() -> letterHandler.printLetter("C", "B", false)).start();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        MyFile file = new MyFile("C:\\Users\\SBerdyshev\\IdeaProjects\\geekBrainsJavaCoreProfessional\\src\\main\\resources\\ru.sberdyshev\\learn.geekbrains.java.core.professional.lesson4.homework\\task2\\testFile.txt");
//        if (file.exists() && file.isFile()) {
//            file.delete();
//        }
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FileWriter fileWriter1 = new FileWriter("Writer1", "11111111111111111111111", 100, 10, file);
//        FileWriter fileWriter2 = new FileWriter("Writer2", "22222222222222222222222", 100, 10, file);
//        FileWriter fileWriter3 = new FileWriter("Writer3", "33333333333333333333333", 100, 10, file);
//
//        new Thread(fileWriter1).start();
//        new Thread(fileWriter2).start();
//        new Thread(fileWriter3).start();

        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.printDoc("doc1");
        mfp.scanDoc("doc2");
        List<String> listOfDocs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listOfDocs.add("document " + i);
        }
        mfp.printSeveralDocs(listOfDocs);

    }
}
