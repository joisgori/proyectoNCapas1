package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Idiomas;

public interface IdiomaRepository extends JpaRepository<Idiomas, Integer>{

	public List<Idiomas> findAll();
}
