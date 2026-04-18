package com.saifuddin.ecommerce.ecommerce_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive @NotNull
    private Long userId;
    @Positive @NotNull
    private Long productId;
    private int quantity;
    private BigDecimal price;
    private BigDecimal totalPrice;
    public Cart(){}

    public Cart(Long id, Long userid, Long productid, int quantity, BigDecimal price, BigDecimal totalprice) {
        this.id = id;
        this.userId = userid;
        this.productId = productid;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalprice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userid) {
        this.userId = userid;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productid) {
        this.productId = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalprice) {
        this.totalPrice = totalprice;
    }
}
