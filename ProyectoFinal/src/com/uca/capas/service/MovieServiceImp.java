package com.uca.capas.service;

import java.util.List;

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

}
