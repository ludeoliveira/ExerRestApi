package com.exerapirest.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cachorro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 50, nullable = false)
	private String raca;
	@Column(length = 50)
	private String grupo;
	@Column(length = 20)
	private String altura;
	@Column(length = 50, nullable = false, unique = true)
	private String emailtutor;
	
	
	
	public Cachorro() {
	}
	
	public Cachorro(String raca, String grupo, String altura, String emailtutor) {
		this.raca = raca;
		this.grupo = grupo;
		this.altura = altura;
		this.emailtutor = emailtutor;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getEmailtutor() {
		return emailtutor;
	}
	public void setEmailtutor(String emailtutor) {
		this.emailtutor = emailtutor;
	}
	
}
