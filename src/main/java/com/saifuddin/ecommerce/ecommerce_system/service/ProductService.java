package com.saifuddin.ecommerce.ecommerce_system.service;

import com.saifuddin.ecommerce.ecommerce_system.dto.ProductRequestDTO;
import com.saifuddin.ecommerce.ecommerce_system.dto.ProductResponseDTO;
import com.saifuddin.ecommerce.ecommerce_system.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    public List<ProductResponseDTO> getAllProducts();
    public String addProduct(ProductRequestDTO productRequestDTO);
}
