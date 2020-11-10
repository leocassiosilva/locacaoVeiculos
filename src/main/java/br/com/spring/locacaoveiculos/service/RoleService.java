package br.com.spring.locacaoveiculos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.spring.locacaoveiculos.repository.RoleRepository;
import br.com.spring.locacaoveiculos.model.Role;
public class RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public List<Role> buscarTodos(){
		return repository.findAll();
	}
}
