package com.lessons.products.controller;

import com.lessons.products.entity.Products;
import com.lessons.products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsRestController {

    @Autowired
    private ProductsService productsService;

    //test method to be deleted
    @GetMapping("/greet")
    public String greetMe() {
        return "Hello there";
    }

    //get all products
    @GetMapping("/products")
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Products getProductById(@RequestParam("id") int id) {
        return productsService.getProductById(id);
    }

    //add a new product
    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Products product) {
        productsService.addProduct(product);
    }

    //delete a product
    @DeleteMapping("/delProduct/{id}")
    public void delProduct(@RequestParam("id") int id) {
        productsService.delProduct(id);
    }

}
