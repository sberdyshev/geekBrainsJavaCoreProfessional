package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework.processor.file.exception;

import java.io.FileNotFoundException;

public class DestinationFileIsADirectoryException extends FileNotFoundException {
    public DestinationFileIsADirectoryException(String descr) {
        super(descr);
    }
}
