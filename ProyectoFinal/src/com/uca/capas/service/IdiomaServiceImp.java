package com.uca.capas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Idiomas;
import com.uca.capas.repositories.IdiomaRepository;

@Service
public class IdiomaServiceImp  implements IdiomaService{
	
	@Autowired
	IdiomaRepository idiomaRepository;
	
	@Transactional
	public Idiomas save(Idiomas idioma) {
		return idiomaRepository.save(idioma);
	}

	@Transactional
	public void delete(Idiomas idioma) {
		idiomaRepository.delete(idioma);
	}

	@Override
	public Idiomas findOne(Integer idioma) {
		return idiomaRepository.findById(idioma).get();
	}

	@Override
	public Idiomas findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
