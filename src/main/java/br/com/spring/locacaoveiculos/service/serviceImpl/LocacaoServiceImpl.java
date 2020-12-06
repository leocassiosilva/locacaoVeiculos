package br.com.spring.locacaoveiculos.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Locacao;
import br.com.spring.locacaoveiculos.repository.LocacaoRepository;
import br.com.spring.locacaoveiculos.service.LocacaoService;

@Service
public class LocacaoServiceImpl implements LocacaoService{

	@Autowired
	LocacaoRepository locacaoRepository;
	
	@Override
	public Locacao save(Locacao locacao) {
		return locacaoRepository.save(locacao);
	}

}
