package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Seguro;
import br.com.spring.locacaoveiculos.repository.SeguroRepository;
import br.com.spring.locacaoveiculos.service.SeguroService;

@Service
public class SeguroServiceImpl implements SeguroService{

	@Autowired
	SeguroRepository seguroRepository;
	
	@Override
	public List<Seguro> buscarTodos() {
		return seguroRepository.findAll();
	}

	@Override
	public Optional<Seguro> buscarPorId(Long id) {
		return seguroRepository.findById(id);
	}

}
