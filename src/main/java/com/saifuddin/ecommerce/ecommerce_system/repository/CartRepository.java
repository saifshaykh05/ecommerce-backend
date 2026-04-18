package com.saifuddin.ecommerce.ecommerce_system.repository;

import com.saifuddin.ecommerce.ecommerce_system.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Optional<Cart> findByUserIdAndProductId(Long userid,Long productid);
    List<Cart> findByUserId(Long userid);
    void deleteByUserIdAndProductId(Long userId, Long productId);
    void deleteByUserId(Long userId);
}
