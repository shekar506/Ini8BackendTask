package com.backend.Ini8BackendTask.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.Ini8BackendTask.Exception.ResourceNotFoundException;
import com.backend.Ini8BackendTask.Model.Registration;
import com.backend.Ini8BackendTask.Repository.RegistrationRepository;
import com.backend.Ini8BackendTask.Service.RegistrationService;

@Service
public class RegisterServiceImpl implements RegistrationService{
	
	private RegistrationRepository registrationRepo;
	

	public RegisterServiceImpl(RegistrationRepository registrationRepo) {
		super();
		this.registrationRepo = registrationRepo;
	}

	//save user to database
	@Override
	public Registration saveUser(Registration registration) {
		return registrationRepo.save(registration);
	}


	// get list of user by get all users
	@Override
	public List<Registration> getAllUsers() {
		List<Registration> users= registrationRepo.findAll();
		return users;
		
	}


	// get user by id 
	@Override
	public Registration getUserById(int id) {
		
		Registration user=registrationRepo.findById(id).
		orElseThrow(()-> new ResourceNotFoundException("Registration", "id", id));
		return user;
	}


	// update user body by id 
	@Override
	public Registration updateUser(int id, Registration registration) {
		
		// check if user exist or not 
		Registration existingUser = registrationRepo.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Registration", "id",id));
		
		existingUser.setName(registration.getName());
		existingUser.setEmail(registration.getEmail());
		existingUser.setDateOfBirth(registration.getDateOfBirth());
		existingUser.setLocation(registration.getLocation());
		
		// update user if exists
		registrationRepo.save(existingUser);
		
		return existingUser;
		

	}

	
	// delete user by id 
	
	@Override
	public void deleteUser(int id) {
		
		// check first user exist or not 
		Registration user=registrationRepo.findById(id).
		orElseThrow(()-> new ResourceNotFoundException("Registration", "id", id));
		
		//delete user if if exist
		registrationRepo.deleteById(id);
		
		
	}

}
