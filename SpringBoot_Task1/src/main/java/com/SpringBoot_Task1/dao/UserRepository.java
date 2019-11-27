package com.SpringBoot_Task1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.SpringBoot_Task1.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUserIdAndPassword(int userId,String password);
	
	public Optional<User> findByUserId(int userId);
	
	public List<User> findAll();
	
	public Optional<User> deleteByUserId(int userId);
}
