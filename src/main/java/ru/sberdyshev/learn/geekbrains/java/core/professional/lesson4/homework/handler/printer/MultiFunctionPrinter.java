package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework.handler.printer;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework.handler.printer.functions.PrintTask;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework.handler.printer.functions.ScanTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiFunctionPrinter {
    private ExecutorService printerQueue;
    private ExecutorService scannerQueue;

    public MultiFunctionPrinter() {
        printerQueue = Executors.newFixedThreadPool(1);
        scannerQueue = Executors.newFixedThreadPool(1);
    }

    public void printDoc(String document) {
        PrintTask printTask = new PrintTask(document);
        printerQueue.submit(printTask);
    }

    public void printSeveralDocs(List<String> documents) {
        List<PrintTask> printTasks = new ArrayList<>();
        for(String document : documents) {
            printTasks.add(new PrintTask(document));
        }
        try {
            printerQueue.invokeAll(printTasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scanDoc(String document) {
        ScanTask scanTask = new ScanTask(document);
        Future<String> scannedDoc = scannerQueue.submit(scanTask);
        try {
            System.out.println("Document scanned: " + scannedDoc.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
