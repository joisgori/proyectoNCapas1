package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Actor;

public interface ActorService {
	
	public Actor save(Actor actor);
	
	public void delete(Actor actor);
	
	public Actor findOne(Integer actor);
	
	public List<Actor> findAll();
}
