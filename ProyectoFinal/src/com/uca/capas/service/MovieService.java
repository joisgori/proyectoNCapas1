package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Movie;
import com.uca.capas.domain.Usuario;

public interface MovieService {

	public List<Movie> findAll();
	
	//Creo el m�todo de delete necesito un findById para poder mandar dicho objeto
	public Movie findByCMovie(Integer id);
	//ahora s�, creo el delete que recibe un objeto del tipo movie
	public void delete(Movie movie);
	
	//Creo el m�todo save
	public Movie save(Movie movie);
	
}
