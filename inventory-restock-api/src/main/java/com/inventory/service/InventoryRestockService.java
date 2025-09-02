package com.inventory.service;

import com.inventory.valueobject.InventoryRestockProductsRequest;
import com.inventory.valueobject.InventoryRestockResponse;

import java.util.List;

public interface InventoryRestockService {

    List<InventoryRestockResponse> calculateRestock(InventoryRestockProductsRequest productsRequest);
}
