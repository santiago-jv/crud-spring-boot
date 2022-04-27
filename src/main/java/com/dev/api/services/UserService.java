package com.dev.api.services;

import java.util.List;
import java.util.Optional;

import com.dev.api.dtos.UserDTO;
import com.dev.api.models.User;
import com.dev.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired()
    private UserRepository userRepository;
    
    public List<User> getUsers() {
        List<User> users = (List<User>) this.userRepository.findAll();
        return users;
    }
    public User createUser(UserDTO userData) {
        try {
            User user = new User();
            user.setName(userData.getName());
            user.setEmail( userData.getEmail());
            user.setPassword(userData.getPassword());
            return this.userRepository.save(user);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return null;
        }
    }
    public User updateUser(UserDTO userData, Long id) {
        
        Optional<User> userContainer = this.userRepository.findById(id);
        
        if(userContainer.isPresent()) {
            try {
                User currentUser = userContainer.get();
                if(userData.getName() != null) currentUser.setName(userData.getName());
                if(userData.getEmail() != null) currentUser.setEmail(userData.getEmail());
                if(userData.getPassword() != null) currentUser.setPassword(userData.getPassword());

                this.userRepository.save(currentUser);
                return currentUser;
            } catch (Exception error) {
                System.out.println(error.getMessage());
                return null;
            }
        }
        return null;
      
    }
    public void deleteUser(Long id) {
        try {
           
             this.userRepository.deleteById(id);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            
        }
    }
}
