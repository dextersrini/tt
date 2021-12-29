package com.lessons.products.service;

import com.lessons.products.entity.Products;
import com.lessons.products.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private IProductRepository productRepository;

    /**
     * Get All Products
     * @return List of all Products
     */
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Get Product by Id
     * @param id unique id of the product
     * @return Product object
     */
    public Products getProductById(int id) {
        return productRepository.findById(id).get();
    }

    /**
     * add a new Product
     * @param products
     */
    public void addProduct(Products products) {
        productRepository.save(products);
    }

    /**
     * Delete a product by productID
     * @param id
     */
    public void delProduct(int id) {
        productRepository.delete(productRepository.findById(id).get());
    }
}
