package com.example.ecommerce.Controller;

import com.example.ecommerce.ApiResponse.ApiResponse;
import com.example.ecommerce.Model.Product;
import com.example.ecommerce.Model.User;
import com.example.ecommerce.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers(){
        if (userService.getAllUsers().isEmpty())
        {
            return ResponseEntity.status(400).body(new ApiResponse("List is empty"));
        }
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){

        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added successfully"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateUser(@PathVariable int index, @RequestBody @Valid User user,Errors errors) {
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
        }

        if(userService.updateUser(index,user)){
            return ResponseEntity.status(200).body(new ApiResponse("User updated successfully"));

        }
        return ResponseEntity.status(403).body(new ApiResponse("User not found"));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteUser(@PathVariable int index){
        if (userService.deleteUser(index))
        {
            return ResponseEntity.status(200).body(new ApiResponse("User delete successfully"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("User not found"));
    }


}
