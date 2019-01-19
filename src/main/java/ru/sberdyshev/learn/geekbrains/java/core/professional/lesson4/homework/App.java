package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework.handler.letter.LetterHandler;

public class App {
    public static void main(String[] args) {

        LetterHandler letterHandler = new LetterHandler(3);
        new Thread(() -> letterHandler.printLetter("A", "C", true)).start();;
        new Thread(() -> letterHandler.printLetter("B", "A", false)).start();;
        new Thread(() -> letterHandler.printLetter("C", "B", false)).start();;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
