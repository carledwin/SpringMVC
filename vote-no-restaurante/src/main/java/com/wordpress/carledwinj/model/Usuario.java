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
	private Long preferidoScore;
	private Long outroRestaurante;
	private Long outroScore;
	
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

	public Long getPreferidoScore() {
		return preferidoScore;
	}

	public void setPreferidoScore(Long preferidoScore) {
		this.preferidoScore = preferidoScore;
	}

	public Long getOutroScore() {
		return outroScore;
	}

	public void setOutroScore(Long outroScore) {
		this.outroScore = outroScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((outroRestaurante == null) ? 0 : outroRestaurante.hashCode());
		result = prime * result + ((outroScore == null) ? 0 : outroScore.hashCode());
		result = prime * result + ((preferidoScore == null) ? 0 : preferidoScore.hashCode());
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
		if (outroRestaurante == null) {
			if (other.outroRestaurante != null)
				return false;
		} else if (!outroRestaurante.equals(other.outroRestaurante))
			return false;
		if (outroScore == null) {
			if (other.outroScore != null)
				return false;
		} else if (!outroScore.equals(other.outroScore))
			return false;
		if (preferidoScore == null) {
			if (other.preferidoScore != null)
				return false;
		} else if (!preferidoScore.equals(other.preferidoScore))
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
