package com.wordpress.carledwinj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wordpress.carledwinj.model.Restaurante;
import com.wordpress.carledwinj.model.Usuario;
import com.wordpress.carledwinj.repository.RestauranteRepository;
import com.wordpress.carledwinj.repository.UsuarioRepository;

@Controller
@SessionAttributes
public class UsuarioController {

	private static final Long SCORE_PREFERIDO = 250L;

	private static final Long SCORE_OUTRO = 180L;

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
			usuario.setPreferidoScore(SCORE_PREFERIDO);
			restaurante1.setScore(restaurante1.getScore() + SCORE_PREFERIDO);
			restauranteRepository.save(restaurante1);
			model.addAttribute("restauranteNaoSelecionado", restaurante4);
			model.addAttribute("restaurante2", restaurante2);
			model.addAttribute("restaurante3", restaurante3);
			model.addAttribute("restaurante5", restaurante5);
		}else{
			usuario.setRestaurantePreferido(restaurante4.getId());
			usuario.setPreferidoScore(SCORE_PREFERIDO);
			restaurante4.setScore(restaurante4.getScore() + SCORE_PREFERIDO);
			restauranteRepository.save(restaurante4);
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
	public ModelAndView atualizar(@ModelAttribute("idUsuario") String idUsuario, @ModelAttribute("restaurante") String restaurante, BindingResult result, Model model) {
				
		Usuario usuario = usuarioRepository.findOne(Long.parseLong(idUsuario));
		
		Long idRestaurante = Long.parseLong(restaurante);
		
		if (idRestaurante == 1L){
			usuario.setOutroRestaurante(1L);
			usuario = atualizaVotos(idRestaurante,usuario);
		}else if (idRestaurante == 2L){
			usuario = atualizaVotos(idRestaurante,usuario);
		}else if (idRestaurante == 3L){
			usuario = atualizaVotos(idRestaurante,usuario);
		}else if (idRestaurante == 4L){
			usuario = atualizaVotos(idRestaurante,usuario);
		}else if (idRestaurante ==5L){
			usuario = atualizaVotos(idRestaurante,usuario);
		}
		
		model.addAttribute("idUsuario", usuario.getId());
		
		return new ModelAndView("cadastroUsuario", "command", usuario);
	}

	private Usuario atualizaVotos(Long idRestaurante, Usuario usuario) {
		Restaurante restaurante;
		restaurante = restauranteRepository.findOne(idRestaurante);
		usuario.setOutroRestaurante(restaurante.getId());
		restaurante.setScore(restaurante.getScore() + SCORE_OUTRO);
		usuario.setOutroScore(SCORE_OUTRO);
		usuario = usuarioRepository.save(usuario);
		restauranteRepository.save(restaurante);
		return usuario;
	}
	
	@RequestMapping(value = "/finalizarVotacao", method = RequestMethod.POST)
	public ModelAndView finalizar(@ModelAttribute("idUsuario") String idUsuario, @ModelAttribute("usuario") Usuario usuario, Model model, BindingResult result) {
		
		Usuario usuarioAux = usuarioRepository.findOne(Long.parseLong(idUsuario));
		usuarioAux.setVotou(true);
		usuarioAux.setEmail(usuario.getEmail());
		usuarioAux.setNome(usuario.getNome());
		
		usuario = usuarioRepository.save(usuarioAux);
		
		Iterable<Restaurante> todosRestaurantes = restauranteRepository.findAll();
		model.addAttribute("titulo","Ranking");
		model.addAttribute("todosRestaurantes", todosRestaurantes);
		model.addAttribute("usuario", usuario);
		
		model.addAttribute("restaurantePreferido", restauranteRepository.findOne(usuario.getRestaurantePreferido()));
		model.addAttribute("outroRestaurante", restauranteRepository.findOne(usuario.getOutroRestaurante()));
		
		return new ModelAndView("ranking", "command", usuario);
	}
}
