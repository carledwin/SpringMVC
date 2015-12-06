package com.wordpress.carledwinj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wordpress.carledwinj.model.Restaurante;

@Controller
@SessionAttributes
public class RestauranteController {

	@RequestMapping(value="/Restaurante", method=RequestMethod.GET)
	public ModelAndView showUsuario(){
		return new ModelAndView("restaurante", "command", new Restaurante());
	}
	
	@RequestMapping(value="/Restaurante", method=RequestMethod.POST)
	public String addUsuario(@ModelAttribute("restaurante") Restaurante restaurante, BindingResult result){
		System.out.println("Restaurante: " + restaurante.getId() + " - "+ restaurante.getNome());
		
		return "redirect:Restaurante";
	}
	
	
	/*
	 * @RequestMapping(value="/Restaurante", method=RequestMethod.GET)
	public String viewRestaurante(){
		return "restaurante";
	}
	*/
	
	
}
