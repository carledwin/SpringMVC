package com.wordpress.carledwinj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wordpress.carledwinj.service.RestauranteService;

@Controller
@SessionAttributes
@RequestMapping("")
public class RestauranteController {

	private static final Long FIRST_RESTAURANT = 4L;
	private static final Long SECOND_RESTAURANT = 1L;
	
	@Autowired
	private RestauranteService restauranteService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String favoriteRestaurant(Model model) {
		restauranteService.insertAllRestaurant();
		model = restauranteService.favoriteRestaurant(model, FIRST_RESTAURANT, SECOND_RESTAURANT);
		return "qualRestaurantePreferido";
	}

	@RequestMapping(value="/consultaRanking",method = RequestMethod.GET)
	public String consultRanking(Model model) {
		model = restauranteService.consultRanking(model);
		return "ranking";
	}
}
