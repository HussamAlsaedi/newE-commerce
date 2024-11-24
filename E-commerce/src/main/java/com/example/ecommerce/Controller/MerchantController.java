package com.example.ecommerce.Controller;

import com.example.ecommerce.ApiResponse.ApiResponse;
import com.example.ecommerce.Model.Merchant;
import com.example.ecommerce.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/merchant")
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getMerchants() {
        if (merchantService.getMerchants().isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("List of Merchant is Empty"));
        }
        return ResponseEntity.ok(merchantService.getMerchants());
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addMerchant(@RequestBody @Valid Merchant merchant, Errors errors) {
       if (errors.hasErrors()) {
           return ResponseEntity.status(400).body(new ApiResponse("Invalid Merchant"));
       }
            merchantService.addMerchants(merchant);
           return ResponseEntity.status(200).body(new ApiResponse("Merchant Added"));
       }

    }

