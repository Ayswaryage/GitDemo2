package com.SpringBoot_Task1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot_Task1.model.User;
import com.SpringBoot_Task1.service.UserService;

import javassist.NotFoundException;

@RestController

public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping(value="/create")
	public @ResponseBody User createOperation(@RequestBody @Valid User user) throws NotFoundException{
		return this.userService.createUser(user);
		
	}
	
	@GetMapping(value="/readByIdAndPass/{userId}/{password}")
	public User readByIdAndPasswordOperation(@PathVariable(name="userId") int userId,
			@PathVariable(name="password") String password){
				return this.userService.readUserByIdandPassword(userId, password);
		
	}
	
	@GetMapping(value="/readById/{userId}")
	public Optional<User> readByIdOperation(@PathVariable(name="userId") int userId){
		return this.userService.readUserById(userId);
	}
	
	@GetMapping(value="/readAll")
	public List<User> readUsersOperation(){
		return this.userService.readUsers();
	}
	
	@PutMapping(value="/update")
	public User updateOperation(@RequestBody User user) throws NotFoundException
	{
		return this.userService.updateUser(user);
	}
	
	@DeleteMapping(value="/delete/{userId}")
	public Optional<User> deleteOperation(@PathVariable(name="userId") int userId){
		return this.userService.deleteUser(userId);
	}
}
