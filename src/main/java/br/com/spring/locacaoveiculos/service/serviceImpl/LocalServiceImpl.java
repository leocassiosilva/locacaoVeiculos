package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Local;
import br.com.spring.locacaoveiculos.service.LocalService;

@Service
public class LocalServiceImpl implements LocalService{

	
	@Override
	public List<Local> buscarTodos() {
		return null;
	}

	@Override
	public Optional<Local> buscarPorId(Long id) {
		return null;
	}

	@Override
	public Local buscarLocal(Long id) {
		return null;
	} 
}
