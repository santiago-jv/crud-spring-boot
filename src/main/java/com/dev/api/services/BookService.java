package com.dev.api.services;

import java.util.Optional;

import com.dev.api.dtos.BookDTO;
import com.dev.api.models.Book;
import com.dev.api.models.Library;
import com.dev.api.repositories.BookRepository;
import com.dev.api.repositories.LibraryRepository;
import com.dev.api.types.ServiceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    public ServiceResponse saveBook(BookDTO bookData, Long libraryId) {
        try {
            Optional<Library> libraryContainer = libraryRepository.findById(libraryId);
            if(!libraryContainer.isPresent()){
                return new ServiceResponse(null, "librería no encontrada", HttpStatus.NOT_FOUND);
            }
            Book book = new Book();
            book.setName(bookData.getName());
            book.setDescription(bookData.getDescription());
            book.setLibrary(libraryContainer.get());
            return new ServiceResponse(bookRepository.save(book),null ,HttpStatus.CREATED );
        } catch (Exception exception) {
            return new ServiceResponse(null, exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
