package com.wordpress.carledwinj.service;

import java.util.List;

import org.springframework.ui.Model;

import com.wordpress.carledwinj.model.Restaurante;

public interface RestauranteService {
	Model favoriteRestaurant(Model model, Long first, Long second);
	Model consultRanking(Model model);
	String insertAllRestaurant(Model model);
	void insertAllRestaurant();
	Restaurante findById(Long id);
	List<Restaurante> ordenarDesc(Iterable<Restaurante> allRestaurants);
}
