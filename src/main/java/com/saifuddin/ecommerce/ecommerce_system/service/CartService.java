package com.saifuddin.ecommerce.ecommerce_system.service;

import com.saifuddin.ecommerce.ecommerce_system.entity.Cart;

import java.util.List;

public interface CartService {
    String addToCart(Long userid,Long productid,int quantity);
    List<Cart> getUserCart(Long userid);
    String removeFromCart(Long userid,Long productid);
}
