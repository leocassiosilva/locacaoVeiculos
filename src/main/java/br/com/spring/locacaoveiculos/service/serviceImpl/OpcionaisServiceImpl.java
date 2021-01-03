package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Opcionais;
import br.com.spring.locacaoveiculos.repository.OpcionaisRepository;
import br.com.spring.locacaoveiculos.service.OpcionaisService;

@Service
public class OpcionaisServiceImpl implements OpcionaisService{

	@Autowired
	OpcionaisRepository opcionaisRepository;
	
	@Override
	public List<Opcionais> buscarTodos() {
		return opcionaisRepository.findAll();
	}

	@Override
	public Optional<Opcionais> buscarPorId(Long id) {
		return opcionaisRepository.findById(id);
	}

	@Override
	public Opcionais buscarOpcionais(Long id) {
		return opcionaisRepository.buscarOpcionais(id);
	}

}
