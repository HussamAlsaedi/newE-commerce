package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getAllProducts(){
        return products;
    }

    public void addProduct(Product product)
    {
        products.add(product);
    }

     public  boolean updateProduct(int index, Product product){
         for (int i = 0; i <products.size() ; i++) {
             if (products.get(i).getId() == index){
                 products.set(i,product);
                 return true;
             }
         }
         return false;
     }

     public boolean deleteProduct(int index){
         for (int i = 0; i < products.size(); i++) {
             if (products.get(i).getId() == index){
                 products.remove(i);
                 return true;
             }
         }
         return false;
     }



}
