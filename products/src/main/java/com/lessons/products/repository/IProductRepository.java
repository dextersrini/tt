package com.lessons.products.repository;

import com.lessons.products.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Products, Integer> {
}
