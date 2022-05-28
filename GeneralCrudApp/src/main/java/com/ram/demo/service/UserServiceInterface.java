package com.ram.demo.service;

import java.util.List;

import com.ram.demo.user.User;

public interface UserServiceInterface {
	
	public User saveUser(User user);
	
	public List<User> getUsersList();
	
	public User getUserById(Long userId);
	
	public String deleteUserById(Long userId);
	
	public User updateUserById(User user, Long userId);
}
