package br.com.spring.locacaoveiculos.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.spring.locacaoveiculos.model.Usuario;
import br.com.spring.locacaoveiculos.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	
	@RequestMapping(value = "/newUsuario", method = RequestMethod.GET)
	public String form(Usuario usuario) {
		return "usuario/cadastroUsuario";
	}

	

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String painel(Usuario usuario) {
		usuarioService.save(usuario);
		return "usuario/painel";
	}


	@PostMapping("/login_success_handler")
	public String loginSuccessHandler() {
		System.out.println("Logging user login success...");
		return "redirect:/painel";
	}
	
	
}
