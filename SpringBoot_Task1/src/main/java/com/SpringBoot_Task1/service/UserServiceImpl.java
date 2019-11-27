package com.SpringBoot_Task1.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringBoot_Task1.appexception.UserNotFoundException;
import com.SpringBoot_Task1.dao.UserRepository;
import com.SpringBoot_Task1.model.User;

import javassist.NotFoundException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	 private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public User createUser(User user) throws NotFoundException {
		
		if(user==null)
			throw new NotFoundException("User object not found");
		else
		return this.userRepository.save(user);
	}

	@Override
	public Optional<User> readUserById(int userId) {
		 Optional<User> optionaluser = userRepository.findByUserId(userId);
		 
		    if (!optionaluser.isPresent()){
		    	LOGGER.error("User id not found");
		      throw new UserNotFoundException( userId + " user id not found ");
		    }
		    else
		return userRepository.findByUserId(userId);
		    
	}

	@Override
	public List<User> readUsers() {
		return this.userRepository.findAll();
	}


	@Override
	public User readUserByIdandPassword(int userId, String password) {
		
		Optional<User> optionaluser = userRepository.findByUserId(userId);
		 
	    if (!optionaluser.isPresent())
	      throw new UserNotFoundException( userId + " user id not found ");
	    else
		return this.userRepository.findByUserIdAndPassword(userId, password);
	}

	@Override
	public User updateUser(User user) throws NotFoundException {
		if(user==null)
			throw new NotFoundException("User object not found");
		else
		return this.userRepository.save(user);
	}

	@Transactional
	@Override
	public Optional<User> deleteUser(int userId) {
	
		 Optional<User> optionaluser = userRepository.findByUserId(userId);
		 
	    if (!optionaluser.isPresent())
	      throw new UserNotFoundException( userId + " user id not found ");
	    else
	      
	    	return userRepository.deleteByUserId(userId);

	}

	
}
