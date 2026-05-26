package com.api.estoque.controllers;

import com.api.estoque.entity.Product;
import com.api.estoque.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Criar produto
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {

        Product createdProduct = productService.create(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdProduct);
    }

    // Listar todos os produtos
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {

        List<Product> products = productService.list();

        return ResponseEntity.ok(products);
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {

        Product product = productService.findById(id);

        return ResponseEntity.ok(product);
    }

    // Atualizar produto
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable Long id,
            @RequestBody Product product
    ) {

        Product updatedProduct = productService.update(id, product);

        return ResponseEntity.ok(updatedProduct);
    }

    // Deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        productService.delete(id);

        return ResponseEntity.noContent().build();
    }
}