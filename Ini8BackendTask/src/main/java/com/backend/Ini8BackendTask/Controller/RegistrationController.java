package com.backend.Ini8BackendTask.Controller;

import java.util.List;

import javax.imageio.spi.RegisterableService;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.backend.Ini8BackendTask.Model.Registration;
import com.backend.Ini8BackendTask.Service.RegistrationService;

@RestController
@RequestMapping("/api/regist")
public class RegistrationController {
	
	private RegistrationService registrationService;

	public RegistrationController(RegistrationService registrationService) {
		super();
		this.registrationService = registrationService;
	}
	
	@PostMapping
	public ResponseEntity<Registration> save(@RequestBody Registration reg){
		System.out.println("in controller");
		return new ResponseEntity<Registration>(registrationService.saveUser(reg), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Registration> getAllUsers(){
		
		List<Registration> users = registrationService.getAllUsers();
		return users;
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Registration> getUserById(@PathVariable("id") int id) {
		
		return new ResponseEntity<Registration>(registrationService.getUserById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Registration> 
	updateUser(@PathVariable("id") int id,@RequestBody Registration register){
		
		return new ResponseEntity<Registration>(registrationService.updateUser(id, register), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
		
		registrationService.deleteUser(id);
		return new ResponseEntity<String>("succesfully deleted user with id "+id, HttpStatus.OK);
	}
	
	

}
