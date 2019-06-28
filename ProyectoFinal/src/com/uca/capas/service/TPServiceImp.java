package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.TipoPelicula;
import com.uca.capas.repositories.TPRepository;

@Service
public class TPServiceImp implements TPService{

	@Autowired
	TPRepository tPRepository;
	
	public List<TipoPelicula> findAll() {
		return tPRepository.findAll();
	}

	@Override
	public TipoPelicula findOne(Integer id_tipopeli) {
		return tPRepository.findById(id_tipopeli).get();
	}

	@Transactional
	public void delete(TipoPelicula tipopelicula) {
		tPRepository.delete(tipopelicula);
	}

	@Transactional
	public TipoPelicula save(TipoPelicula tp) {
		return tPRepository.save(tp);
	}

}
