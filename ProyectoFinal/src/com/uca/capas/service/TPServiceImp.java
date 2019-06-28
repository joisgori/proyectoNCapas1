package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.TipoPelicula;
import com.uca.capas.repositories.TPRepository;

@Service
public class TPServiceImp implements TPService{

	@Autowired
	TPRepository tPRepository;
	
	public List<TipoPelicula> findAll() {
		// TODO Auto-generated method stub
		return tPRepository.findAll();
	}

	@Override
	public TipoPelicula findOne(Integer id_tipopeli) {
		// TODO Auto-generated method stub
		return null;
	}

}
