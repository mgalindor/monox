package com.mk.mnx.sstk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mk.mnx.model.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	 @Query("{userName:'?0'}")
	 User findUserByUserName(String userName);

}
