package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.classwork;

public class Test1 {
    private Object lock1 = new Object();

    public static void main(String[] args) {
        Test1 e2 = new Test1();
        System.out.println(Thread.currentThread().getName() + " Старт main потока");
        new Thread(() -> e2.method1()).start();
        new Thread(() -> e2.method1()).start();
    }

    public void method1() {
        System.out.println(Thread.currentThread().getName() + ": Метод запущен");
        System.out.println(Thread.currentThread().getName() + ": Блок 1 начало");
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ", Блок 1: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": Блок 1 конец");
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + ": Начало синхронизированного блока");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ", Блок 2: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": Конец синхронизированного блока");
        }
        System.out.println(Thread.currentThread().getName() + ": Метод завершил свою работу");
    }
}
