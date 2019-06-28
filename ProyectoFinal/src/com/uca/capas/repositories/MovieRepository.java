package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

	public List<Movie> findAll();
	
	//Implemento el m�todo de b�squeda �nica que me servir� para mezclarlo con el delete
	public Movie findByCMovie(Integer id);
	
}
