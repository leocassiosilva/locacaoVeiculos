package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Opcionais;
import br.com.spring.locacaoveiculos.service.OpcionaisService;

@Service
public class OpcionaisServiceImpl implements OpcionaisService{

	@Override
	public List<Opcionais> buscarTodos() {
		return null;
	}

	@Override
	public Optional<Opcionais> buscarPorId(Long id) {
		return null;
	}

	@Override
	public Opcionais buscarOpcionais(Long id) {
		return null;
	}

}
