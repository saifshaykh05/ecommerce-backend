package com.saifuddin.ecommerce.ecommerce_system.service;

import com.saifuddin.ecommerce.ecommerce_system.entity.Cart;
import com.saifuddin.ecommerce.ecommerce_system.entity.Product;
import com.saifuddin.ecommerce.ecommerce_system.repository.CartRepository;
import com.saifuddin.ecommerce.ecommerce_system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    public String addToCart(Long userid,Long productid,int quantity){
        Product product=productRepository.findById(productid).orElseThrow(
                ()-> new RuntimeException("Product not found"));
        if(product.getStock()<quantity){
            throw new RuntimeException("Stock not  available");
        }
        Optional<Cart> existingcart=cartRepository.findByUserIdAndProductId(userid,productid);
        if(existingcart.isPresent()){
            Cart cart=existingcart.get();
            int newQuantity=cart.getQuantity()+quantity;
            if(product.getStock()<newQuantity){
                throw new RuntimeException("Stock not available");
            }
            cart.setQuantity(newQuantity);
            BigDecimal total = product.getPrice().multiply(BigDecimal.valueOf(newQuantity));
            cart.setTotalPrice(total);
            cartRepository.save(cart);
        }
        else {
            Cart cart= new Cart();
            cart.setUserId(userid);
            cart.setProductId(productid);
            cart.setQuantity(quantity);
            cart.setPrice(product.getPrice());
            BigDecimal total = product.getPrice().multiply(BigDecimal.valueOf(quantity));
            cart.setTotalPrice(total);
            cartRepository.save(cart);
        }
        return "Cart Updated";
    }
    public List<Cart> getUserCart(Long userid){
        return cartRepository.findAll();
    }
    public String removeFromCart(Long userid,Long productid){
        cartRepository.deleteByUserIdAndProductId(userid,productid);
        return "removed the product";
    }
}