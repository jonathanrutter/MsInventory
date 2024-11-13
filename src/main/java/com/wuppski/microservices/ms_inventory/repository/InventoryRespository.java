package com.wuppski.microservices.ms_inventory.repository;

import com.wuppski.microservices.ms_inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRespository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
