package com.example.ecommerce.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Category {
    @NotNull(message = "id must be not empty.")
    @Min(value = 1, message = "Id Value must be greater than or equal to 1")
    @Positive(message = "Id must be Positive")
    private int id;

    @NotEmpty(message = "name must be not empty")
    @Size(min = 3, message = "name must not be empty, have to be more than 3 length long.")
    private String name;

}
