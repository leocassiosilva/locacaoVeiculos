package br.com.spring.locacaoveiculos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public ModelAndView logar(Usuario usuario, HttpSession session, ModelMap model) {
		Usuario usuarioLogado = usuarioService.login(usuario);
		if (usuarioLogado == null) {
			
			return new ModelAndView("redirect:login").addObject("menssgem", "E-mail e/ou senha incorreto");
		}

		session.setAttribute("id_usuario", usuarioLogado.getId());
		session.setAttribute("email_usuario", usuarioLogado.getEmail());
		session.setAttribute("token",usuarioLogado.getTokenUser());
		System.out.println(usuarioLogado.getTokenUser());
		session.setAttribute("nome",usuarioLogado.getNome());
		
		System.out.println(usuarioLogado.getTokenUser());
		ModelAndView mv = new ModelAndView("redirect:/home").addObject("logado", session.getAttribute("email_usuario"));

		return mv;
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}

	@RequestMapping(value = "/painel", method = RequestMethod.GET)
	public String painel(Usuario usuario) {
		return "usuario/painel";
	}
}
