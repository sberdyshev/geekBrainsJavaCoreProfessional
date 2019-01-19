package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4;

public class Test2 {
    public static void main(String[] args) {
        Test2 e1 = new Test2();
        new Thread(() -> e1.method1()).start();
        new Thread(() -> e1.method2()).start();
    }

    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " M1");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " M2");
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " M1");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " M2");
    }
}
