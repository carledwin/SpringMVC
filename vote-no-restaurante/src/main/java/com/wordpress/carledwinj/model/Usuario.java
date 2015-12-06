package com.wordpress.carledwinj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	private String nome;
	
	private String email;
	
	@NotNull
	private Long restaurantePreferido;
	
	private boolean votou;
	
	private Long pontos;
	
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

	public Long getPontos() {
		return pontos;
	}

	public void setPontos(Long pontos) {
		this.pontos = pontos;
	}

	public Long getRestaurantePreferido() {
		return restaurantePreferido;
	}

	public void setRestaurantePreferido(Long restaurantePreferido) {
		this.restaurantePreferido = restaurantePreferido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pontos == null) ? 0 : pontos.hashCode());
		result = prime * result + ((restaurantePreferido == null) ? 0 : restaurantePreferido.hashCode());
		result = prime * result + (votou ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pontos == null) {
			if (other.pontos != null)
				return false;
		} else if (!pontos.equals(other.pontos))
			return false;
		if (restaurantePreferido == null) {
			if (other.restaurantePreferido != null)
				return false;
		} else if (!restaurantePreferido.equals(other.restaurantePreferido))
			return false;
		if (votou != other.votou)
			return false;
		return true;
	}


}
