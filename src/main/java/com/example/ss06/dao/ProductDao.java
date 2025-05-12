package com.example.ss06.dao;

import com.example.ss06.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    boolean addProductToCart(int userId, int productId, int quantity);
}
