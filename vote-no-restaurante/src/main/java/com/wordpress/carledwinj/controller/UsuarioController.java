package com.wordpress.carledwinj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wordpress.carledwinj.model.Restaurante;
import com.wordpress.carledwinj.model.Usuario;
import com.wordpress.carledwinj.repository.UsuarioRepository;

@Controller
@SessionAttributes
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/outros", method = RequestMethod.POST)
	public ModelAndView addUsuario(@ModelAttribute("usuario") Usuario usuario, @ModelAttribute("Restaurante") Restaurante restaurante, BindingResult result) {
		usuario.setRestaurantePreferido(restaurante);
		usuario = usuarioRepository.save(usuario);
		return new ModelAndView("cadastroUsuario", "command", usuario);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public ModelAndView atualizar(@ModelAttribute("usuario") Usuario usuario, @ModelAttribute("Restaurante") Restaurante restaurante, BindingResult result) {
		usuario.setOutroRestaurante(restaurante);
		usuario.setVotou(true);
		usuario = usuarioRepository.save(usuario);
		return new ModelAndView("outrosRestaurantes", "command", usuario);
	}
}
