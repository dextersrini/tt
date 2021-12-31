package com.lessons.products.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {

    @Id
    private int productId;
    private String productName;
    private String productType;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

}