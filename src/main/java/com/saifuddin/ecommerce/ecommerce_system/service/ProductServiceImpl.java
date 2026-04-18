package com.saifuddin.ecommerce.ecommerce_system.service;

import com.saifuddin.ecommerce.ecommerce_system.dto.ProductRequestDTO;
import com.saifuddin.ecommerce.ecommerce_system.dto.ProductResponseDTO;
import com.saifuddin.ecommerce.ecommerce_system.entity.Product;
import com.saifuddin.ecommerce.ecommerce_system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    public List<ProductResponseDTO> getAllProducts(){
        List<Product> products=productRepository.findAll();
        List<ProductResponseDTO> responseDTOS=new ArrayList<>();
        for(Product product: products){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO(
                    product.getId(),
                    product.getProductName(),
                    product.getPrice(),
                    product.getDescription(),
                    product.getStock(),     // ✅ add this
                    product.getCategory()
            );
            responseDTOS.add(productResponseDTO);
        }
        return responseDTOS;
    }
    public String addProduct(ProductRequestDTO productRequestDTO){
        Product product=new Product();
        product.setProductName(productRequestDTO.getProductName());
        product.setDescription(productRequestDTO.getDescription());
        product.setStock(productRequestDTO.getStock());
        product.setCategory(productRequestDTO.getCategory());
        product.setPrice(productRequestDTO.getPrice());
        productRepository.save(product);
        return "Product Added Successfully";
    }
}
