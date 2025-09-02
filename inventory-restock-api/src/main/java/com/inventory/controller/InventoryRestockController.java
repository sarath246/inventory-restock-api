package com.inventory.controller;

import com.inventory.service.InventoryRestockService;
import com.inventory.valueobject.InventoryRestockProductsRequest;
import com.inventory.valueobject.InventoryRestockResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/inventory/")
@RequiredArgsConstructor
public class InventoryRestockController {

    private final InventoryRestockService restockService;

    @PostMapping(value = "restock")
    public ResponseEntity<List<InventoryRestockResponse>> calculateRestock(@RequestBody InventoryRestockProductsRequest productsRequest) {

        List<InventoryRestockResponse> restockResponse = restockService.calculateRestock(productsRequest);

        return ResponseEntity.status(HttpStatus.OK).body(restockResponse);
    }

}
