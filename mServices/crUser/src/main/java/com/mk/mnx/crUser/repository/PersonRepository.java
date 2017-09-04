package com.mk.mnx.crUser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mk.mnx.model.domain.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

    //Supports native JSON query string
    @Query("{login.username :'?0'}")
    Person findPersonByUserName(String userName);

}