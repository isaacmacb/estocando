package com.api.estoque.repository;

import com.api.estoque.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // busca todos os produtos que pertencem a um id específico
    List<Product> findByTenantId(Long tenantId);

    // busca flexivel, o containing gera um like %name% e o ignorecase ignora a diferença entre maiusculo e minisculo
    List<Product> findByNameContainingIgnoreCase(String name);

    // filtra produtos por uma categoria específica
    List<Product> findByCategoryId (Long categoryId);
}
