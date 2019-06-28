package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Integer>{

	public List<Genero> findAll();
}
