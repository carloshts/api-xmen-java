package com.xmen.api.repository.user;

import com.xmen.api.entity.user.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    
}
