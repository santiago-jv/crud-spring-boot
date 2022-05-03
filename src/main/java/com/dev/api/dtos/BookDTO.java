package com.dev.api.dtos;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class BookDTO {
    @NotEmpty(message = "name is required")
    private String name;
    
    @NotEmpty(message = "description is required")
    private String description;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
}
