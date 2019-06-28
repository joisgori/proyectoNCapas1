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

import com.uca.capas.domain.Genero;
import com.uca.capas.domain.Horario;
import com.uca.capas.domain.Idiomas;
import com.uca.capas.domain.Movie;
import com.uca.capas.domain.TipoPelicula;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.GeneroService;
import com.uca.capas.service.HorarioService;
import com.uca.capas.service.IdiomaService;
import com.uca.capas.service.MovieService;
import com.uca.capas.service.UsuarioService;
import com.uca.capas.service.TPService;

@Controller
public class AdminController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	GeneroService generoService;
	
	@Autowired
	TPService TPService;
	
	@Autowired
	HorarioService horarioService;
	
	@Autowired
	IdiomaService idiomaService;
	
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
	
	//Método para el delete de Usuario
	@RequestMapping("/ElimUsu")//Pongo la ruta que llamará este mappeo
	public ModelAndView elimninarUsu(@RequestParam ("cUsuario") Integer cUsuario) { //Recibo el id del usuario a eliminar
		ModelAndView mav = new ModelAndView();
		//Debo ir a traer un usuario y luego lo envío para eliminar
		Usuario user = usuarioService.findByCUsuario(cUsuario);
		//mando el usuario para eliminarlo xd
		usuarioService.delete(user);
		//Hago un nuevo llamado de la lista completa de sucursales
		mav.addObject("DatosCliente", usuarioService.findAll());
		mav.setViewName("redirect:/todos");
		return mav;
	}

	@RequestMapping("/ElimPeli")//Pongo la ruta que llamará este mappeo
	public ModelAndView elimninarPeli(@RequestParam ("id_pelicula") Integer id_pelicula) { //Recibo el id del usuario a eliminar
		ModelAndView mav = new ModelAndView();
		//Debo ir a traer un usuario y luego lo envío para eliminar
		Movie movie = movieService.findByCMovie(id_pelicula);
		//mando la peli para eliminarlo xd
		movieService.delete(movie);
		//Hago un nuevo llamado de la lista completa de sucursales
		mav.addObject("DatosPelicula", movieService.findAll());
		mav.setViewName("redirect:/todos");
		return mav;
	}
	
	@RequestMapping("/ElimGen")//Pongo la ruta que llamará este mappeo
	public ModelAndView elimninarGene(@RequestParam ("id_genero") Integer id_genero) { //Recibo el id del genero a eliminar
		ModelAndView mav = new ModelAndView();
		//Debo ir a traer un usuario y luego lo envío para eliminar
		Genero genero = generoService.findOne(id_genero);
		//mando la peli para eliminarlo xd
		generoService.delete(genero);
		//Hago un nuevo llamado de la lista completa de sucursales
		mav.addObject("DatosGenero", generoService.findAll());
		mav.setViewName("redirect:/todos");
		return mav;
	}
	
	@RequestMapping("/ElimTP")//Pongo la ruta que llamará este mappeo
	public ModelAndView elimninarTP(@RequestParam ("id_tipopeli") Integer id_tipopeli) { //Recibo el id del genero a eliminar
		ModelAndView mav = new ModelAndView();
		//Debo ir a traer un usuario y luego lo envío para eliminar
		TipoPelicula tipopelicula = TPService.findOne(id_tipopeli);
		//mando la peli para eliminarlo xd
		TPService.delete(tipopelicula);
		//Hago un nuevo llamado de la lista completa de sucursales
		mav.addObject("DatosTP", TPService.findAll());
		mav.setViewName("redirect:/todos");
		return mav;
	}
	
	@RequestMapping("/ElimIdioma")//Pongo la ruta que llamará este mappeo
	public ModelAndView elimninarIdioma(@RequestParam ("id_idioma") Integer id_idioma) { //Recibo el id del genero a eliminar
		ModelAndView mav = new ModelAndView();
		//Debo ir a traer un usuario y luego lo envío para eliminar
		Idiomas idioma = idiomaService.findOne(id_idioma);
		//mando la peli para eliminarlo xd
		idiomaService.delete(idioma);
		//Hago un nuevo llamado de la lista completa de sucursales
		mav.addObject("DatosIdioma", idiomaService.findAll());
		mav.setViewName("redirect:/todos");
		return mav;
	}
	
	
	@RequestMapping("/ElimHor")//Pongo la ruta que llamará este mappeo
	public ModelAndView elimninarHora(@RequestParam ("id_horario") Integer id_horario) { //Recibo el id del genero a eliminar
		ModelAndView mav = new ModelAndView();
		//Debo ir a traer un usuario y luego lo envío para eliminar
		Horario horario = horarioService.findOne(id_horario);
		//mando la peli para eliminarlo xd
		horarioService.delete(horario);
		//Hago un nuevo llamado de la lista completa de sucursales
		mav.addObject("DatosHorario", horarioService.findAll());
		mav.setViewName("redirect:/todos");
		return mav;
	}
	
	//-------Ahora voy con los controladores para hacer los insert...------------------
	//Creo un par de controladores que manden a los formularios
	@RequestMapping("/insertCliente")
	public ModelAndView insertC() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", new Usuario()); //ojo acá
		mav.setViewName("formCliente");
		return mav;
	}

	@RequestMapping("/insertPeli")
	public ModelAndView insertP() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pelicula", new Movie()); //ojo acá
		mav.setViewName("formPelicula");
		return mav;
	}
	
	//--> ahora sí va la lógica del guardado
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
