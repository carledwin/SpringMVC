package com.wordpress.carledwinj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String email;
	private Long restaurantePreferido;
	private Long outroRestaurante;
	
	private boolean votou;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVotou() {
		return votou;
	}

	public void setVotou(boolean votou) {
		this.votou = votou;
	}

	public Long getRestaurantePreferido() {
		return restaurantePreferido;
	}

	public void setRestaurantePreferido(Long restaurantePreferido) {
		this.restaurantePreferido = restaurantePreferido;
	}

	public Long getOutroRestaurante() {
		return outroRestaurante;
	}

	public void setOutroRestaurante(Long outroRestaurante) {
		this.outroRestaurante = outroRestaurante;
	}
}
