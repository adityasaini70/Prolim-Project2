package com.simplilearn.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.project.model.User;
import com.simplilearn.project.repository.UserRepository;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User findById(long theId) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(theId);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	@Override
	public User findByName(String theName) {
		// TODO Auto-generated method stub
		return this.userRepository.findByName(theName);
	}

	@Override
	public User findBySize(double theSize) {
		// TODO Auto-generated method stub
		return this.userRepository.findBySize(theSize);
	}

	@Override
	public User findByMobile(String theMobile) {
		// TODO Auto-generated method stub
		return this.userRepository.findByMobile(theMobile);
	}

	@Override
	public User findByEmail(String theEmail) {
		// TODO Auto-generated method stub
		return this.userRepository.findByEmail(theEmail);
	}

}
