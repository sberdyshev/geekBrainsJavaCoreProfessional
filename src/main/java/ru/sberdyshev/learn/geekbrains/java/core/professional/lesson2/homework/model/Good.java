package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sberdyshev
 */
@Getter
@Setter
public class Good {
    private int id;
    private int prodid;
    private String title;
    private double cost;

    public Good(int id, int prodid, String title, double cost) {
        this.id = id;
        this.prodid = prodid;
        this.title = title;
        this.cost = cost;
    }
}
