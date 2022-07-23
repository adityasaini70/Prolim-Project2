package com.simplilearn.project.service;

import java.util.List;

import com.simplilearn.project.model.Admin;

public interface AdminService {
	public Admin save(Admin theAdmin);

	public Admin findByUsernameAndPassword(String theUsername, String thePassword);

	public List<Admin> findAll();
}
