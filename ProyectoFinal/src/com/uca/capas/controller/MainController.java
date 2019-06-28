package com.uca.capas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Usuario;
import com.uca.capas.service.UsuarioService;

@Controller
public class MainController {

	@Autowired
	UsuarioService usuarioService;

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
		
		System.out.println("QUE IMPRIMO " + user.getnUsuario());
		
		if(user != null) {
			if(user.getnUsuario().equals("Cliente")) {
				if(user.getEstadoUsuario().equals(true)) {
					if(user.getLoggedIn().equals(false)) {
						usuarioService.updateUser(true, user.getcUsuario());
						mav.setViewName("redirect:/todos");
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
}
