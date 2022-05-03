package com.dev.api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.dev.api.dtos.BookDTO;
import com.dev.api.dtos.LibraryDTO;
import com.dev.api.models.Book;
import com.dev.api.models.Library;
import com.dev.api.services.BookService;
import com.dev.api.services.LibraryService;
import com.dev.api.types.ServiceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookService;
 
    @PostMapping("library/{libraryId}")
    public ResponseEntity<Book> createBook(@Valid @RequestBody BookDTO bookData, @PathVariable() Long libraryId) {
        ServiceResponse response = bookService.saveBook(bookData,libraryId);
        HttpStatus statusCode = response.getStatusCode();
        
        if(!response.hasError()){
            return new ResponseEntity<>((Book) response.getValue(), statusCode);
        } 
        return new ResponseEntity<>(null, statusCode);
    }
}
