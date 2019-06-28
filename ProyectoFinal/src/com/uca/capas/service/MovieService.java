package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Movie;

public interface MovieService {

	public List<Movie> findAll();
	
	//Creo el método delete para movie
	public void delete(Movie movie);
	
	//Creo el método save
	public Movie save(Movie movie);
}
