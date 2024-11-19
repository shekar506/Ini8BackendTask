package com.backend.Ini8BackendTask.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Ini8BackendTask.Model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}
