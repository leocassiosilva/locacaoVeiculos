package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Seguro;
import br.com.spring.locacaoveiculos.service.SeguroService;

@Service
public class SeguroServiceImpl implements SeguroService{

	
	@Override
	public List<Seguro> buscarTodos() {
		return null;
	}

	@Override
	public Optional<Seguro> buscarPorId(Long id) {
		return null;
	}

	@Override
	public Seguro buscarSeguro(Long id) {
		return null;
	}

}
