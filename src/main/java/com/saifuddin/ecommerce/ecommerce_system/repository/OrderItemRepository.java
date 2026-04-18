package com.saifuddin.ecommerce.ecommerce_system.repository;

import com.saifuddin.ecommerce.ecommerce_system.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItems,Long> {
}
