package com.dev.api.controllers;

import java.util.List;

import com.dev.api.dtos.UserDTO;
import com.dev.api.models.User;
import com.dev.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = this.userService.getUsers();

        return new ResponseEntity<>(users,HttpStatus.OK);
    }   

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody UserDTO userData) {
        User user = this.userService.createUser(userData);

        return user == null ? 
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
            :
                new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userData, @PathVariable("id") Long id) {
        User user = this.userService.updateUser(userData, id);

        return user == null ? 
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
            :
                new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        this.userService.deleteUser(id);

        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
