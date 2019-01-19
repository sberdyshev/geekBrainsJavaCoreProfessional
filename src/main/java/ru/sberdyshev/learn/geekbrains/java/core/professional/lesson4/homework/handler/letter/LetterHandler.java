package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework.handler.letter;

public class LetterHandler {
    private String currentLetter;
    private int amountOfCicles;

    public LetterHandler() {
        this.currentLetter = null;
        this.amountOfCicles = 3;
    }

    public LetterHandler(int amountOfCicles) {
        this.currentLetter = null;
        this.amountOfCicles = amountOfCicles;
    }

    public void printLetter(String letterToShow, String afterLetter, boolean isFirstLetter) {
        for (int i = 0; i < amountOfCicles; i++) {
            synchronized (this) {
                while (!((afterLetter.equals(currentLetter)) || ((currentLetter == null) && isFirstLetter))) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(letterToShow);
                currentLetter = letterToShow;

                this.notifyAll();
            }
        }
    }
}
