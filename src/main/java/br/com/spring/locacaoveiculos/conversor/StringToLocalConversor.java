package br.com.spring.locacaoveiculos.conversor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.spring.locacaoveiculos.model.Local;
import br.com.spring.locacaoveiculos.service.LocalService;


@Component
public class StringToLocalConversor implements Converter<String, Local>{

	@Autowired
	private LocalService service; 
	
	@Override
	public Local convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		Optional<Local> local = service.buscarPorId(id);
		return local.get();
	}
	
}
