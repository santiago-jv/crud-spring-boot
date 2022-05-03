package com.dev.api.dtos;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data 
public class LibraryDTO {
    @NotEmpty(message = "name is required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
