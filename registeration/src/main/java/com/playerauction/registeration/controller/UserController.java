package com.playerauction.registeration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playerauction.registeration.entity.User;
import com.playerauction.registeration.exception.UserAlreadyExistException;
import com.playerauction.registeration.exception.UserNotFoundException;
import com.playerauction.registeration.service.IUserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	//private UserServiceImpl userService;
	private IUserService userService;
	
	@PostMapping("/register")
	public User userRegisteration(@RequestBody User user)
	{
		
		String userName = user.getUserName();
		if (userName != null && !"".equals(userName)) {
			User registerationObj = userService.validate(userName);
			if (registerationObj != null) {
				
				throw new UserAlreadyExistException("User With This User Name " + userName + "Is Already Exist:");
			}
		}
		return userService.userRegisteration(user);
	}
	
//	@GetMapping("/login/{userName}/{password}")
//	public User userLogin(@PathVariable("userName") String userName,@PathVariable("password") String password)
//	{
//		return userService.login(userName, password);
//	}
	
	
	@PostMapping("/login")
	public User authenticateLogin(@RequestBody User user) throws Exception {
		
		String userName=user.getUserName();
		String password = user.getPassword();
		User userObj = null;
		if (userName !=null && password != null) {
			userObj = userService.login(userName, password);
		}
		if (userObj == null) {
			
			throw new UserNotFoundException("Bad Credentials");
		}
		return userObj;
	}
	

}
