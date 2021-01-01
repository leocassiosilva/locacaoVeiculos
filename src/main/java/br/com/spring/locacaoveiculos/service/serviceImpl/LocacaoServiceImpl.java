package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Locacao;
import br.com.spring.locacaoveiculos.service.LocacaoService;

@Service
public class LocacaoServiceImpl implements LocacaoService{

	
	@Override
	public Locacao save(Locacao locacao) {
		return null;
	}

	@Override
	public List<Locacao> buscarPeloUsuario(String email) {
		return null;
	}

	@Override
	public List<Locacao> buscarPeloId(Long id) {
		return null;
	}

}
