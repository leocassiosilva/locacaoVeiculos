package br.com.spring.locacaoveiculos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {

	/* Para chamar o metodo da pagina inicial */
	@GetMapping("/home")
	public ModelAndView home(HttpSession session, ModelMap model) {
		
		Long usuarioLogado =  (Long) session.getAttribute("id_usuario");
		System.out.println(usuarioLogado);
		model.addAttribute("id_usuario",usuarioLogado);
		ModelAndView mv = new ModelAndView("/home");
		
		return mv;
	}
}
