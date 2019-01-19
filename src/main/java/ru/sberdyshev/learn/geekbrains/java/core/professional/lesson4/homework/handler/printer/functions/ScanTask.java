package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework.handler.printer.functions;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Callable;

@Getter
@Setter
public class ScanTask implements Callable<String> {
    private String doc;

    public ScanTask(String doc) {
        this.doc = doc;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        System.out.println(doc);
        return doc;
    }
}
