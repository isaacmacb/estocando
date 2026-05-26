package com.api.estoque.services;

import com.api.estoque.entity.Product;
import com.api.estoque.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    // Criar produto
    public Product create(Product product) {
        return repository.save(product);
    }

    // Listar produtos
    public List<Product> list() {
        return repository.findAll();
    }

    // Buscar por ID
    public Product findById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // Atualizar produto
    public Product update(Long id, Product product) {

        Product existingProduct = findById(id);

        existingProduct.setName(product.getName());
        existingProduct.setSku(product.getSku());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setActive(product.isActive());

        return repository.save(existingProduct);
    }

    // Deletar produto
    public void delete(Long id) {

        Product product = findById(id);

        repository.delete(product);
    }
}