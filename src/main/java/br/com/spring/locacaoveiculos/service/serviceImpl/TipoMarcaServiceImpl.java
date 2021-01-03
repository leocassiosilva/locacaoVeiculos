package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.locacaoveiculos.model.TipoMarca;
import br.com.spring.locacaoveiculos.service.TipoMarcaService;

@Service
@Transactional(readOnly = false)
public class TipoMarcaServiceImpl implements TipoMarcaService{


	@Override
	@Transactional(readOnly = true)
	public TipoMarca buscarTipoMarca(Long id, Long id_marca) {
		return null;
	}

	@Override
	public Optional<TipoMarca> buscarPorId(Long id) {
		return null;
	}

}
