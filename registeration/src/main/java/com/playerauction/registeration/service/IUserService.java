package com.playerauction.registeration.service;

import com.playerauction.registeration.entity.User;

public interface IUserService {
public User userRegisteration(User user);
public User login(String userName,String password);
public User validate(String userName);
}
