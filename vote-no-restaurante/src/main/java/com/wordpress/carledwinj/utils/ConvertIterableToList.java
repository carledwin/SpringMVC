package com.wordpress.carledwinj.utils;

import java.util.ArrayList;
import java.util.List;

public class ConvertIterableToList {
	
	public static <E> List<E> toList(Iterable<E> iterable){
		
		if(iterable instanceof List){
			return (List<E>) iterable;
		}
		
		List<E> list = new ArrayList<E>();
		for (E e : list) {
			list.add(e);
		}
		return list;
	}
}
