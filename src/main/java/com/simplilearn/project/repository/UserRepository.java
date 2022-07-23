package com.simplilearn.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
		
	public User findById(long theId);
	
	public User findByName(String theName);

	public User findBySize(double theSize);
	
	public User findByMobile(String theMobile);

	public User findByEmail(String theEmail);

	public List<User> findAll();

}
