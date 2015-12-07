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
	public ModelAndView addUsuario(@ModelAttribute("restaurante") String restaurante, BindingResult result, Model model) {
		
		Usuario usuario = new Usuario();
		
		Restaurante restaurante1 = restauranteRepository.findOne(1L);
		Restaurante restaurante2 = restauranteRepository.findOne(2L);
		Restaurante restaurante3 = restauranteRepository.findOne(3L);
		Restaurante restaurante4 = restauranteRepository.findOne(4L);
		Restaurante restaurante5 = restauranteRepository.findOne(5L);
		
		
		if (Long.parseLong(restaurante) == restaurante1.getId()){
			usuario.setRestaurantePreferido(restaurante1.getId());
			model.addAttribute("restauranteNaoSelecionado", restaurante4);
			model.addAttribute("restaurante2", restaurante2);
			model.addAttribute("restaurante3", restaurante3);
			model.addAttribute("restaurante5", restaurante5);
		}else{
			usuario.setRestaurantePreferido(restaurante4.getId());
			model.addAttribute("restauranteNaoSelecionado", restaurante1);
			model.addAttribute("restaurante2", restaurante2);
			model.addAttribute("restaurante3", restaurante3);
			model.addAttribute("restaurante5", restaurante5);
		}
		usuario = usuarioRepository.save(usuario);
		
		model.addAttribute("idUsuario", usuario.getId());
		
		return new ModelAndView("outrosRestaurantes", "command", usuario);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public String atualizar(@ModelAttribute("idUsuario") String idUsuario,  @ModelAttribute("usuario") Usuario usuario, @ModelAttribute("restaurante") String restaurante, BindingResult result, Model model) {
		
		Usuario usuario2 = usuarioRepository.findOne(Long.parseLong("idUsuario"));
		
		if (Long.parseLong(restaurante) == 1L){
			usuario.setOutroRestaurante(1L);
		}else if (Long.parseLong(restaurante) == 2L){
			usuario.setRestaurantePreferido(1L);
		}else if (Long.parseLong(restaurante) == 3L){
			usuario.setOutroRestaurante(3L);
		}else if (Long.parseLong(restaurante) == 4L){
			usuario.setOutroRestaurante(4L);
		}else if (Long.parseLong(restaurante) ==5L){
			usuario.setOutroRestaurante(5L);
		}
		usuario = usuarioRepository.save(usuario);
		
		model.addAttribute("idUsuario", usuario.getId());
		
		return "cadastroUsuario";
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
