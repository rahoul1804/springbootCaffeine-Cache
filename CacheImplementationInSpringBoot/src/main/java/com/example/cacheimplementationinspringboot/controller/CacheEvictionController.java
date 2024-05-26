package com.example.cacheimplementationinspringboot.controller;

import com.example.cacheimplementationinspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheEvictionController {

    @Autowired
    private ProductService productService;
    @GetMapping("/evictProducts")

    public String evictCache(){
      return   productService.evictCache();
    }
}
