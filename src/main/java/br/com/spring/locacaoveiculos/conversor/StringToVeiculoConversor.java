package br.com.spring.locacaoveiculos.conversor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.spring.locacaoveiculos.model.Veiculo;
import br.com.spring.locacaoveiculos.service.VeiculoService;

@Component
public class StringToVeiculoConversor implements Converter<String, Veiculo>{

	@Autowired
	private VeiculoService veiculoService;
	
	@Override
	public Veiculo convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		 Optional<Veiculo> veiculo = veiculoService.buscarPeloId(id); 
		return veiculo.get();
	}

}
