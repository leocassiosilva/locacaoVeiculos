package br.com.spring.locacaoveiculos.conversor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.spring.locacaoveiculos.model.Seguro;
import br.com.spring.locacaoveiculos.service.SeguroService;

@Component
public class StringToSeguroConversor implements Converter<String, Seguro>{

	@Autowired
	private SeguroService seguroService;
	
	@Override
	public Seguro convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		 Optional<Seguro> seguro = seguroService.buscarPorId(id); 
		return seguro.get();
	}

}
