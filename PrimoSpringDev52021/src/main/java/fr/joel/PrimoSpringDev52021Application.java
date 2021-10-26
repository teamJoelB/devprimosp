package fr.joel;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.joel.entities.Address;
import fr.joel.entities.User;
import fr.joel.repository.AddressRepository;
import fr.joel.repository.UserRepository;

@SpringBootApplication
public class PrimoSpringDev52021Application implements CommandLineRunner {
	@Autowired
	private UserRepository userRepos;
	@Autowired
	private AddressRepository addressRepos;
	

	public static void main(String[] args) {
		SpringApplication.run(PrimoSpringDev52021Application.class, args);
		System.out.println("lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {

		Address a1 = new Address(null, "321 avenue roger salengro", "92370", "Chaville");
		Address a2 = new Address(null, "36 avenue pièrre brossolette", "92240", "Malakoff");
		Address a3 = new Address(null, "16 rue des champs" , "75008", "Paris");
		Address a4 = new Address(null, "3 sentier des rois", "75016", "Paris");
		
		Stream.of(a1, a2, a3, a4).forEach(a -> {
			addressRepos.save(a);
		});	
		
		User u1 = new User(null, "CORNET", "Arthur", 14, "azerty", "rose", a1);
		User u2 = new User(null, "MSAIDIE", "Zaher", 15, "exploit", "nom", a3);
		User u3 = new User(null, "TRIY", "Hoi", 25, "hi", "hi", a3);
		User u4 = new User(null, "MOTI", "Poi", 15, "poi", "poi", a4);
		userRepos.save(u1);
		userRepos.save(u2);
		userRepos.save(u3);
		userRepos.save(u4);
			
		/*
		 * userRepos.findAll().forEach(u -> { System.out.println(u.toString()); });
		 * Optional<User> uP = userRepos.findByLoginAndMdp("azerty", "rose");
		 * if(uP.isPresent()) { System.out.println("connexion ok");
		 * System.out.println(uP.get().toString()); } else {
		 * System.out.println("user not found"); }
		 */

	}

}
