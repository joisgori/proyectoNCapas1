package com.uca.capas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.TipoPelicula;

public interface TPRepository extends JpaRepository<TipoPelicula, Integer>{

}
