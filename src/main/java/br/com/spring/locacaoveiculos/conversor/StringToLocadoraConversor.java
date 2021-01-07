package br.com.spring.locacaoveiculos.conversor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.spring.locacaoveiculos.model.Locadora;
import br.com.spring.locacaoveiculos.service.LocadoraService;

@Component
public class StringToLocadoraConversor implements Converter<String, Locadora>{
	@Autowired
	private LocadoraService service; 
	
	@Override
	public Locadora convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		Optional<Locadora> locadora = service.buscar(id);
		return locadora.get();
	}
}
