package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Movie;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.MovieService;
import com.uca.capas.service.UsuarioService;

@Controller
public class MainController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	MovieService movieService;
	
	
	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}

	@RequestMapping(value= "/verifyLogin", method=RequestMethod.POST)
	public ModelAndView verifyUser(@RequestParam (name="username") String username, @RequestParam(name="pass") String pass) {
		ModelAndView mav = new ModelAndView();
		
		Usuario user = usuarioService.login(username, pass);
		
		List<Movie> movie = movieService.findAll();
		
		//List<Movie> movie = movieService.findByEstado(true)
		
		
		System.out.println("QUE IMPRIMO " + user.getnUsuario());
		
		if(user != null) {
			if(user.getnUsuario().equals("Cliente")) {
				if(user.getEstadoUsuario().equals(true)) {
					if(user.getLoggedIn().equals(false)) {
						usuarioService.updateUser(true, user.getcUsuario());
						mav.addObject("MisDatos", user);
						mav.addObject("DatosPelicula", movie);
						mav.setViewName("Cliente/PaginaInicio");
					} else {
						mav.addObject("resultado", 0);
						mav.setViewName("main");
						System.out.println("Ya estas loggeado");
					}
				}else {
					mav.addObject("resultado", 1);
					mav.setViewName("main");
					System.out.println("Usuario Inactivo");
				}	
			}
			
			if(user.getnUsuario().equals("Administrador")){
				mav.setViewName("redirect:/todos");
			} 
		}	
		return mav;
	}
	
	@RequestMapping(value = "/inactivarUser", method=RequestMethod.POST)
	public ModelAndView updateUser(@RequestParam (name="cUsuario") Integer cUsuario, @RequestParam (name="motivo") String motivo) {
		ModelAndView mav =  new ModelAndView();
		Usuario user = usuarioService.findByCUsuario(cUsuario);
		
		if(user.getEstadoUsuario().equals(true)) {
			usuarioService.inactivateUser(false, motivo, cUsuario);
			mav.addObject("resul", 1);
			mav.setViewName("redirect:/todos");
		}
		if(user.getEstadoUsuario().equals(false)) {
			mav.addObject("resul", 0);
			mav.setViewName("redirect:/todos");
		}
		return mav;
	}
	
	@RequestMapping("/inactivar") 
	public ModelAndView inactivar(@RequestParam Integer cUsuario) {
		ModelAndView mav = new ModelAndView();
		Usuario user = usuarioService.findByCUsuario(cUsuario);
		mav.addObject("usuario", user.getcUsuario());
		mav.setViewName("inactivarCliente");
		return mav;
	}
	
	@RequestMapping("/inactivarMov") 
	public ModelAndView inactivarMov(@RequestParam Integer cMovie) {
		ModelAndView mav = new ModelAndView();
		Movie movie = movieService.findByCMovie(cMovie);
		mav.addObject("movie", movie.getcMovie());
		mav.setViewName("inactivarCliente");
		return mav;
	}
	
	
}
