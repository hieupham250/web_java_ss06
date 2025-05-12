package com.example.ss06.service;

import com.example.ss06.dao.ProductDao;
import com.example.ss06.dao.ProductDaoImp;
import com.example.ss06.model.Product;

import java.util.List;

public class ProductServiceImp implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImp() {
        productDao = new ProductDaoImp();
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public boolean addProductToCart(int userId, int productId, int quantity) {
        return productDao.addProductToCart(userId, productId, quantity);
    }
}
