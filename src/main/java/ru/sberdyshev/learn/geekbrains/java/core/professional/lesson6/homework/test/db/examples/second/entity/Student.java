package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.entity;

import lombok.Getter;

/**
 * @author sberdyshev
 */
@Getter
public class Student {
    private String name;
    private Integer id;
    private Integer score;

    public Student(Integer id, String name, Integer score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }
}