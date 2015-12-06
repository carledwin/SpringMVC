package com.wordpress.carledwinj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wordpress.carledwinj.model.Restaurante;
import com.wordpress.carledwinj.repository.RestauranteRepository;

@Controller
@SessionAttributes
@RequestMapping("")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String restaurantePreferido(Model model) {
		Restaurante restaurante1 = new Restaurante();
		Restaurante restaurante4 = new Restaurante();
		
		restaurante1 = restauranteRepository.findOne(1L);
		restaurante4  = restauranteRepository.findOne(4L);
		
		model.addAttribute("restaurante1", restaurante1);
		model.addAttribute("restaurante4", restaurante4);
		
		return "qualRestaurantePreferido";
	}

	@RequestMapping(value="/consultaRanking",method = RequestMethod.GET)
	public String consultaRanking(Model model) {
		Iterable<Restaurante> todosRestaurantes = restauranteRepository.findAll();
		model.addAttribute("titulo","Ranking");
		model.addAttribute("todosRestaurantes", todosRestaurantes);
		return "ranking";
	}
	
	@RequestMapping(value = "/score", method = RequestMethod.POST)
	public String rankingRestaurantes() {
		return "ranking";
	}

	@ResponseBody
	@RequestMapping("/totalRestaurantes")
	public String quantidadeRestaurantes() {
		return "Existem " + restauranteRepository.count() + " restaurantes cadastrados";
	}
	
	@RequestMapping("/insere")
	public String inserirVarios(Model model) {
		restauranteRepository.save(new Restaurante(1L, "McDonald's", 0L, "mc.png", false));
		restauranteRepository.save(new Restaurante(2L, "Subway", 0L, "sb.png", false));
		restauranteRepository.save(new Restaurante(3L, "Starbucks", 0L, "st.jpg", false));
		restauranteRepository.save(new Restaurante(4L, "Pizza Hut", 0L, "ph.png", false));
		restauranteRepository.save(new Restaurante(5L, "KFC", 0L, "kf.png", false));
		Iterable<Restaurante> todosRestaurantes = restauranteRepository.findAll();
		model.addAttribute("todosRestaurantes", todosRestaurantes);
		model.addAttribute("titulo","Ranking");
		return "ranking";
	}

	@RequestMapping(value = "/Restaurante", method = RequestMethod.GET)
	public ModelAndView showUsuario() {
		return new ModelAndView("restaurante", "command", new Restaurante());
	}

	@RequestMapping(value = "/Restaurante", method = RequestMethod.POST)
	public String addUsuario(@ModelAttribute("restaurante") Restaurante restaurante, BindingResult result) {
		System.out.println("Restaurante: " + restaurante.getId() + " - " + restaurante.getNome());
		restauranteRepository.save(restaurante);
		System.out.println("Restaurante cadastrado com sucesso!");
		return "redirect:ranking";
	}
}
