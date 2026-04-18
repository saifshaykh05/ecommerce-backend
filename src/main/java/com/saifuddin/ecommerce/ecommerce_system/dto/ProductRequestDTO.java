package com.saifuddin.ecommerce.ecommerce_system.dto;

import java.math.BigDecimal;

public class ProductRequestDTO {
    private String productName;
    private BigDecimal price;
    private String description;
    private int stock;
    private String category;
    public ProductRequestDTO(){}

    public ProductRequestDTO(String productname, BigDecimal price, String description, int stock, String category) {
        this.productName = productname;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productname) {
        this.productName = productname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
