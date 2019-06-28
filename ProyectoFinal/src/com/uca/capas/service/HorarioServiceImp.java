package com.uca.capas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Horario;
import com.uca.capas.repositories.HorarioRepository;

@Service
public class HorarioServiceImp implements HorarioService{

	@Autowired
	HorarioRepository horarioRepository;
	
	@Transactional
	public Horario save(Horario horario) {
		return horarioRepository.save(horario);
	}

	@Transactional
	public void delete(Horario horario) {
		horarioRepository.delete(horario);
	}

}
