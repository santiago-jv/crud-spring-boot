package com.dev.api.services;

import java.util.List;

import com.dev.api.dtos.LibraryDTO;
import com.dev.api.models.Library;
import com.dev.api.repositories.LibraryRepository;
import com.dev.api.types.ServiceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public ServiceResponse saveLibrary(LibraryDTO libraryData) {
        try {
            Library library = new Library();
            library.setName(libraryData.getName());
            return new ServiceResponse(libraryRepository.save(library),null ,HttpStatus.CREATED );
        } catch (Exception exception) {
            return new ServiceResponse(null, exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public List<Library> findLibraries() {
    
        return (List<Library>) libraryRepository.findAll();
         
    }
}
