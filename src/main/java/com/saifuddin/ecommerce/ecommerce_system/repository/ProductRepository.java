package com.saifuddin.ecommerce.ecommerce_system.repository;

import com.saifuddin.ecommerce.ecommerce_system.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
