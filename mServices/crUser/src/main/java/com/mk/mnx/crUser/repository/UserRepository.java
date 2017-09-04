package com.mk.mnx.crUser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mk.mnx.model.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
