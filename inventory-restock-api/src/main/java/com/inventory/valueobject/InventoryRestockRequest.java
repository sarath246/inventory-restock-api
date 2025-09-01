package com.inventory.valueobject;

import com.inventory.exception.ValidationException;

import java.util.Objects;
import java.util.Optional;

public record InventoryRestockRequest(

        Integer productId,
        String productName,
        Integer currentStock,
        Integer minimumRequiredStock,
        Boolean criticalItem
) {
    public InventoryRestockRequest {

        Optional.ofNullable(productId)
                .filter(id -> id <= 0)
                .orElseThrow(() -> new ValidationException("Invalid productId: Please provide valid productId"));

        Optional.ofNullable(productName)
                .filter(name -> !name.isBlank())
                .orElseThrow(() -> new ValidationException("Invalid productName: Please provide valid productName"));

        Optional.ofNullable(currentStock)
                .filter(stock -> stock < 0)
                .orElseThrow(() -> new ValidationException("Invalid currentStock: Please provide valid currentStock"));

        Optional.ofNullable(minimumRequiredStock)
                .filter(stock -> stock < 0)
                .orElseThrow(() -> new ValidationException("Invalid minimumRequiredStock: Please provide valid minimumRequiredStock"));

        Objects.requireNonNull(criticalItem, "Invalid criticalItem: Please provide valid criticalItem");
    }
}
