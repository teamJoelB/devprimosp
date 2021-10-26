package fr.joel.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.joel.entities.User;
import fr.joel.repository.UserRepository;

@RestController @CrossOrigin("*")
public class UserRest {
	
	@Autowired
	private UserRepository userRepos;
	
	@GetMapping("user")
	public Iterable<User> getAllUser(){
		return userRepos.findAll();
	}
	
	@GetMapping("user/{ville}")
	public List<User> getuserbyVille(@PathVariable String ville){
		return userRepos.findByAdresseVille(ville);
	}
	
	@PostMapping("user")
	public User saveUser(@RequestBody User u) {
		return userRepos.save(u);
	}
	
	@PutMapping("user/{id}")
	public User modifUser(@PathVariable Long id, @RequestBody User u) {
		u.setId(id);
		return userRepos.save(u);
	}
	
	@DeleteMapping("user/{id}")
	public boolean supUser(@PathVariable Long id) {
		if(userRepos.findById(id).isPresent()) {
			userRepos.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
}
