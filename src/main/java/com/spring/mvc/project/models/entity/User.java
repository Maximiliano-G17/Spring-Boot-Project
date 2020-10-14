package com.spring.mvc.project.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z ]{2,20}")
	private String name;
	
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z ]{2,20}")
	private String surname;	
	
	@NotEmpty
	@Pattern(regexp = "[0-9]{8}")
	private String dni;
	
	@Column(name = "rolID")
	private String position;
		
	public User(String name, String surname, String dni, String position) {
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.position = position;
	}
	
	public User() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", dni=" + dni + ", position=" + position
				+ "]";
	}
}