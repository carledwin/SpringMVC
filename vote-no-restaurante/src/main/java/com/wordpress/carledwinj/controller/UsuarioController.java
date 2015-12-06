package com.wordpress.carledwinj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wordpress.carledwinj.model.Restaurante;
import com.wordpress.carledwinj.model.Usuario;
import com.wordpress.carledwinj.repository.RestauranteRepository;
import com.wordpress.carledwinj.repository.UsuarioRepository;

@Controller
@SessionAttributes
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@RequestMapping(value = "/outros", method = RequestMethod.POST)
	public ModelAndView addUsuario(@ModelAttribute("usuario") Usuario usuario, @ModelAttribute("restaurante1") Restaurante restaurante1,  @ModelAttribute("restaurante4") Restaurante restaurante4, BindingResult result, Model model) {
		Restaurante restaurante2 = new Restaurante();
		Restaurante restaurante3 = new Restaurante();
		Restaurante restaurante5 = new Restaurante();
		
		restaurante4 =  restauranteRepository.findOne(4L);//mock
		restaurante4.setSelecionado(true);//mock
		restaurante1 =  restauranteRepository.findOne(1L);//mock
		restaurante1.setSelecionado(false);//mock
		
		restaurante2 = restauranteRepository.findOne(2L);
		restaurante3 = restauranteRepository.findOne(3L);
		restaurante5 = restauranteRepository.findOne(5L);
		
		if (restaurante1.isSelecionado()){
			usuario.setRestaurantePreferido(restaurante1.getId());
			model.addAttribute("restauranteNaoSelecionado", restaurante4);
			model.addAttribute("restaurante2", restaurante2);
			model.addAttribute("restaurante3", restaurante3);
			model.addAttribute("restaurante5", restaurante5);
		}else{
			usuario.setRestaurantePreferido(restaurante4.getId());
			model.addAttribute("restauranteNaoSelecionado", restaurante1);//mock
			model.addAttribute("restaurante2", restaurante2);
			model.addAttribute("restaurante3", restaurante3);
			model.addAttribute("restaurante5", restaurante5);
		}
		usuario = usuarioRepository.save(usuario);
		
		return new ModelAndView("outrosRestaurantes", "command", usuario);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public ModelAndView atualizar(@ModelAttribute("usuario") Usuario usuario, @ModelAttribute("restauranteNaoSelecionado") Restaurante restauranteNaoSelecionado, @ModelAttribute("restaurante2") Restaurante restaurante2, @ModelAttribute("restaurante3") Restaurante restaurante3, @ModelAttribute("restaurante5") Restaurante restaurante5, BindingResult result) {
		
		if (restauranteNaoSelecionado.isSelecionado()){
			usuario.setOutroRestaurante(restauranteNaoSelecionado.getId());
		}else if (restaurante2.isSelecionado()){
			usuario.setRestaurantePreferido(restaurante2.getId());
			
		}else if (restaurante3.isSelecionado()){
			usuario.setOutroRestaurante(restaurante3.getId());
			
		}else if (restaurante5.isSelecionado()){
			usuario.setOutroRestaurante(restaurante5.getId());
		}
		usuario = usuarioRepository.save(usuario);
		return new ModelAndView("cadastroUsuario", "command", usuario);
	}
	
	@RequestMapping(value = "/finalizarVotacao", method = RequestMethod.POST)
	public String finalizar(@ModelAttribute("usuario") Usuario usuario, Model model, BindingResult result) {
		usuario.setVotou(true);
		usuario = usuarioRepository.save(usuario);
		Iterable<Restaurante> todosRestaurantes = restauranteRepository.findAll();
		model.addAttribute("titulo","Ranking");
		model.addAttribute("todosRestaurantes", todosRestaurantes);
		model.addAttribute("usuario", usuario);
		return "ranking";
	}
}
