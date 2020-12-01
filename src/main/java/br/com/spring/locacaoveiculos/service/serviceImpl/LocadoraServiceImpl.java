package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.spring.locacaoveiculos.model.Locadora;
import br.com.spring.locacaoveiculos.repository.LocadoraRepository;
import br.com.spring.locacaoveiculos.service.LocadoraService;

public class LocadoraServiceImpl implements LocadoraService{

	@Autowired
	LocadoraRepository locadoraRepository;
	
	@Override
	public List<Locadora> buscarTodos() {
		return locadoraRepository.findAll();
	}

	@Override
	public Optional<Locadora> buscarPorId(Long id) {
		return locadoraRepository.findById(id);
	}

}
