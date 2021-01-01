package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.locacaoveiculos.model.Marca;
import br.com.spring.locacaoveiculos.service.MarcaService;
@Service
@Transactional(readOnly = false)
public class MarcaServiceImpl implements MarcaService{
	
	@Override
	public List<Marca> buscarTodos() {
		return null;
	}


	@Override
	@Transactional(readOnly = true)
	public List<Marca> buscarMarcaPeloTipo(Long id) {
		return null;
	}


	@Override
	@Transactional(readOnly = true)
	public Optional<Marca> buscarPorId(Long id) {
		return null;
	}
}
