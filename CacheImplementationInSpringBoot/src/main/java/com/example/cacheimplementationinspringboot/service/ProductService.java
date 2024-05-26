package com.example.cacheimplementationinspringboot.service;

import com.example.cacheimplementationinspringboot.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product insertProduct(Product product);

    String evictCache();
}
