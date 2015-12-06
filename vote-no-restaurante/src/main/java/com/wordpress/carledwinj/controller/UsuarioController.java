package com.wordpress.carledwinj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wordpress.carledwinj.model.Usuario;

@Controller
@SessionAttributes
public class UsuarioController {

	
	/*@RequestMapping(value="/Usuario", method=RequestMethod.POST)
	public String addUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult result){
		System.out.println("Usuario: " + usuario.getNome() + usuario.getEmail());
		
		return "redirect:Usuario";
	}
	
	@RequestMapping(value="/Usuario", method=RequestMethod.GET)
	public ModelAndView showUsuario(){
		return new ModelAndView("Usuario", "command", new Usuario());
	}
	*/
	
	@RequestMapping(value="/Usuario", method=RequestMethod.GET)
	public String viewUsuario(){
		return "";
	}
}
