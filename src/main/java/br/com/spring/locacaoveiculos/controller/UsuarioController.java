package br.com.spring.locacaoveiculos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public String cadastrando(Usuario usuario) {
		usuarioService.save(usuario);
		return "usuario/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Usuario usuario) {
		return "usuario/login";
	}

	@PostMapping("/logar")
	public ModelAndView logar(Usuario usuario, HttpSession session) {
		Usuario userLogado = usuarioService.login(usuario);
		if (userLogado == null) {
			return new ModelAndView("redirect:login").addObject("Erro", "E-mail e/ou senha incorreto");
		}

		session.setAttribute("iduser", userLogado.getId());
		session.setAttribute("userlogado", userLogado.getEmail());
		ModelAndView mv = new ModelAndView("redirect:/painel").addObject("logado", session.getAttribute("userlogado"));

		return mv;
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	@RequestMapping(value = "/painel", method = RequestMethod.GET)
	public String painel(Usuario usuario) {
		return "usuario/painel";
	}
}
