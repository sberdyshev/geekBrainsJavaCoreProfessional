package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson5.homework.race;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private CountDownLatch amountOfCarsNotReady;
    private CyclicBarrier raceStarted;
    private CountDownLatch amountOfCarsNotFinished;
    private Race race;
    private int speed;
    private String name;

    public Car(Race race, int speed, CountDownLatch amountOfCarsNotReady, CyclicBarrier raceStarted, CountDownLatch amountOfCarsNotFinished) {
        this.race = race;
        this.speed = speed;
        this.amountOfCarsNotReady = amountOfCarsNotReady;
        this.raceStarted = raceStarted;
        this.amountOfCarsNotFinished = amountOfCarsNotFinished;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится. Заявленная скорость: " + speed);
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            amountOfCarsNotReady.countDown();
            raceStarted.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (amountOfCarsNotFinished.getCount() == CARS_COUNT) {
            System.out.println(this.name + " WINNER");
        } else if (amountOfCarsNotFinished.getCount() == CARS_COUNT - 1) {
            System.out.println(this.name + " 2ND PLACE");
        } else if (amountOfCarsNotFinished.getCount() == CARS_COUNT - 2) {
            System.out.println(this.name + " 3RD PLACE");
        } else {
            System.out.println(this.name + " LOOSER");
        }
        amountOfCarsNotFinished.countDown();

    }
}
