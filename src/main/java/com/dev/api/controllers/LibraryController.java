package com.dev.api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.dev.api.dtos.LibraryDTO;
import com.dev.api.models.Library;
import com.dev.api.services.LibraryService;
import com.dev.api.types.ServiceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("libraries")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;
    @GetMapping()
    public ResponseEntity<List<Library>> getLibraries() {
        return new ResponseEntity<>(libraryService.findLibraries(),  HttpStatus.OK );
    }
    @PostMapping()
    public ResponseEntity<Library> createLibrary(@Valid @RequestBody LibraryDTO libraryData) {
        ServiceResponse response = libraryService.saveLibrary(libraryData);
        HttpStatus statusCode = response.getStatusCode();
        
        if(!response.hasError()){
            return new ResponseEntity<>((Library) response.getValue(), statusCode);
        } 
        return new ResponseEntity<>(null, statusCode);
    }
}
