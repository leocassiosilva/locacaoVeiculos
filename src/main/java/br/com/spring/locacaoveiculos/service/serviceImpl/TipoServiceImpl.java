package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.locacaoveiculos.model.Tipo;
import br.com.spring.locacaoveiculos.repository.TipoRepository;
import br.com.spring.locacaoveiculos.service.TipoService;

@Service
@Transactional(readOnly = false)
public class TipoServiceImpl implements TipoService{

	@Autowired
	private TipoRepository tipoRepository;
	
	@Override
	public List<Tipo> buscarTodosTipos() {
		return tipoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Tipo> buscarPorId(Long id) {
		return tipoRepository.findById(id);
	}

}
