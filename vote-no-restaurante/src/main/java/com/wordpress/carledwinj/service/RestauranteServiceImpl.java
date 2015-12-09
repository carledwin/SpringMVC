package com.wordpress.carledwinj.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.wordpress.carledwinj.model.Restaurante;
import com.wordpress.carledwinj.repository.RestauranteRepository;
import com.wordpress.carledwinj.utils.ConvertIterableToList;
import com.wordpress.carledwinj.utils.OrdenaDescRestaurante;

@Service
public class RestauranteServiceImpl implements RestauranteService{

	private static final String ATT_SECOND_RESTAURANT = "secondRestaurant";
	private static final String ATT_FIRST_RESTAURANT = "firstRestaurant";
	private static final String ATT_ALL_RESTAURANTS = "todosRestaurantes";
	private static final String TITLE_PAGE_RANKING = "Ranking";
	private static final String ATT_TITLE_RANKING = "titulo";
	private static final boolean FALSE = false;
	private static final Long ZEROL = 0L;
	private static final String KFC = "KFC";
	private static final String KFC_LOGO = "kf.png";
	private static final String PIZZA_HUT = "Pizza Hut";
	private static final String PIZZA_HUT_LOGO = "ph.png";
	private static final String SUBWAY = "Subway";
	private static final String SUBWAY_LOGO = "sb.png";
	private static final String STARBUCKS = "Starbucks";
	private static final String STARBUCKS_LOGO = "st.jpg";
	private static final String MC_DONALD_S = "McDonald's";
	private static final String MC_DONALD_S_LOGO = "mc.png";
	private static final long FIRST_RESTAURANT = 1L;
	private static final long SECOND_RESTAURANT = 2L;
	private static final long THIRD_RESTAURANT = 3L;
	private static final long FOURTH_RESTAURANT = 4L;
	private static final long FIFTH_RESTAURANT = 5L;
	
	@Autowired
	private RestauranteRepository restauranteRepository;

	@Override
	public Model favoriteRestaurant(Model model, Long first, Long second) {
		Restaurante firstRestaurant = restauranteRepository.findOne(first);
		Restaurante secondRestaurant  = restauranteRepository.findOne(second);
		model.addAttribute(ATT_FIRST_RESTAURANT, firstRestaurant);
		model.addAttribute(ATT_SECOND_RESTAURANT, secondRestaurant);
		return model;
	}

	@Override
	public Model consultRanking(Model model) {
		Iterable<Restaurante> allRestaurants = restauranteRepository.findAll();
		List<Restaurante> all = ordenarDesc(allRestaurants);
		model.addAttribute(ATT_TITLE_RANKING,TITLE_PAGE_RANKING);
		model.addAttribute(ATT_ALL_RESTAURANTS, all);
		return model;
	}
	
	@Override
	public String insertAllRestaurant(Model model) {
		initializeAllRestaurants();
		Iterable<Restaurante> allRestaurants = restauranteRepository.findAll();
		List<Restaurante> all = ordenarDesc(allRestaurants);
		
		model.addAttribute(ATT_ALL_RESTAURANTS, all);
		model.addAttribute(ATT_TITLE_RANKING,TITLE_PAGE_RANKING);
		return "ranking";
	}
		
	@Override
	public void insertAllRestaurant() {
		initializeAllRestaurants();
	}

	@Override
	public Restaurante findById(Long id) {
		return  restauranteRepository.findOne(id);
	}
	
	@Override
	public List<Restaurante> ordenarDesc(Iterable<Restaurante> allRestaurants) {
		List<Restaurante> all = ConvertIterableToList.toList(allRestaurants);
		Collections.sort(all, new OrdenaDescRestaurante());
		return all;
	}

	private void initializeAllRestaurants() {
		if(!restauranteRepository.exists(FIRST_RESTAURANT))
			restauranteRepository.save(new Restaurante(FIRST_RESTAURANT, MC_DONALD_S, ZEROL, MC_DONALD_S_LOGO, FALSE));
			if(!restauranteRepository.exists(SECOND_RESTAURANT))
				restauranteRepository.save(new Restaurante(SECOND_RESTAURANT, SUBWAY, ZEROL, SUBWAY_LOGO, FALSE));
				if(!restauranteRepository.exists(THIRD_RESTAURANT))
					restauranteRepository.save(new Restaurante(THIRD_RESTAURANT, STARBUCKS, ZEROL, STARBUCKS_LOGO, FALSE));
					if(!restauranteRepository.exists(FOURTH_RESTAURANT))
						restauranteRepository.save(new Restaurante(FOURTH_RESTAURANT, PIZZA_HUT, ZEROL, PIZZA_HUT_LOGO, FALSE));
						if(!restauranteRepository.exists(FIFTH_RESTAURANT))
							restauranteRepository.save(new Restaurante(FIFTH_RESTAURANT, KFC, ZEROL, KFC_LOGO, FALSE));
	}

}
