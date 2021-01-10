package br.com.spring.locacaoveiculos.conversor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.spring.locacaoveiculos.model.Opcionais;
import br.com.spring.locacaoveiculos.service.OpcionaisService;

@Component
public class StringToOpcionaisConversor implements Converter<String, Opcionais>{

	@Autowired
	private OpcionaisService opcionaisService;
	
	@Override
	public Opcionais convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		 Optional<Opcionais> opcionais = opcionaisService.buscarPeloId(id); 
		return opcionais.get();
	}

}
