package com.playerauction.registeration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.playerauction.registeration.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,String>{
public Optional<User> findByUserNameAndPassword(String userName,String password);
	
public User findByUserName(String userName);
}