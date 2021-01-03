package br.com.spring.locacaoveiculos.conversor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.spring.locacaoveiculos.model.Categoria;
import br.com.spring.locacaoveiculos.service.CategoriaService;

@Component
public class StringToCategoriaConversor implements Converter<String, Categoria>{

	@Autowired
	CategoriaService categoriaService;
	
	@Override
	public Categoria convert(String text) {

		if (text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		Optional<Categoria> categoria = categoriaService.buscarPorId(id);
		return categoria.get();
	}

}
