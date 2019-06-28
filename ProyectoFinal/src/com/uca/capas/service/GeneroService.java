package com.uca.capas.service;


import com.uca.capas.domain.Genero;

public interface GeneroService {
	
	public void delete(Genero genero);
	
	public Genero save (Genero genero);
	
	public Genero findOne(Integer genero);

}
