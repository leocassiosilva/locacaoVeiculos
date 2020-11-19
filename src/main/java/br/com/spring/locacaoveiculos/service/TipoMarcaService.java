package br.com.spring.locacaoveiculos.service;

import java.util.Optional;

import br.com.spring.locacaoveiculos.model.TipoMarca;

public interface TipoMarcaService {
	Optional<TipoMarca> buscarPorId(Long id);
	TipoMarca buscarTipoMarca(Long id, Long id_marca);
}
