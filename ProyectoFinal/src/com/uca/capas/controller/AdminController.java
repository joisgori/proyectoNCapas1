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
	TPService tpService;
	
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
		TipoPelicula tipopelicula = tpService.findOne(id_tipopeli);
		//mando la peli para eliminarlo xd
		tpService.delete(tipopelicula);
		//Hago un nuevo llamado de la lista completa de sucursales
		mav.addObject("DatosTP", tpService.findAll());
		mav.setViewName("redirect:/todos");
		return mav;
	}
	
	@RequestMapping("/ElimIdioma")//Pongo la ruta que llamará este mappeo
	public ModelAndView elimninarIdioma(@RequestParam ("id_idioma") Integer id_idioma) { //Recibo el id del genero a eliminar
		ModelAndView mav = new ModelAndView();
		//Debo ir a traer un usuario y luego lo envío para eliminar
		Idiomas idioma = horarioService.findOne(id_horario);
		//mando la peli para eliminarlo xd
		horarioService.delete(horario);
		//Hago un nuevo llamado de la lista completa de sucursales
		mav.addObject("DatosHorario", horarioService.findAll());
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
	
	@RequestMapping("/ElimActor")//Pongo la ruta que llamará este mappeo
	public ModelAndView elimninarActor(@RequestParam ("id_actor") Integer id_actor) { //Recibo el id del genero a eliminar
		ModelAndView mav = new ModelAndView();
		//Debo ir a traer un usuario y luego lo envío para eliminar
		Actor actor = actorService.findOne(id_actor);
		//mando la peli para eliminarlo xd
		actorService.delete(actor);
		//Hago un nuevo llamado de la lista completa de sucursales
		mav.addObject("DatosActor", actorService.findAll());
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
	
	@RequestMapping("/insertGenero")
	public ModelAndView insertG() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("genero", new Genero()); //ojo acá
		mav.setViewName("formGenero");
		return mav;
	}
	
	@RequestMapping("/insertActor")
	public ModelAndView insertA() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("actor", new Actor()); //ojo acá
		mav.setViewName("formActor");
		return mav;
	}
	
	@RequestMapping("/insertHorario")
	public ModelAndView insertH() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("horario", new Horario()); //ojo acá
		mav.setViewName("formHorario");
		return mav;
	}
	
	@RequestMapping("/insertIdioma")
	public ModelAndView insertI() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("idioma", new Idiomas()); //ojo acá
		mav.setViewName("formIdioma");
		return mav;
	}
	
	@RequestMapping("/insertTP")
	public ModelAndView insertTP() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("tipopelicula", new TipoPelicula()); //ojo acá
		mav.setViewName("formTP");
		return mav;
	}
	
	//--> ahora sí va la lógica del guardado
	@RequestMapping(value = "/guardarPelicula", method= RequestMethod.POST)
	public ModelAndView saveSucursal(@ModelAttribute ("pelicula") Movie movie, BindingResult r) {
		ModelAndView mav = new ModelAndView();
		List<Movie> mov = null;
		if(r.hasErrors()) {
			mav.setViewName("formPelicula");
			System.out.println(r.hasErrors());
		}else {
			movieService.save(movie);
			mov = movieService.findAll();
			mav.addObject("DatosPelicula", mov);
			mav.setViewName("redirect:/todos");
		}
		return mav;
		}

	@RequestMapping(value = "/guardarUsuario", method= RequestMethod.POST)
	public ModelAndView saveSucursal(@ModelAttribute ("usuario") Usuario usuario) {
		ModelAndView mav = new ModelAndView();
		List<Usuario> us = null;
			usuarioService.save(usuario);
			us = usuarioService.findAll();
			mav.addObject("DatosCliente", us);
			mav.setViewName("redirect:/todos");
		return mav;
		}
	
	@RequestMapping(value = "/guardarActor", method= RequestMethod.POST)
	public ModelAndView saveSucursal(@Valid @ModelAttribute ("actor") Actor actor, BindingResult r) {
		ModelAndView mav = new ModelAndView();
		List<Actor> act = null;
		if(r.hasErrors()) {
			mav.setViewName("formActor");
		}else {
			actorService.save(actor);
			act = actorService.findAll();
			mav.addObject("DatosActor", act);
			mav.setViewName("redirect:/todos");
		}
		return mav;
		}
	
	@RequestMapping(value = "/guardarGenero", method= RequestMethod.POST)
	public ModelAndView saveSucursal(@Valid @ModelAttribute ("genero") Genero genero, BindingResult r) {
		ModelAndView mav = new ModelAndView();
		List<Genero> gen = null;
		if(r.hasErrors()) {
			mav.setViewName("formGenero");
		}else {
			generoService.save(genero);
			gen = generoService.findAll();
			mav.addObject("DatosCliente", gen);
			mav.setViewName("redirect:/todos");
		}
		return mav;
		}
	
}
