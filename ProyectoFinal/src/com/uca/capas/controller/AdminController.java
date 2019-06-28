package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	//Método para el delete
	@RequestMapping("/ElimUsu")//Pongo la ruta que llamará este mappeo
	public ModelAndView elimninar(@RequestParam ("cUsuario") Integer cUsuario) { //Recibo el id del usuario a eliminar
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
	
	
}
