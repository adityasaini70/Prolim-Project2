package com.simplilearn.project.service;

import java.util.List;

import com.simplilearn.project.model.User;

public interface UserService {
	
	public User findById(long theId);
	
	public User findByName(String theName);

	public User findBySize(double theSize);
	
	public User findByMobile(String theMobile);

	public User findByEmail(String theEmail);

	public List<User> findAll();

}
