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

import com.uca.capas.domain.Actor;
import com.uca.capas.domain.Genero;
import com.uca.capas.domain.Horario;
import com.uca.capas.domain.Idiomas;
import com.uca.capas.domain.Movie;
import com.uca.capas.domain.TipoPelicula;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.ActorService;
import com.uca.capas.service.GeneroService;
import com.uca.capas.service.HorarioService;
import com.uca.capas.service.IdiomaService;
import com.uca.capas.service.MovieService;
import com.uca.capas.service.UsuarioService;
import com.uca.capas.service.TPService;

@Controller
public class AdminController {
	
	@Autowired
	ActorService actorService;
	
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
		List<Genero> gen = null;
		try {
			//user = usuarioRepository.findByNUsuario("Cliente");
			user = usuarioService.findAll();
			//System.out.println("SI hace algo" + user.toString());
			mov = movieService.findAll();
			//FALTA MANDAR A LLAMAR EL RESTO DE FINDALL...
			gen = generoService.findAll();
			
			System.out.println("si hace algo" + mov);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("DatosCliente", user);
		mav.addObject("DatosPelicula", mov);
		mav.addObject("DatosGenero", gen);
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
	public ModelAndView elimninarPeli(@RequestParam ("cMovie") Integer id_pelicula) { //Recibo el id del usuario a eliminar
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
	public ModelAndView elimninarGene(@RequestParam ("cGenero") Integer cGenero) { //Recibo el id del genero a eliminar
		ModelAndView mav = new ModelAndView();
		//Debo ir a traer un usuario y luego lo envío para eliminar
		Genero genero = generoService.findOne(cGenero);
		//mando la peli para eliminarlo xd
		generoService.delete(genero);
		//Hago un nuevo llamado de la lista completa de sucursales
		mav.addObject("DatosGenero", generoService.findAll());
		mav.setViewName("redirect:/todos");
		return mav;
	}
	
	@RequestMapping("/ElimTipoPel")//Pongo la ruta que llamará este mappeo
	public ModelAndView elimninarTP(@RequestParam ("cTipoP") Integer id_tipopeli) { //Recibo el id del genero a eliminar
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
	
	@RequestMapping("/ElimIdio")//Pongo la ruta que llamará este mappeo
	public ModelAndView elimninarIdioma(@RequestParam ("cIdioma") Integer id_idioma) { //Recibo el id del genero a eliminar
		ModelAndView mav = new ModelAndView();
		//Debo ir a traer un usuario y luego lo envío para eliminar
		Idiomas idioma = idiomaService.findOne(id_idioma);
		//mando la peli para eliminarlo xd
		idiomaService.delete(idioma);
		//Hago un nuevo llamado de la lista completa de sucursales
		mav.addObject("DatosHorario", horarioService.findAll());
		mav.setViewName("redirect:/todos");
		return mav;
	}
	
	
	@RequestMapping("/ElimHor")//Pongo la ruta que llamará este mappeo
	public ModelAndView elimninarHora(@RequestParam ("cHorario") Integer id_horario) { //Recibo el id del genero a eliminar
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
	
	@RequestMapping("/ElimActo")//Pongo la ruta que llamará este mappeo
	public ModelAndView elimninarActor(@RequestParam ("cActores") Integer id_actor) { //Recibo el id del genero a eliminar
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
	
	@RequestMapping("/insertGen")
	public ModelAndView insertG() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("genero", new Genero()); //ojo acá
		mav.setViewName("formGenero");
		return mav;
	}
	
	@RequestMapping("/insertActo")
	public ModelAndView insertA() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("actor", new Actor()); //ojo acá
		mav.setViewName("formActor");
		return mav;
	}
	
	@RequestMapping("/insertHor")
	public ModelAndView insertH() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("horario", new Horario()); //ojo acá
		mav.setViewName("formHorario");
		return mav;
	}
	
	@RequestMapping("/insertIdiom")
	public ModelAndView insertI() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("idioma", new Idiomas()); //ojo acá
		mav.setViewName("formIdioma");
		return mav;
	}
	
	@RequestMapping("/insertTipoPel")
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

	//Este está guardando el usuario metido por el cliente xd
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
	
	//Guardar nuevos actores
	@RequestMapping(value = "/guardarActor", method= RequestMethod.POST)
	public ModelAndView saveSucursal(@ModelAttribute ("actor") Actor actor) {
		ModelAndView mav = new ModelAndView();
		List<Actor> act = null;
			actorService.save(actor);
			act = actorService.findAll();
			mav.addObject("DatosActor", act);
			mav.setViewName("redirect:/todos");
		
		return mav;
		}
	
	@RequestMapping(value = "/guardarGenero", method= RequestMethod.POST)
	public ModelAndView saveGenero(@ModelAttribute ("genero") Genero genero) {
			ModelAndView mav = new ModelAndView();
			List<Genero> gen = null;
			generoService.save(genero);
			gen = generoService.findAll();
			mav.addObject("DatosGenero", gen);
			mav.setViewName("redirect:/todos");
		
		return mav;
		}
	
	//ACÁ COMIENZAN LOS EDITAR...
	//EditarUsu EditarPeli EditarActo EditarGen EditarHor EditarIdio
	@RequestMapping("/EditarUsu")
	public ModelAndView editarUsu(
			@RequestParam Integer codigo_usuario) {
		ModelAndView mav = new ModelAndView();
		
		Usuario us = usuarioService.findByCUsuario(codigo_usuario);
		mav.addObject("usuario", us);
		mav.setViewName("formCliente");
		return mav;
	}
	
	@RequestMapping("/EditarPeli")
	public ModelAndView editarPeli(
			@RequestParam Integer codigo_peli) {
		ModelAndView mav = new ModelAndView();
		
		Movie mov = movieService.findByCMovie(codigo_peli);
		mav.addObject("pelicula", mov);
		mav.setViewName("formPelicula");
		return mav;
	}
		
	@RequestMapping("/EditarActo")
	public ModelAndView editarActo(
			@RequestParam Integer codigo_acto) {
		ModelAndView mav = new ModelAndView();
		
		Actor actor = actorService.findOne(codigo_acto);
		mav.addObject("actor", actor);
		mav.setViewName("formActor");
		return mav;
	}
	
	@RequestMapping("/EditarGen")
	public ModelAndView editarGen(
			@RequestParam Integer codigo_genero) {
		ModelAndView mav = new ModelAndView();
		
		Genero genero = generoService.findOne(codigo_genero);
		mav.addObject("genero", genero);
		mav.setViewName("formGenero");
		return mav;
	}
	
	@RequestMapping("/EditarHor")
	public ModelAndView editarHor(
			@RequestParam Integer codigo_horario) {
		ModelAndView mav = new ModelAndView();
		
		Horario hor = horarioService.findOne(codigo_horario);
		mav.addObject("horario", hor);
		mav.setViewName("formHorario");
		return mav;
	}
	 
	@RequestMapping("/EditarTipoPel")
	public ModelAndView editarTipopel(
			@RequestParam Integer codigo_tipopel) {
		ModelAndView mav = new ModelAndView();
		
		TipoPelicula txp = tpService.findOne(codigo_tipopel);
		mav.addObject("tipopelicula", txp);
		mav.setViewName("formTP");
		return mav;
	}

	@RequestMapping("/EditarIdio")
	public ModelAndView editarIdio(
			@RequestParam Integer codigo_idioma) {
		ModelAndView mav = new ModelAndView();
	
		Idiomas ido = idiomaService.findOne(codigo_idioma);
		mav.addObject("idioma", ido);
		mav.setViewName("formIdioma");
		return mav;
	}

}