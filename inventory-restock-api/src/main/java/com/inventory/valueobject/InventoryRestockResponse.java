package com.inventory.valueobject;

import lombok.Data;

@Data
public class InventoryRestockResponse {

    private Integer productId;

    private String productName;

    private Integer restockQuantity;

    private String priorityLevel;
}
