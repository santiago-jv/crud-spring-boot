package com.dev.api.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDTO {
    @NotEmpty(message = "name is required")
    private String name;
    @NotEmpty(message = "name is required")
    @Email(message = "email must be a valid email address")
    private String email;
    
    @NotEmpty(message = "password is required")
    @Size(min = 8,max=100 ,message = "The length of password must be between 8 and 100 characters.")
    private String password;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
