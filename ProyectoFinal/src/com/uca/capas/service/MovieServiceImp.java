package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Movie;
import com.uca.capas.repositories.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	
	@Transactional //Mando a pedir este método delete del crud de jpa
	public void delete(Movie movie) {
		movieRepository.delete(movie);
	}
	
	//Ahora va el Save
	@Transactional
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}
	
}
