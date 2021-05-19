package com.mysql.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.mysql.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
