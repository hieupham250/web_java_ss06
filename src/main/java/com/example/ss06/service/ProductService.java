package com.example.ss06.service;

import com.example.ss06.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    boolean addProductToCart(int userId, int productId, int quantity);
}
