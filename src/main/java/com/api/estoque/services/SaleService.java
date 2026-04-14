package com.api.estoque.services;

import com.api.estoque.entity.MovementType;
import com.api.estoque.entity.Sale;
import com.api.estoque.entity.SaleItem;
import com.api.estoque.entity.StockMovement;
import com.api.estoque.repository.SaleRepository;
import com.api.estoque.repository.StockMovementRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    final private SaleRepository saleRepository;
    final private StockMovementRepository stockMovementRepository;

    public SaleService(SaleRepository saleRepository, StockMovementRepository stockMovementRepository) {
        this.saleRepository = saleRepository;
        this.stockMovementRepository = stockMovementRepository;
    }

    @Transactional
    public Sale createSale(Sale sale) {

        Sale savedSale = saleRepository.save(sale);

        for (SaleItem item : sale.getItems()) {

            StockMovement movement = new StockMovement();
            movement.setProduct(item.getProduct());
            movement.setQuantity(item.getQuantity());
            movement.setType(MovementType.SAIDA);

            stockMovementRepository.save(movement);
        }

        return savedSale;
    }
}
