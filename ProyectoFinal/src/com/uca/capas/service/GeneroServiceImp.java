package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Genero;
import com.uca.capas.repositories.GeneroRepository;


@Service
public class GeneroServiceImp implements GeneroService{

	@Autowired
	GeneroRepository generoRepository;
	
	@Transactional
	public void delete(Genero genero) {
		generoRepository.delete(genero);
	}

	@Transactional
	public Genero save(Genero genero) {
		return generoRepository.save(genero);
	}

	@Override
	public Genero findOne(Integer genero) {
		return generoRepository.findById(genero).get();
	}

	@Override
	public List<Genero> findAll() {	
		return generoRepository.findAll();
	}

}
