package com.example.cacheimplementationinspringboot.service.impl;

import com.example.cacheimplementationinspringboot.entity.Product;
import com.example.cacheimplementationinspringboot.repo.ProductRepo;
import com.example.cacheimplementationinspringboot.service.ProductService;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> getAllProducts() {
        if(myCache.getIfPresent("products") !=  null){
            List<Product>  list  = myCache.getIfPresent("products");
            System.out.println("we are retrieving the products from the cache");
            return list;
        }
       List<Product>  productList  = productRepo.findAll();
       myCache.put("products", productList);
        System.out.println("list of products is inserted in cache ");
       // System.out.println(myCache.estimatedSize());
       return productList;
    }
    @Override
    public Product insertProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public String evictCache() {
        System.out.println("the cache size before eviction is " + myCache.estimatedSize());
       //myCache.invalidate("products");
        myCache.invalidateAll();
       System.out.println("the cache size after eviction is " + myCache.estimatedSize());

        return "MyCache is evicted Successfully";
    }

    private Cache<String ,List<Product>> myCache;

    @PostConstruct
    private void initCache() {

        myCache = Caffeine.newBuilder()
                .maximumSize(100)
                .build();
    }

}
