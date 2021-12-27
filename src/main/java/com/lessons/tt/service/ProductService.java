package com.lessons.tt.service;

import com.lessons.tt.entity.ProductBean;
import com.lessons.tt.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepository prodRepo;
    public List<ProductBean> getAllProducts(){
        return prodRepo.findAll();
    }
    public void addProduct(ProductBean productBean) {
        prodRepo.save(productBean);
    }
    public void delProduct(int id){
        prodRepo.delete(prodRepo.findById(id).get());
    }
    public ProductBean getProduct(int id) {
        return prodRepo.findById(id).get();
    }
}
