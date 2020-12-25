package br.com.spring.locacaoveiculos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ImplementsUserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

	private static final String[] AUTH_LIST = { "/", "/home", "/locacaos/veiculo/{id}", "/getUsuario/{email}",
			"/locacaos/locais", "/locacaos/pagar", "/locacaos/confirmar", "/newUsuario", "/veiculos/getVeiculo/{id}",
			"/veiculos/getVeiculoMarca/{id}&{id_marca}", "/veiculos/getMarcas", "/veiculos/salvar", "/veiculos/listar",
			"/veiculos/buscar", "/veiculos/newVeiculo", "/veiculos/getTipo" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(AUTH_LIST).permitAll().anyRequest().authenticated().and()
				.formLogin().loginPage("/login").permitAll().successForwardUrl("/login_success_handler").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/bootstrap/**", "/img/**", "/imagens/**", "/js/**", "/css/**");
//	        web.ignoring().antMatchers("/bootstrap/**", "/style/**");
	}

}