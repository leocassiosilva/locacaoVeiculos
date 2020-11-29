package br.com.spring.locacaoveiculos.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.locacaoveiculos.model.Local;
import br.com.spring.locacaoveiculos.repository.LocalRepository;
import br.com.spring.locacaoveiculos.service.LocalService;

@Service
public class LocalServiceImpl implements LocalService{

	@Autowired
	LocalRepository localRepository;

	@Override
	public List<Local> buscarTodos() {
		return localRepository.findAll();
	} 
}
