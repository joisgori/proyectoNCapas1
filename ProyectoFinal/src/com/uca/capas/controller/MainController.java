package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.UsuarioRepository;

@Controller
public class MainController {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}	
	
	@RequestMapping(value= "/verifyLogin", method=RequestMethod.POST)
	public ModelAndView verifyUser(@RequestParam (name="username") String username, @RequestParam(name="pass") String pass) {
		ModelAndView mav = new ModelAndView();
		
		Usuario user = usuarioRepository.findByUserAndPass(username, pass);
		
		System.out.println("QUE IMPRIMO " + user.getnUsuario());
		
		if(user.getnUsuario().equals("Cliente")) {
			mav.setViewName("redirect:/todos");
		}
		else if(user.getnUsuario() == "Administrador"){
			mav.setViewName("formPelis");
		}else {
			System.out.println("Algo");
		}
	
		/*if(user.getUser() == "Administrador") {
			mav.setViewName("redirect:/todos");
		}else {
			mav.setViewName("formPelis");
		}*/
		
		return mav;
	}
	
	
	
	
}
