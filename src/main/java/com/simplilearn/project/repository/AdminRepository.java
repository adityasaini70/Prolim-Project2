package com.simplilearn.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.project.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>  {

	public Admin save(Admin theAdmin);
	
	public Admin findByUsernameAndPassword(String theUsername, String thePassword);
	
	public List<Admin> findAll();

}
