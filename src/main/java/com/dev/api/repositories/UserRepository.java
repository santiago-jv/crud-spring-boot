package com.dev.api.repositories;

import com.dev.api.models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    
}