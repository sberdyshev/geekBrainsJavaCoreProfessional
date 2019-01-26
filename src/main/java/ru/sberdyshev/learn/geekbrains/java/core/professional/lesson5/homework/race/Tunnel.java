package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson5.homework.race;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore tunnelSpace;

    public Tunnel(int length, int carsCount) {
        this.length = length;
        this.description = "Тоннель " + length + " метров";
        tunnelSpace = new Semaphore(carsCount/2);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                tunnelSpace.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                tunnelSpace.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
