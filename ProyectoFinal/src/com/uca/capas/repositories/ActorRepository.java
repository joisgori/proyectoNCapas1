package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer>{
	
	public List<Actor> findAll();

}
