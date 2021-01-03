package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Categoria;
import br.com.spring.locacaoveiculos.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	
	@Override
	public List<Categoria> buscarTodos() {
		return null;
	}

	@Override
	public Optional<Categoria> buscarPorId(Long id) {
		return null;
	}

	

}
