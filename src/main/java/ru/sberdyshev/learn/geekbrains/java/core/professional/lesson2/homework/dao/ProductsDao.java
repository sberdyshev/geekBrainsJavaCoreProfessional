package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.dao;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.model.Product;

import java.util.List;

/**
 * @author sberdyshev
 */
public interface ProductsDao {

    List<Product> getAllGoods();

    List<Product> getGoodsWithSpecificPrice(double lowestPrice, double highestPrice);

    Double getGoodPrice(String title);

    int changeGoodPrice(String title, double cost);

    int fillGoods();
}
