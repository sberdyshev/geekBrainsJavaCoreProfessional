package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.fruits;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static ru.sberdyshev.learn.geekbrains.java.core.professional.lesson1.homework.fruits.tools.ConstantHelper.*;

/**
 * @author SBerdyshev
 */
@Getter
public class Box<T extends Fruit> {
    private final Class<T> classType;
    private List<T> box;
    @Setter
    private String boxName;

    public Box(@NotNull Class<T> classType, @NotNull final List<T> box, @NotNull final String boxName) {
        this.classType = classType;
        this.box = box;
        this.boxName = boxName;
    }

    public Box(@NotNull Class<T> classType, final int numberOfFruits, @NotNull final String boxName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        this.classType = classType;
        this.boxName = boxName;
        this.box = new ArrayList<T>();
        for (int i = 0; i < numberOfFruits; i++) {
//            Constructor<T> constructor = classType.getConstructor(classType);
            Constructor<T> constructor = classType.getConstructor();
            T fruit = constructor.newInstance();
            box.add(fruit);
        }
    }

    public float getWeight() {
        if (box == null) {
            return -1f;
        } else {
            float currentFruitTypeWeight;
            T firstFruit = null;
            if (box.size() == 0) {
                currentFruitTypeWeight = 0f;
            } else {
                firstFruit = box.get(BOX_FIRST_ELEMENT);
            }
            if (firstFruit == null) {
                currentFruitTypeWeight = 0f;
            } else {
                currentFruitTypeWeight = firstFruit.getWeight();
            }
            final int amountOfFruitsInTheBox = box.size();
            return (currentFruitTypeWeight * amountOfFruitsInTheBox);
        }
    }

    public void showWeight() {
        System.out.println(constructBoxWeightDescription(getBoxName(), getWeight()));
    }

    public boolean compare(@NotNull final Box<? extends Fruit> box) {
        if (box == null) {
            String comparingBoxOperationDescription = constructComparingBoxesOperationDescription(this.getBoxName(), BOX_NO_NAME);
            System.out.println(comparingBoxOperationDescription);
            return false;
        } else {
            String comparingBoxOperationDescription = constructComparingBoxesOperationDescription(this.getBoxName(), box.getBoxName());
            System.out.println(comparingBoxOperationDescription);
            if (box.getWeight() == this.getWeight()) {
                String result = constructBoxEqualResultDescription(box.getBoxName(), this.getBoxName());
                System.out.println(result);
                return true;
            } else {
                String result = constructBoxNotEqualResultDescription(box.getBoxName(), this.getBoxName());
                System.out.println(result);
                return false;
            }
        }
    }

    public boolean addFruit(@NotNull final T fruit) {
        String addingFruitOperationDescription = constructAddingFruitOperationDescription(this.getBoxName());
        System.out.println(addingFruitOperationDescription);
        box.add(fruit);
        return true;
    }

    public boolean fillBoxWithAnotherBox(@NotNull final Box<T> box) {
        String movingFruitsOperationDescription = constructMovingFruitsToAnotherBoxOperationDescription(this.getBoxName(), box.getBoxName());
        System.out.println(movingFruitsOperationDescription);
        List<T> incomingBox = box.getBox();
        Iterator<T> boxIterator = null;
        if (incomingBox != null) {
            boxIterator = incomingBox.iterator();
        } else {
            System.out.println(FRUITS_MOVING_STATUS_ERROR);
            return false;
        }
        while (boxIterator.hasNext()) {
            this.box.add(boxIterator.next());
        }
        incomingBox.clear();
        System.out.println(FRUITS_MOVING_STATUS_SUCCESS);
        return true;
    }
}
