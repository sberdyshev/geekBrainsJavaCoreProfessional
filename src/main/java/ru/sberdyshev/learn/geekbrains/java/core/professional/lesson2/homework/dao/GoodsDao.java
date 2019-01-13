package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.dao;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.model.Good;

import java.util.List;

/**
 * @author sberdyshev
 */
public interface GoodsDao {

    List<Good> getAllGoods();

    List<Good> getGoodsWithSpecificPrice(double lowestPrice, double highestPrice);

    Double getGoodPrice(String title);

    int changeGoodPrice(String title, double cost);

    boolean fillGoods();
}
