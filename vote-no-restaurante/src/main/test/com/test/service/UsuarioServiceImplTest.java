package com.test.service;

import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.wordpress.carledwinj.service.UsuarioService;

public class UsuarioServiceImplTest {
	
	
	private UsuarioService usuarioService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void createUsuarioVotacaoTest() {
		Model model = new ExtendedModelMap();
		HashMap<String, Object> map = usuarioService.createUsuarioVotacao("1", model);
		map.get("");
		map.get("");
		
		fail("Not yet implemented");
	}

}
