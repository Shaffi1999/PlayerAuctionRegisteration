package com.playerauction.registeration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playerauction.registeration.entity.User;
import com.playerauction.registeration.exception.UserNotFoundException;
import com.playerauction.registeration.repository.UserRepository;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public User userRegisteration(User user) {
		return userRepository.save(user);
	}

	@Override
	public User login(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password).orElseThrow(()-> new UserNotFoundException("User With User Name" + userName + "Not Found"));
	}

	@Override
	public User validate(String userName) {
		
		return userRepository.findByUserName(userName);
	}

	

}
