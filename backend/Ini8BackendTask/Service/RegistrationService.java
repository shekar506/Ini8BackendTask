package com.backend.Ini8BackendTask.Service;

import java.util.List;

import com.backend.Ini8BackendTask.Model.Registration;

public interface RegistrationService {
	
	Registration saveUser(Registration registration);
	List<Registration> getAllUsers();
	Registration getUserById(int id);
	Registration updateUser(int id,Registration registration);
	void deleteUser(int id);

}
