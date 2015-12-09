package com.wordpress.carledwinj.utils;

import java.util.Comparator;

import com.wordpress.carledwinj.model.Restaurante;

public class OrdenaDescRestaurante implements Comparator<Restaurante>{

	@Override
	public int compare(Restaurante r1, Restaurante r2) {
		
		if(r1.getScore() > r2.getScore()){
			return -1;
		}else if(r1.getScore() < r2.getScore()){
			return 1;
		}else{
		return 0;
		}
	}

}
