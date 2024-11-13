package com.wuppski.microservices.ms_inventory.service;

import com.wuppski.microservices.ms_inventory.repository.InventoryRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRespository inventoryRespository;

    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRespository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
