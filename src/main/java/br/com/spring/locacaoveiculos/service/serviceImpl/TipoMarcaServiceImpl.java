package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.locacaoveiculos.model.TipoMarca;
import br.com.spring.locacaoveiculos.repository.TipoMarcaRepository;
import br.com.spring.locacaoveiculos.service.TipoMarcaService;

@Service
@Transactional(readOnly = false)
public class TipoMarcaServiceImpl implements TipoMarcaService{

	@Autowired
	private TipoMarcaRepository tipoMarcaRepository; 
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoMarca> buscarTipoMarca(Long id, Long id_marca) {
		return tipoMarcaRepository.buscarTipoMarca(id, id_marca);
	}

	@Override
	public Optional<TipoMarca> buscarPorId(Long id) {
		return tipoMarcaRepository.findById(id);
	}

}
