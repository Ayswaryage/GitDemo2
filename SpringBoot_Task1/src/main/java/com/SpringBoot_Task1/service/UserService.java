package com.SpringBoot_Task1.service;

import java.util.List;
import java.util.Optional;

import com.SpringBoot_Task1.model.User;

import javassist.NotFoundException;

public interface UserService {
	
	public User createUser(User user) throws NotFoundException;
	public Optional<User> readUserById(int userId);
	public User readUserByIdandPassword(int userId,String password);
	public List<User> readUsers();
	public User updateUser(User user) throws NotFoundException;
	public Optional<User> deleteUser(int userId);

}
