package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Veiculo;
import br.com.spring.locacaoveiculos.repository.VeiculoRepository;
import br.com.spring.locacaoveiculos.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService{

	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Override
	public Veiculo save(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	public List<Veiculo> buscarTodos() {
		return veiculoRepository.buscarTodos();
		
	}

	@Override
	public Optional<Veiculo> buscarPeloId(Long id) {
		return veiculoRepository.buscarPeloId(id);
	}

	@Override
	public Veiculo buscarVeiculo(Long id) {
		return veiculoRepository.buscarVeiculo(id);
	}

}
