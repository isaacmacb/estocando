package com.api.estoque.repository;

import com.api.estoque.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByTenantId(Long tenantId);
}
