package com.saifuddin.ecommerce.ecommerce_system.dto;

import java.math.BigDecimal;

public class ProductResponseDTO {
    private Long id;
    private String productName;
    private BigDecimal price;
    private String description;
    private String category;
    private int stock;
    public ProductResponseDTO(){}
    public ProductResponseDTO(Long id, String productName, BigDecimal price,
                              String description, int stock, String category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
