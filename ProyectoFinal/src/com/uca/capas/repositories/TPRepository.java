package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.TipoPelicula;

public interface TPRepository extends JpaRepository<TipoPelicula, Integer>{

	public List<TipoPelicula> findAll();

	public TipoPelicula findOne(Integer id);
}
