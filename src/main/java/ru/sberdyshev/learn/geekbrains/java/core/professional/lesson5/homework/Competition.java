package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson5.homework;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson5.homework.race.Car;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson5.homework.race.Race;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson5.homework.race.Road;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson5.homework.race.Tunnel;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Competition {

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        CountDownLatch everybodyReady = new CountDownLatch(CARS_COUNT);
        CyclicBarrier raceStarted = new CyclicBarrier(CARS_COUNT+1);
        CountDownLatch everybodyFinished = new CountDownLatch(CARS_COUNT);

        int firstRoadLenth = 100 + (int) (Math.random() * 200);
        int tunnelLenth = 100 + (int) (Math.random() * 400);
        int secondRoadLenth = 100 + (int) (Math.random() * 50);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(firstRoadLenth), new Tunnel(tunnelLenth, CARS_COUNT), new Road(secondRoadLenth));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 50), everybodyReady, raceStarted, everybodyFinished);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            everybodyReady.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            raceStarted.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        try {
            everybodyFinished.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
