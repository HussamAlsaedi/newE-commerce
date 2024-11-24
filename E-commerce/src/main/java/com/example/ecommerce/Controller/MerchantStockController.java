package com.example.ecommerce.Controller;

import com.example.ecommerce.ApiResponse.ApiResponse;
import com.example.ecommerce.Model.MerchantStock;
import com.example.ecommerce.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/merchantStock")
public class MerchantStockController {
    private MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity getMerchantStock() {
        if (merchantStockService.getMerchantStocks().isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("List of Merchant Stocks is Empty"));
        }
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStocks());
    }

    @PostMapping("/add")
    public  ResponseEntity<ApiResponse> addMerchantStocks(@RequestBody @Valid MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getAllErrors().get(0).getDefaultMessage()));
        }
        merchantStockService.addMerchantStocks(merchantStock);
        return ResponseEntity.status(200).body(new ApiResponse("Merchant Stock Added"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateMerchantStocks(@PathVariable int index , @RequestBody @Valid MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getAllErrors().get(0).getDefaultMessage()));
        }
        if (merchantStockService.updateMerchantStocks(index, merchantStock)) {
            return ResponseEntity.status(200).body(new ApiResponse("Merchant Stock Updated"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Merchant Stock Not Updated"));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteMerchantStocks(@PathVariable int index) {
        if (merchantStockService.deleteMerchantStocks(index)) {
            return ResponseEntity.status(200).body(new ApiResponse("Merchant Stock Deleted"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Merchant Stock Not Found"));
    }
}
