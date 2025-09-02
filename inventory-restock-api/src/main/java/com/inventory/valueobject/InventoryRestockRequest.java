package com.inventory.valueobject;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record InventoryRestockRequest(

        @NotNull(message = "Invalid productId: Please provide valid product Id")
        @Positive(message = "Invalid productId: Product ID must be greater than 0")
        Integer productId,

        @NotBlank(message = "Invalid productName: Product name cannot be blank")
        String productName,

        @NotNull(message = "Invalid currentStock: Please provide current stock value")
        @Min(value = 0, message = "Invalid currentStock: Stock cannot be negative")
        Integer currentStock,

        @Min(value = 1, message = "Invalid minimumRequiredStock: Must be at least 1")
        Integer minimumRequiredStock,

        @NotNull(message = "Invalid criticalItem: Please specify true/false")
        Boolean criticalItem
) {
}
