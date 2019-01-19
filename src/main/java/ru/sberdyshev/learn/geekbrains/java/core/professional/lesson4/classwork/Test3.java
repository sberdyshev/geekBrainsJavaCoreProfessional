package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.classwork;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " Start");
        new Thread(() -> method()).start();
        new Thread(() -> method()).start();
    }

    public synchronized static void method() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
