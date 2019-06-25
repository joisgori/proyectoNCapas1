package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

	public List<Movie> findAll();
	
}
