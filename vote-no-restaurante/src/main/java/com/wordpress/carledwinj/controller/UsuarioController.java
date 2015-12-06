package com.wordpress.carledwinj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wordpress.carledwinj.model.Usuario;
import com.wordpress.carledwinj.repository.UsuarioRepository;

@Controller
@SessionAttributes
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="/usuario", method=RequestMethod.POST)
	public ModelAndView addUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult result){
		usuario.setRestaurantePreferido(1L);
		System.out.println("Usuario: " + usuario.getId() + " - "+ usuario.getNome() + " - "+ usuario.getRestaurantePreferido() + " - "+ usuario.isVotou() + " - "+ usuario.getEmail());
		usuario = usuarioRepository.save(usuario);
		System.out.println("Usuario: " + usuario.getId() + " - "+ usuario.getNome() + " - "+ usuario.getRestaurantePreferido() + " - "+ usuario.isVotou() + " - "+ usuario.getEmail());
		System.out.println("Usuario cadastrado com sucesso!");
		return new ModelAndView("cadastroUsuario", "command", usuario);
	}
	
	@RequestMapping(value="/outros", method=RequestMethod.POST)
	public ModelAndView atualizar(@ModelAttribute("usuario") Usuario usuario, BindingResult result){
		usuario.setVotou(true);
		System.out.println("Usuario: " + usuario.getId() + " - "+ usuario.getNome() + " - "+ usuario.getRestaurantePreferido() + " - "+ usuario.isVotou() + " - "+ usuario.getEmail());
		usuario = usuarioRepository.save(usuario);
		System.out.println("Usuario: " + usuario.getId() + " - "+ usuario.getNome() + " - "+ usuario.getRestaurantePreferido() + " - "+ usuario.isVotou() + " - "+ usuario.getEmail());
		System.out.println("Usuario atualizado com sucesso!");
		return new ModelAndView("outrosRestaurantes", "command", usuario);
	}
	
	@ResponseBody
	@RequestMapping("/totalUsuarios")
	public String quantidadeRestaurantes(){
		return "Existem " + usuarioRepository.count() + " usuários cadastrados";
	}
}
