package com.example.financial_backend.service;

import com.example.financial_backend.model.User;
import com.example.financial_backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(long id,User updatedUser) {
        User user = userRepo.findById(id).orElse(null);
        if(user != null) {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setRole(updatedUser.getRole());
            user.setStatus(updatedUser.getStatus());
            return userRepo.save(user);
        }
        throw new RuntimeException("User not found");
    }

    public void deleteUserById(long id) {
        userRepo.deleteById(id);
    }
}
