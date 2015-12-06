package com.wordpress.carledwinj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wordpress.carledwinj.model.Restaurante;
import com.wordpress.carledwinj.model.Usuario;
import com.wordpress.carledwinj.repository.RestauranteRepository;
import com.wordpress.carledwinj.repository.UsuarioRepository;

@Controller
@SessionAttributes
@RequestMapping("")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String restaurantePreferido(){
		return "qualRestaurantePreferido";
	}
	
	@RequestMapping(value="/score", method=RequestMethod.POST)
	public String rankingRestaurantes(){
		return "ranking";
	}
	
	@ResponseBody
	@RequestMapping("/bemVindo/{nome}")
	public String bemVindo(@PathVariable String nome){
		return "Bem vindo, " + nome;
	} 

	@ResponseBody
	@RequestMapping("/totalRestaurantes")
	public String quantidadeRestaurantes(){
		return "Existem " + restauranteRepository.count() + " restaurantes cadastrados";
	}
	
	@ResponseBody
	@RequestMapping("/inserirRestaurantes")
	public String inserirVarios(){
				
		restauranteRepository.save(new Restaurante(null, "Mc Donalds", 0l));
		restauranteRepository.save(new Restaurante(null, "Subway", 0l));
		restauranteRepository.save(new Restaurante(null, "Habib's", 0l));
		restauranteRepository.save(new Restaurante(null, "Patroni Pizza", 0l));
		restauranteRepository.save(new Restaurante(null, "Outback", 0l));
		
		return "Incluidos com sucesso.";
	}
	
	
	@RequestMapping(value="/Restaurante", method=RequestMethod.GET)
	public ModelAndView showUsuario(){
		return new ModelAndView("restaurante", "command", new Restaurante());
	}
	
	@RequestMapping(value="/Restaurante", method=RequestMethod.POST)
	public String addUsuario(@ModelAttribute("restaurante") Restaurante restaurante, BindingResult result){
		System.out.println("Restaurante: " + restaurante.getId() + " - "+ restaurante.getNome());
		restauranteRepository.save(restaurante);
		System.out.println("Restaurante cadastrado com sucesso!");
		return "redirect:ranking";
	}
}
