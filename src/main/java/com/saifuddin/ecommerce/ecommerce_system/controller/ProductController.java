package com.saifuddin.ecommerce.ecommerce_system.controller;

import com.saifuddin.ecommerce.ecommerce_system.dto.ProductRequestDTO;
import com.saifuddin.ecommerce.ecommerce_system.dto.ProductResponseDTO;
import com.saifuddin.ecommerce.ecommerce_system.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 👉 Add Product
    @PostMapping("/add")
    public String addProduct(@RequestBody ProductRequestDTO requestDTO) {
        return productService.addProduct(requestDTO);
    }

    // 👉 Get All Products
    @GetMapping("/all")
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }
}
