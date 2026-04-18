package com.saifuddin.ecommerce.ecommerce_system.service;

import com.saifuddin.ecommerce.ecommerce_system.entity.Cart;
import com.saifuddin.ecommerce.ecommerce_system.entity.OrderItems;
import com.saifuddin.ecommerce.ecommerce_system.entity.Orders;
import com.saifuddin.ecommerce.ecommerce_system.entity.Product;
import com.saifuddin.ecommerce.ecommerce_system.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private OrdersRepository ordersRepository;
    private OrderItemRepository orderItemRepository;

    public OrderServiceImpl(ProductRepository productRepository, CartRepository cartRepository, OrdersRepository ordersRepository, OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.ordersRepository = ordersRepository;
        this.orderItemRepository = orderItemRepository;
    }
    @Transactional
    public String placeOrder(Long userid){
        List< Cart> cartItems=cartRepository.findByUserId(userid);
        if(cartItems.isEmpty()){
            throw new RuntimeException("Your Cart is Empty");
        }
        BigDecimal totalprice=BigDecimal.ZERO;
        for(Cart cart: cartItems){
            totalprice=totalprice.add(cart.getTotalPrice());
        }
        Orders order= new Orders();
        order.setTotalAmount(totalprice);
        order.setStatus("Successfully Order Placed");
        order.setCreatedAt(LocalDateTime.now());
        order.setUserId(userid);
        ordersRepository.save(order);
        for(Cart cart : cartItems){
            Product product=productRepository.findById(cart.getProductId()).orElseThrow(()->  new RuntimeException("Produnt not found"));
            if(product.getStock()<cart.getQuantity()){
                throw new RuntimeException("Stock not available");
            }
            product.setStock(product.getStock()-cart.getQuantity());
            productRepository.save(product);

            OrderItems orderItems=new OrderItems();
            orderItems.setOrderId(order.getId());
            orderItems.setQuantity(cart.getQuantity());
            orderItems.setPrice(cart.getPrice());
            orderItems.setTotalPrice(cart.getTotalPrice());
            orderItems.setProductId(cart.getProductId());
            orderItemRepository.save(orderItems);
        }
        cartRepository.deleteByUserId(userid);
        return "Order placed Successfully";
    }
}
