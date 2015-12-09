package com.wordpress.carledwinj.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wordpress.carledwinj.model.Usuario;
import com.wordpress.carledwinj.service.UsuarioService;

@Controller
@SessionAttributes
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/outros", method = RequestMethod.POST)
	public ModelAndView createUsuarioVotacao(@ModelAttribute("restaurante") String idRestaurante, Model model) {
		HashMap<String, Object> map = usuarioService.createUsuarioVotacao(idRestaurante, model);
		model = (Model) map.get("model");
		ModelAndView mav = (ModelAndView) map.get("mav");
		return mav;
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public ModelAndView updateUsuarioVotacao(@ModelAttribute("idUsuario") String idStringUsuario, @ModelAttribute("restaurante") String idStringRestaurante, BindingResult result, Model model) {
		HashMap<String, Object> map = usuarioService.updateUsuarioVotacao(idStringUsuario, idStringRestaurante, model);	
		model = (Model) map.get("model");
		ModelAndView mav = (ModelAndView) map.get("mav");
		return mav;
	}
	
	
	@RequestMapping(value = "/finalizarVotacao", method = RequestMethod.POST)
	public ModelAndView finalizeVotacao(@ModelAttribute("idUsuario") String idStringUsuario, @ModelAttribute("usuario") Usuario usuario, Model model, BindingResult result) {
		HashMap<String, Object> map = usuarioService.finalizeVotacao(idStringUsuario, usuario, model);	
		model = (Model) map.get("model");
		ModelAndView mav = (ModelAndView) map.get("mav");
		return mav;	
	}
}
