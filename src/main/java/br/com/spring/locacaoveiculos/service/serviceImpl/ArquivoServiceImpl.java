package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Arquivo;
import br.com.spring.locacaoveiculos.repository.ArquivoRepository;
import br.com.spring.locacaoveiculos.service.ArquivoService;
@Service
public class ArquivoServiceImpl implements ArquivoService{

	@Autowired
	ArquivoRepository arquivoRepository;
	
	@Override
	public Arquivo save(Arquivo arquivo) {
		return arquivoRepository.save(arquivo);
	}

	@Override
	public List<Arquivo> buscarTodos() {
		return arquivoRepository.findAll();
	}
	

}
