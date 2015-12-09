package com.wordpress.carledwinj.service;

import java.util.HashMap;

import org.springframework.ui.Model;

import com.wordpress.carledwinj.model.Usuario;

public interface UsuarioService {
	HashMap<String, Object> createUsuarioVotacao(String idRestaurante, Model model);
	HashMap<String, Object> updateUsuarioVotacao(String idStringUsuario, String idStringRestaurante, Model model);
	HashMap<String, Object> finalizeVotacao(String idStringUsuario, Usuario usuario, Model model);
	Usuario findByStringId(String idUsuario);
}
