package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4;

import java.util.concurrent.*;

public class ExecutorServiceDemo {

    public static void main(String[] args) throws Exception {

    }

    public static void test() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future future = executorService.submit(new Callable() {
            public Object call() throws Exception {
                System.out.println("Асинхронный вызов");
                return "Результат из потока";
            }
        });
        System.out.println("future.get() = " + future.get());
        executorService.shutdown();
    }

    public static void test2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future future = executorService.submit(new Runnable() {
            public void run() {
                System.out.println("Асинхронная задача");
            }
        });
        future.get();  // вернет null если задача завершилась корректно
        executorService.shutdown();
    }

    public static void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Асинхронная задача");
            }
        });
        executorService.shutdown();
    }
}
