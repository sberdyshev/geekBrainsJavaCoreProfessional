package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson5.classwork.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        // критическая секция
        lock.unlock();
    }
}
