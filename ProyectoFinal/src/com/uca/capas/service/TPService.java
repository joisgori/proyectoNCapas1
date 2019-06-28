package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.TipoPelicula;

public interface TPService {

	public List<TipoPelicula> findAll();

	public TipoPelicula findOne(Integer id_tipopeli);

	public void delete(TipoPelicula tipopelicula);
}
