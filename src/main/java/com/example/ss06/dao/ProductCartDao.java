package com.example.ss06.dao;

import com.example.ss06.model.ProductCart;

import java.util.List;

public interface ProductCartDao {
    List<ProductCart> findCartByUserId(int userId);
    boolean removeProductFromCart(int userId, int productId);
}
