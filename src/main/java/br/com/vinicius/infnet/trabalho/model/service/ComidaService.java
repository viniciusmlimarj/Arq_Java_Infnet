package br.com.vinicius.infnet.trabalho.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vinicius.infnet.trabalho.model.domain.Comida;
import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.repository.ComidaRepository;

@Service
public class ComidaService {

	@Autowired
	private ComidaRepository comidaRepository;
	
	public Collection<Comida> obterLista(Usuario usuario){
		return (Collection<Comida>) comidaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public void incluir(Comida comida) {
		comidaRepository.save(comida);
	}
	
	public void excluir(Integer id) {
		comidaRepository.deleteById(id);
	}
}