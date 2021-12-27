package com.lessons.tt.controller;

import com.lessons.tt.entity.ProductBean;
import com.lessons.tt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    ProductService prodService;

    @GetMapping(path = "/greet")
    public String greetMe(){
        return "Hello there";
    }

    @PostMapping(path = "/addProduct")
    public void addProduct(@RequestBody ProductBean productBean) {
        prodService.addProduct(productBean);
    }

    @DeleteMapping(path = "/delProduct/{id}")
    public void delProduct(@PathVariable("id") int id) {
        prodService.delProduct(id);
    }

    @GetMapping(path = "/products")
/*    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})*/
    public List<ProductBean> getAllProducts() throws InterruptedException{
        Thread.sleep(3000);
        return prodService.getAllProducts();
    }

    private String fallback() {
        return "Request taking longer than expected. Please try again later ";
    }

    @GetMapping(path = "/products/{id}")
    public ProductBean getProduct(@PathVariable("id") int id) {
        return prodService.getProduct(id);
    }

}
