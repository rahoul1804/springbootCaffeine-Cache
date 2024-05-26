package com.example.cacheimplementationinspringboot.controller;

import com.example.cacheimplementationinspringboot.entity.Product;
import com.example.cacheimplementationinspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService      productService;

    @GetMapping("/products")
    List<Product>  getAllProducts(){
       return  productService.getAllProducts();
    }

    @PostMapping("/insert")
    Product insertProduct(@RequestBody Product product){
        return productService.insertProduct(product);
    }

}
