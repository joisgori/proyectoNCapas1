package com.uca.capas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Actor;
import com.uca.capas.repositories.ActorRepository;

@Service
public class ActorServiceImp implements ActorService{
	
	@Autowired
	ActorRepository actorRepository;

	@Transactional
	public Actor save(Actor actor) {
		return actorRepository.save(actor);
	}

	@Transactional
	public void delete(Actor actor) {
		actorRepository.delete(actor);
	}

	@Override
	public Actor findOne(Integer actor) {
		return actorRepository.findById(actor).get();
	}

	
}
