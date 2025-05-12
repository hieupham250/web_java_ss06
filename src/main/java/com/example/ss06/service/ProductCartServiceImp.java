package com.example.ss06.service;

import com.example.ss06.dao.ProductCartDao;
import com.example.ss06.dao.ProductCartDaoImp;
import com.example.ss06.model.ProductCart;

import java.util.List;

public class ProductCartServiceImp implements ProductCartService {
    private ProductCartDao productCartDao;

    public ProductCartServiceImp() {
        productCartDao = new ProductCartDaoImp();
    }

    @Override
    public List<ProductCart> findCartByUserId(int userId) {
        return productCartDao.findCartByUserId(userId);
    }

    @Override
    public boolean removeProductFromCart(int userId, int productId) {
        return productCartDao.removeProductFromCart(userId, productId);
    }
}
