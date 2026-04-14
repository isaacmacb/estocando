package com.api.estoque.services;

import com.api.estoque.entity.Product;
import com.api.estoque.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product create(Product product) {
        return productRepository.save(product);
    }
    public List<Product> list(Long tenantId) {
        return productRepository.findByTenantId(tenantId);
    }
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
