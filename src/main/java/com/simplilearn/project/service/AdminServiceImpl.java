package com.simplilearn.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.project.errors.AdminNotFoundException;
import com.simplilearn.project.model.Admin;
import com.simplilearn.project.repository.AdminRepository;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public AdminServiceImpl() {
		super();
	}

	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public Admin save(Admin theAdmin) {
		// TODO Auto-generated method stub
		return this.adminRepository.save(theAdmin);
	}

	@Override
	public Admin findByUsernameAndPassword(String theUsername, String thePassword) {
		// TODO Auto-generated method stub

		Admin savedAdmin = this.adminRepository.findByUsernameAndPassword(theUsername, thePassword);

		if (savedAdmin == null) {
			throw new AdminNotFoundException(
					"Admin with username - " + theUsername + " and password - " + thePassword + " not found!");
		}
		return savedAdmin;
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return this.adminRepository.findAll();
	}

}
