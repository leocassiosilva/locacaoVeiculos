package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.locacaoveiculos.model.Marca;
import br.com.spring.locacaoveiculos.repository.MarcaRepository;
import br.com.spring.locacaoveiculos.service.MarcaService;
@Service
@Transactional(readOnly = false)
public class MarcaServiceImpl implements MarcaService{
	
	@Autowired
	MarcaRepository marcaRepository;
	

	@Override
	public List<Marca> buscarTodos() {
		return marcaRepository.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public List<Marca> buscarMarcaPeloTipo(Long id) {
		return marcaRepository.buscarMarcaPeloTipo(id);
	}


	@Override
	@Transactional(readOnly = true)
	public Optional<Marca> buscarPorId(Long id) {
		return marcaRepository.findById(id);
	}
}
