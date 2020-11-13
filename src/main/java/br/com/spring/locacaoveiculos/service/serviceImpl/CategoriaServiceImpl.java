package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Categoria;
import br.com.spring.locacaoveiculos.repository.CategoriaRepository;
import br.com.spring.locacaoveiculos.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> buscarTodos() {
		return categoriaRepository.findAll();
	}

	@Override
	public Optional<Categoria> buscarPorId(Long id) {
		return categoriaRepository.findById(id);
	}

	

}
