package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.fruits;

import org.jetbrains.annotations.NotNull;

/**
 * @author SBerdyshev
 */
public class Orange extends Fruit {
    private final float weight = 1.5f;

    @NotNull
    @Override
    public float getWeight() {
        return weight;
    }
}
