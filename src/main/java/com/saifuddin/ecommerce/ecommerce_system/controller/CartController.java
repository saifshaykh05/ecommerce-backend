package com.saifuddin.ecommerce.ecommerce_system.controller;

import com.saifuddin.ecommerce.ecommerce_system.entity.Cart;
import com.saifuddin.ecommerce.ecommerce_system.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // 👉 Add to cart
    @PostMapping("/add")
    public String addToCart(@RequestParam Long userId,
                            @RequestParam Long productId,
                            @RequestParam int quantity) {
        return cartService.addToCart(userId, productId, quantity);
    }

    // 👉 Get all cart items of user
    @GetMapping("/get")
    public List<Cart> getCart(@RequestParam Long userId) {
        return cartService.getUserCart(userId);
    }

    // 👉 Remove item from cart
    @DeleteMapping("/remove")
    public String removeFromCart(@RequestParam Long userId,
                                 @RequestParam Long productId) {
        return cartService.removeFromCart(userId, productId);
    }
}
