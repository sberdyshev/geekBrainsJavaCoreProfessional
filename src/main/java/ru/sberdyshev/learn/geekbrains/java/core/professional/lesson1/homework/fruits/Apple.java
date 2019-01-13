package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.fruits;

import org.jetbrains.annotations.NotNull;

/**
 * @author SBerdyshev
 */
public class Apple extends Fruit {
    private final float weight = 1f;

    @NotNull
    @Override
    public float getWeight() {
        return weight;
    }
}
