package com.wordpress.carledwinj.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.wordpress.carledwinj.model.Restaurante;
import com.wordpress.carledwinj.model.Usuario;
import com.wordpress.carledwinj.repository.RestauranteRepository;
import com.wordpress.carledwinj.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final String TITLE_PAGE_RANKING = "Ranking";
	private static final String ATT_TITULO = "titulo";
	private static final String ATT_TODOS_RESTAURANTES = "todosRestaurantes";
	private static final String ATT_USUARIO = "usuario";
	private static final String ATT_RESTAURANTE_PREFERIDO = "restaurantePreferido";
	private static final String ATT_OUTRO_RESTAURANTE = "outroRestaurante";
	private static final String ATT_RESTAURANTE5 = "restaurante5";
	private static final String ATT_RESTAURANTE3 = "restaurante3";
	private static final String ATT_RESTAURANTE2 = "restaurante2";
	private static final String ATT_RESTAURANTE_NAO_SELECIONADO = "restauranteNaoSelecionado";
	private static final String ATT_ID_USUARIO = "idUsuario";
	private static final String KEY_MAV = "mav";
	private static final String KEY_MODEL = "model";
	private static final String COMMAND = "command";
	private static final String URL_RANKING = "ranking";
	private static final String URL_OUTROS_RESTAURANTES = "outrosRestaurantes";
	private static final String URL_CADASTRO_USUARIO = "cadastroUsuario";
	private static final Long SCORE_PREFERIDO = 250L;
	private static final Long SCORE_OUTRO = 180L;
	private static final long FIRST_RESTAURANT = 1L;
	private static final long SECOND_RESTAURANT = 2L;
	private static final long THIRD_RESTAURANT = 3L;
	private static final long FOURTH_RESTAURANT = 4L;
	private static final long FIFTH_RESTAURANT = 5L;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private RestauranteService restauranteService;

	@Override
	public HashMap<String, Object> createUsuarioVotacao(String restaurante, Model model) {
		Usuario usuario = new Usuario();
		Restaurante restaurante1 = restauranteRepository.findOne(FIRST_RESTAURANT);
		Restaurante restaurante2 = restauranteRepository.findOne(SECOND_RESTAURANT);
		Restaurante restaurante3 = restauranteRepository.findOne(THIRD_RESTAURANT);
		Restaurante restaurante4 = restauranteRepository.findOne(FOURTH_RESTAURANT);
		Restaurante restaurante5 = restauranteRepository.findOne(FIFTH_RESTAURANT);
		if (Long.parseLong(restaurante) == restaurante1.getId()) {
			usuario.setRestaurantePreferido(restaurante1.getId());
			usuario.setPreferidoScore(SCORE_PREFERIDO);
			restaurante1.setScore(restaurante1.getScore() + SCORE_PREFERIDO);
			restauranteRepository.save(restaurante1);
			model.addAttribute(ATT_RESTAURANTE_NAO_SELECIONADO, restaurante4);
			model.addAttribute(ATT_RESTAURANTE2, restaurante2);
			model.addAttribute(ATT_RESTAURANTE3, restaurante3);
			model.addAttribute(ATT_RESTAURANTE5, restaurante5);
		} else {
			usuario.setRestaurantePreferido(restaurante4.getId());
			usuario.setPreferidoScore(SCORE_PREFERIDO);
			restaurante4.setScore(restaurante4.getScore() + SCORE_PREFERIDO);
			restauranteRepository.save(restaurante4);
			model.addAttribute(ATT_RESTAURANTE_NAO_SELECIONADO, restaurante1);
			model.addAttribute(ATT_RESTAURANTE2, restaurante2);
			model.addAttribute(ATT_RESTAURANTE3, restaurante3);
			model.addAttribute(ATT_RESTAURANTE5, restaurante5);
		}
		usuario = usuarioRepository.save(usuario);
		model.addAttribute(ATT_ID_USUARIO, usuario.getId());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(KEY_MODEL, model);
		map.put(KEY_MAV, new ModelAndView(URL_OUTROS_RESTAURANTES, COMMAND, usuario));
		return map;
	}

	public HashMap<String, Object> updateUsuarioVotacao(String idStringUsuario, String idStringRestaurante,
			Model model) {
		Usuario usuario = usuarioRepository.findOne(Long.parseLong(idStringUsuario));
		Long idRestaurante = Long.parseLong(idStringRestaurante);
		if (idRestaurante == FIRST_RESTAURANT) {
			usuario.setOutroRestaurante(FIRST_RESTAURANT);
			usuario = atualizaVotos(idRestaurante, usuario);
		} else if (idRestaurante == SECOND_RESTAURANT) {
			usuario = atualizaVotos(idRestaurante, usuario);
		} else if (idRestaurante == THIRD_RESTAURANT) {
			usuario = atualizaVotos(idRestaurante, usuario);
		} else if (idRestaurante == FOURTH_RESTAURANT) {
			usuario = atualizaVotos(idRestaurante, usuario);
		} else if (idRestaurante == FIFTH_RESTAURANT) {
			usuario = atualizaVotos(idRestaurante, usuario);
		}
		model.addAttribute(ATT_ID_USUARIO, usuario.getId());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(KEY_MODEL, model);
		map.put(KEY_MAV, new ModelAndView(URL_CADASTRO_USUARIO, COMMAND, usuario));
		return map;
	}

	@Override
	public HashMap<String, Object> finalizeVotacao(String idStringUsuario, Usuario usuario, Model model) {
		Usuario usuarioAux = usuarioRepository.findOne(Long.parseLong(idStringUsuario));
		usuarioAux.setVotou(true);
		usuarioAux.setEmail(usuario.getEmail());
		usuarioAux.setNome(usuario.getNome());
		usuario = usuarioRepository.save(usuarioAux);
		Iterable<Restaurante> todosRestaurantes = restauranteRepository.findAll();
		List<Restaurante> listRestaurante = restauranteService.ordenarDesc(todosRestaurantes);
		model.addAttribute(ATT_TITULO, TITLE_PAGE_RANKING);
		model.addAttribute(ATT_TODOS_RESTAURANTES, listRestaurante);
		model.addAttribute(ATT_USUARIO, usuario);
		model.addAttribute(ATT_RESTAURANTE_PREFERIDO, restauranteRepository.findOne(usuario.getRestaurantePreferido()));
		model.addAttribute(ATT_OUTRO_RESTAURANTE, restauranteRepository.findOne(usuario.getOutroRestaurante()));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(KEY_MODEL, model);
		map.put(KEY_MAV, new ModelAndView(URL_RANKING, COMMAND, usuario));
		return map;
	}

	@Override
	public Usuario findByStringId(String idUsuario) {
		return usuarioRepository.findOne(Long.parseLong(ATT_ID_USUARIO));
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
}
