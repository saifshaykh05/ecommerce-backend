package com.saifuddin.ecommerce.ecommerce_system.repository;

import com.saifuddin.ecommerce.ecommerce_system.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Long> {

}
