package fr.joel.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Address {
	@Id @GeneratedValue
	private Long id;
	private String rue;
	private String codePostal;
	private String ville;
	
}
