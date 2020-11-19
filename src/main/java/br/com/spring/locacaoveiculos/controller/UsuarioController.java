package br.com.spring.locacaoveiculos.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.spring.locacaoveiculos.model.Usuario;
import br.com.spring.locacaoveiculos.repository.UsuarioRepository;
import br.com.spring.locacaoveiculos.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioRepository ur;
	
	
	@RequestMapping(value = "/newUsuario", method = RequestMethod.GET)
	public String form() {
		return "usuario/cadastroUsuario";
	}

	@RequestMapping(value = "/newUsuario", method = RequestMethod.POST)
	public String saveUsuario(@Valid Usuario user, BindingResult result, RedirectAttributes attributes) {
		Usuario usuario = ur.findByEmail(user.getEmail());
		
		
		if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newUsuario";
        }
		
		if (usuario != null) {
			attributes.addFlashAttribute("E-mail já cadastrado!");
			throw new UsernameNotFoundException("E-mail já cadastrado!");
		}
		
		
		user.setSenha(this.passwordEncoder.encode(user.getPassword()));
        user.setData(LocalDate.now());
		usuarioService.save(user);
		System.out.println("user cadastrado com sucesso");
		return "redirect:/home";
	}

	@RequestMapping(value = "/painel", method = RequestMethod.GET)
	public String painel() {
		return "usuario/painel";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "usuario/login";
	}

	@PostMapping("/login_success_handler")
	public String loginSuccessHandler() {
		System.out.println("Logging user login success...");

		return "redirect:/painel";
	}
}
