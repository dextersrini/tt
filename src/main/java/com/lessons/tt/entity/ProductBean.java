package com.lessons.tt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductBean {

    //empty constructure
    public ProductBean(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Id
    private int id;
    private String productName;
    private String productType;

}
