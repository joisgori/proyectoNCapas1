package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Movie;
import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.MovieRepository;
import com.uca.capas.repositories.UsuarioRepository;

@Controller
public class AdminController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@RequestMapping("/todos")
	public ModelAndView admin() {
		ModelAndView mav = new ModelAndView();
		List<Usuario> user = null;
		List<Movie> mov = null;
		try {
			//user = usuarioRepository.findByNUsuario("Cliente");
			user = usuarioRepository.findAll();
			//System.out.println("SI hace algo" + user.toString());
			mov = movieRepository.findAll();
			System.out.println("si hace algo" + mov);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("DatosCliente", user);
		mav.addObject("DatosPelicula", mov);
		mav.setViewName("tablasAdmin");
		
		return mav;
	}
	
}
