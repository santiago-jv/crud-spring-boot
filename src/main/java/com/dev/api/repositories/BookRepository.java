package com.dev.api.repositories;

import com.dev.api.models.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository  extends CrudRepository<Book,Long>{
    
}
