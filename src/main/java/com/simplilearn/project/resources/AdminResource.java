package com.simplilearn.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.project.model.Admin;
import com.simplilearn.project.service.AdminService;

@RestController
public class AdminResource {

	@Autowired
	private AdminService adminService;

	@GetMapping(path = "/sportyshoes/admintbl")
	public List<Admin> listAllAdmins() {
		return this.adminService.findAll();
	}

	@PutMapping(path = "/sportyshoes/admintbl/{username}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable String username, @RequestBody Admin theAdmin) {
		Admin savedAdmin = this.adminService.save(theAdmin);

		return new ResponseEntity<Admin>(theAdmin, HttpStatus.NO_CONTENT);
	}

}
