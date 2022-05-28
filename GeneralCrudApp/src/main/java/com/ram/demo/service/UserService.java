package com.ram.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.demo.repository.UserRepositoryInterface;
import com.ram.demo.user.User;

@Service
public class UserService implements UserServiceInterface{
	
	@Autowired
	private UserRepositoryInterface repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	@Override
	public List<User> getUsersList() {
		return repo.findAll();
	}

	public User getUserById(Long userId) {
		return repo.findById(userId).get();
	}

	public String deleteUserById(Long userId) {
		repo.deleteById(userId);
		return "user Id " +userId+ " deleted successfully..!";
	}

	public User updateUserById(User user, Long userId) {
		User obtainedUser = repo.findById(userId).get();
		if(Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) {
			obtainedUser.setUserName(user.getUserName());
		}
		if(Objects.nonNull(user.getUserLocation()) && !"".equalsIgnoreCase(user.getUserLocation())) {
			obtainedUser.setUserLocation(user.getUserLocation());
		}
		return repo.save(obtainedUser);
	}
	
	
}
