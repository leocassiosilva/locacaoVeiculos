package br.com.spring.locacaoveiculos.conversor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.spring.locacaoveiculos.model.TipoMarca;
import br.com.spring.locacaoveiculos.service.TipoMarcaService;

@Component
public class StringToTipoMarcaConversor implements Converter<String, TipoMarca>{

	
	@Autowired
	private TipoMarcaService tipoMarcaService;
	
	@Override
	public TipoMarca convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		 Optional<TipoMarca> tipoMarca = tipoMarcaService.buscarPorId(id); 
		return tipoMarca.get();
	}

}
