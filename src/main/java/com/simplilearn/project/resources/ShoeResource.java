package com.simplilearn.project.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.project.errors.ShoeNotFoundException;
import com.simplilearn.project.model.Shoe;
import com.simplilearn.project.service.AdminService;
import com.simplilearn.project.service.ShoeService;

@RestController
public class ShoeResource {
	@Autowired
	private ShoeService shoeService;

	@Autowired
	private AdminService adminService;

	@GetMapping(path = "/sportyshoes/{username}/{password}/shoetbl")
	public List<Shoe> listAllShoes(@PathVariable String username, @PathVariable String password) {

		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		return this.shoeService.findAll();
	}

	@GetMapping(path = "/sportyshoes/{username}/{password}/shoetbl/id/{id}")
	public Shoe findShoeByID(@PathVariable String username, @PathVariable String password, @PathVariable long id) {
		
		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		Shoe theShoe = this.shoeService.findById(id);

		if (theShoe == null) {
			throw new ShoeNotFoundException("Shoe with id - " + id + " not found!");
		}

		return theShoe;
	}

	@GetMapping(path = "/sportyshoes/{username}/{password}/shoetbl/color/{theColor}")
	public List<Shoe> findShoeByColor(@PathVariable String username, @PathVariable String password,
			@PathVariable String theColor) {
		
		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		List<Shoe> theShoeList = this.shoeService.findByColor(theColor);

		if (theShoeList.size() == 0) {
			throw new ShoeNotFoundException("Shoe with color - " + theColor + " not found!");
		}

		return theShoeList;
	}

	@GetMapping(path = "/sportyshoes/{username}/{password}/shoetbl/category/{theCategory}")
	public List<Shoe> findShoeByCategory(@PathVariable String username, @PathVariable String password,
			@PathVariable String theCategory) {
		
		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		List<Shoe> theShoeList = this.shoeService.findByCategory(theCategory);

		if (theShoeList.size() == 0) {
			throw new ShoeNotFoundException("Shoe with category - " + theCategory + " not found!");
		}

		return theShoeList;
	}

	@GetMapping(path = "/sportyshoes/{username}/{password}/shoetbl/price/{thePrice}")
	public List<Shoe> findShoeByPrice(@PathVariable String username, @PathVariable String password,
			@PathVariable Double thePrice) {
		
		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);


		List<Shoe> theShoeList = this.shoeService.findByPrice(thePrice);

		if (theShoeList.size() == 0) {
			throw new ShoeNotFoundException("Shoe with price - " + thePrice + " not found!");
		}

		return theShoeList;
	}

	@PostMapping(path = "/sportyshoes/{username}/{password}/shoetbl")
	public ResponseEntity<?> createShoe(@PathVariable String username, @PathVariable String password,
			@Valid @RequestBody Shoe theShoe) {
		
		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		Shoe savedShoe = this.shoeService.save(theShoe);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedShoe.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(path = "/sportyshoes/{username}/{password}/shoetbl/id/{id}")
	public ResponseEntity<Shoe> updateShoe(@PathVariable String username, @PathVariable String password,
			@PathVariable long id, @RequestBody Shoe theShoe) {
		
		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		this.shoeService.save(theShoe);

		return new ResponseEntity<Shoe>(theShoe, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(path = "/sportyshoes/{username}/{password}/shoetbl/id/{id}")
	public ResponseEntity<Shoe> deleteShoe(@PathVariable String username, @PathVariable String password,
			@PathVariable long id) {
		
		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		Shoe deletedShoe = this.shoeService.deleteById(id);

		return new ResponseEntity<Shoe>(deletedShoe, HttpStatus.NO_CONTENT);
	}

}
