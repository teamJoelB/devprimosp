package fr.joel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.joel.entities.Address;
import fr.joel.repository.AddressRepository;

@RestController @CrossOrigin("*")
public class AddressRest {
	@Autowired
	private AddressRepository addressRepos;
	
	@PostMapping("adresse")
	public Address saveAdresse(@RequestBody Address a) {
		return addressRepos.save(a); 
	}
}
