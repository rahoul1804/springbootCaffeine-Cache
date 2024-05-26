package com.example.cacheimplementationinspringboot.repo;

import com.example.cacheimplementationinspringboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer > {
}
