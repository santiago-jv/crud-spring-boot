package com.dev.api.repositories;

import com.dev.api.models.Library;

import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library,Long> {
    
}
