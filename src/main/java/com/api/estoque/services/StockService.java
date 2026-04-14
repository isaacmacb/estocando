package com.api.estoque.services;

import com.api.estoque.entity.MovementType;
import com.api.estoque.entity.Product;
import com.api.estoque.entity.StockMovement;
import com.api.estoque.entity.Tenant;
import com.api.estoque.repository.StockMovementRepository;
import com.api.estoque.repository.TenantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final StockMovementRepository stockMovementRepository;
    private final TenantRepository tenantRepository;

    public StockService(StockMovementRepository stockMovementRepository, TenantRepository tenantRepository) {
        this.stockMovementRepository = stockMovementRepository;
        this.tenantRepository = tenantRepository;
    }

    @Transactional
    public void entrada(Product product, Integer quantidade, Long tenantId) {

        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant não encontrado"));

        StockMovement movement = new StockMovement();
        movement.setProduct(product);
        movement.setQuantity(quantidade);
        movement.setType(MovementType.ENTRADA);
        movement.setTenant(tenant); // 👈 agora correto

        stockMovementRepository.save(movement);
    }

}
