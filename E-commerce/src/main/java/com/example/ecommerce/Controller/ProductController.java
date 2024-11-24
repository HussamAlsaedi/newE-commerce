package com.example.ecommerce.Controller;

import com.example.ecommerce.ApiResponse.ApiResponse;
import com.example.ecommerce.Model.Product;
import com.example.ecommerce.Service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping ("/get")
    public ResponseEntity getAllProducts(){
        if (productService.getAllProducts().isEmpty())
        {
            return ResponseEntity.status(400).body(new ApiResponse("List is empty"));
        }
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/add")
     public ResponseEntity add_Product(@RequestBody @Valid Product  product, Errors errors){

        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body(new ApiResponse("Product added successfully"));
     }


     @PutMapping("/update/{index}")
     public ResponseEntity updateProduct(@PathVariable int index, @RequestBody @Valid Product product,Errors errors)
     {
         if (errors.hasErrors()){
             return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
         }

         if(productService.updateProduct(index,product)){
             return ResponseEntity.status(200).body(new ApiResponse("Product updated successfully"));

         }
         return ResponseEntity.status(403).body(new ApiResponse("Product not found"));
     }

     @DeleteMapping("/delete/{index}")
     public ResponseEntity deleteProduct(@PathVariable int index){
        if (productService.deleteProduct(index))
        {
          return ResponseEntity.status(200).body(new ApiResponse("Product delete successfully"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Product not found"));
     }


}
