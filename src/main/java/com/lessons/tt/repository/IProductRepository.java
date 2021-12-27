package com.lessons.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.lessons.tt.entity.ProductBean;

public interface IProductRepository extends JpaRepository<ProductBean, Integer> {
}
