package com.example.ecommerce.Service;

import com.example.ecommerce.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getAllUsers(){
        return users;
    }

    public void addUser(User user)
    {
        users.add(user);
    }

    public  boolean updateUser(int index, User user){
        for (int i = 0; i < users.size() ; i++) {
            if (users.get(i).getId() == index){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int index){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == index){
                users.remove(i);
                return true;
            }
        }
        return false;
    }


}
