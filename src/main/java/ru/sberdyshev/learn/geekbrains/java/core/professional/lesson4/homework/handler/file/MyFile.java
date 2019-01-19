package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework.handler.file;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.net.URI;

public class MyFile extends File {
    @Setter
    @Getter
    private String lockedBy;

    public MyFile(@NotNull String pathname) {
        super(pathname);
    }

    public MyFile(String parent, @NotNull String child) {
        super(parent, child);
    }

    public MyFile(File parent, @NotNull String child) {
        super(parent, child);
    }

    public MyFile(@NotNull URI uri) {
        super(uri);
    }


}
