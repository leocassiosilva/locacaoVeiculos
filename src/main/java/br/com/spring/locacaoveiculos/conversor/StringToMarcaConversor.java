package br.com.spring.locacaoveiculos.conversor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.spring.locacaoveiculos.model.Marca;
import br.com.spring.locacaoveiculos.service.MarcaService;

@Component
public class StringToMarcaConversor implements Converter<String, Marca>{

	@Autowired
	private MarcaService service; 
	
	@Override
	public Marca convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		Optional<Marca> marca = service.buscarPorId(id);
		return marca.get();
	}

}
