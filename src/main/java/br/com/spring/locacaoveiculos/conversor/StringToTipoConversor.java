package br.com.spring.locacaoveiculos.conversor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.spring.locacaoveiculos.model.Tipo;
import br.com.spring.locacaoveiculos.service.TipoService;

@Component
public class StringToTipoConversor implements Converter<String, Tipo>{

	@Autowired
	private TipoService service;
	
	@Override
	public Tipo convert(String text) {
		
		if (text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		 Optional<Tipo> tipo = service.buscarPorId(id); 
		 //System.out.println(optUser.get());
		return tipo.get();
	}

}


