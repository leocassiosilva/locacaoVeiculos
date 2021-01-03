package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Locadora;
import br.com.spring.locacaoveiculos.service.LocadoraService;
@Service
public class LocadoraServiceImpl implements LocadoraService{

	
	@Override
	public List<Locadora> buscarTodos() {
		return null;
	}

	@Override
	public Optional<Locadora> buscarPorId(Long id) {
		return null;
	}

	@Override
	public Locadora buscarLocadora(Long id) {
		return null;
	}

}
