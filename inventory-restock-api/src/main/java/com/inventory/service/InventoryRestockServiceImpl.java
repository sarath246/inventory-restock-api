package com.inventory.service;

import com.inventory.valueobject.InventoryRestockProductsRequest;
import com.inventory.valueobject.InventoryRestockRequest;
import com.inventory.valueobject.InventoryRestockResponse;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InventoryRestockServiceImpl implements InventoryRestockService {

    @Override
    public List<InventoryRestockResponse> calculateRestock(InventoryRestockProductsRequest productsRequest) {

        return Optional.ofNullable(productsRequest.products())
                .orElse(Collections.emptyList())
                .stream()
                .filter(this::needsRestock)
                .map(this::mapToResponse)
                .sorted(Comparator.comparing(InventoryRestockResponse::getPriorityLevel)
                        .thenComparing(r -> r.getProductName().toLowerCase()))
                .collect(Collectors.toList());
    }

    private boolean needsRestock(InventoryRestockRequest restockRequest) {
        return (restockRequest.currentStock() < restockRequest.minimumRequiredStock()) ||
                (Boolean.TRUE.equals(restockRequest.criticalItem()) && restockRequest.currentStock() < 2);
    }

    private InventoryRestockResponse mapToResponse(InventoryRestockRequest restockRequest) {
        var restockResponse = new InventoryRestockResponse();
        restockResponse.setProductId(restockRequest.productId());
        restockResponse.setProductName(restockRequest.productName());
        restockResponse.setRestockQuantity(restockRequest.minimumRequiredStock() - restockRequest.currentStock());
        restockResponse.setPriorityLevel(determinePriorityLevel(restockRequest));
        return restockResponse;
    }

    private String determinePriorityLevel(InventoryRestockRequest restockRequest) {

        double ratio = (double) restockRequest.currentStock() / restockRequest.minimumRequiredStock();

        if (Boolean.TRUE.equals(restockRequest.criticalItem()) || ratio < 0.5) {
            return "HIGH";
        } else if (ratio < 0.8) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }
}
