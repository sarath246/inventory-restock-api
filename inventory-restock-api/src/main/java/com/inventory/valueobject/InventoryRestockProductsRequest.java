package com.inventory.valueobject;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record InventoryRestockProductsRequest(

        @NotNull(message = "Invalid products: Products list cannot be null")
        @NotEmpty(message = "Products list cannot be empty")
        List<InventoryRestockRequest> products
) {
}
