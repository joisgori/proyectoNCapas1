package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Movie;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.MovieService;
import com.uca.capas.service.UsuarioService;

@Controller
public class AdminController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	MovieService movieService;
	
	@RequestMapping("/todos")
	public ModelAndView admin() {
		ModelAndView mav = new ModelAndView();
		List<Usuario> user = null;
		List<Movie> mov = null;
		try {
			//user = usuarioRepository.findByNUsuario("Cliente");
			user = usuarioService.findAll();
			//System.out.println("SI hace algo" + user.toString());
			mov = movieService.findAll();
			System.out.println("si hace algo" + mov);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("DatosCliente", user);
		mav.addObject("DatosPelicula", mov);
		mav.setViewName("tablasAdmin");
		
		return mav;
	}
	
	//M�todo para el delete de Usuario
	@RequestMapping("/ElimUsu")//Pongo la ruta que llamar� este mappeo
	public ModelAndView elimninarUsu(@RequestParam ("cUsuario") Integer cUsuario) { //Recibo el id del usuario a eliminar
		ModelAndView mav = new ModelAndView();
		//Debo ir a traer un usuario y luego lo env�o para eliminar
		Usuario user = usuarioService.findByCUsuario(cUsuario);
		//mando el usuario para eliminarlo xd
		usuarioService.delete(user);
		//Hago un nuevo llamado de la lista completa de sucursales
		mav.addObject("DatosCliente", usuarioService.findAll());
		mav.setViewName("redirect:/todos");
		return mav;
	}

	@RequestMapping("/ElimPeli")//Pongo la ruta que llamar� este mappeo
	public ModelAndView elimninarPeli(@RequestParam ("id_pelicula") Integer id_pelicula) { //Recibo el id del usuario a eliminar
		ModelAndView mav = new ModelAndView();
		//Debo ir a traer un usuario y luego lo env�o para eliminar
		Movie movie = movieService.findByCMovie(id_pelicula);
		//mando la peli para eliminarlo xd
		movieService.delete(movie);
		//Hago un nuevo llamado de la lista completa de sucursales
		mav.addObject("DatosPelicula", movieService.findAll());
		mav.setViewName("redirect:/todos");
		return mav;
	}
	
	//-------Ahora voy con los controladores para hacer los insert...------------------
	//Creo un par de controladores que manden a los formularios
	@RequestMapping("/insertCliente")
	public ModelAndView insertC() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", new Usuario()); //ojo ac�
		mav.setViewName("formCliente");
		return mav;
	}

	@RequestMapping("/insertPeli")
	public ModelAndView insertP() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pelicula", new Movie()); //ojo ac�
		mav.setViewName("formPelicula");
		return mav;
	}
	
	//--> ahora s� va la l�gica del guardado
	@RequestMapping(value = "/guardarPelicula", method= RequestMethod.POST)
	public ModelAndView saveSucursal(@Valid @ModelAttribute ("pelicula") Movie movie, BindingResult r) {
		ModelAndView mav = new ModelAndView();
		List<Movie> mov = null;
		if(r.hasErrors()) {
			mav.setViewName("formPelicula");
		}else {
			movieService.save(movie);
			mov = movieService.findAll();
			mav.addObject("DatosPelicula", mov);
			mav.setViewName("redirect:/todos");
		}
		return mav;
		}

	@RequestMapping(value = "/guardarUsuario", method= RequestMethod.POST)
	public ModelAndView saveSucursal(@Valid @ModelAttribute ("usuario") Usuario user, BindingResult r) {
		ModelAndView mav = new ModelAndView();
		List<Usuario> us = null;
		if(r.hasErrors()) {
			mav.setViewName("formCliente");
		}else {
			usuarioService.save(user);
			us = usuarioService.findAll();
			mav.addObject("DatosCliente", us);
			mav.setViewName("redirect:/todos");
		}
		return mav;
		}
	
}
