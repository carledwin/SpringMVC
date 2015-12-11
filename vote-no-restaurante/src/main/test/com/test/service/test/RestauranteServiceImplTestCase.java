package com.test.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

import com.wordpress.carledwinj.model.Restaurante;
import com.wordpress.carledwinj.service.RestauranteServiceImpl;

public class RestauranteServiceImplTestCase {

	private RestauranteServiceImpl restauranteServiceImpl = new RestauranteServiceImpl();
	
	@Test
	public void testOrdenarDesc() {
		
		List <Restaurante> listRestaurante = new ArrayList<Restaurante>();
		listRestaurante.add(new Restaurante(10L, "Outback", 55455L, "ttee.jpg",false));
		listRestaurante.add(new Restaurante(450L, "Casa da Esfiha", 98778L, "jygt.jpg",false));
		
		Assert.assertEquals(10L, listRestaurante.get(0).getId().longValue());
		
		Iterable<Restaurante> allRestaurants = listRestaurante;
		
		List <Restaurante> listRestauranteReordenadaDesc = restauranteServiceImpl.ordenarDesc(allRestaurants);
		
		Assert.assertEquals(450L, listRestauranteReordenadaDesc.get(0).getId().longValue());
	}

}
