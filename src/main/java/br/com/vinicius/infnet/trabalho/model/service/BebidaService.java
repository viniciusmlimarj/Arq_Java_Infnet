package br.com.vinicius.infnet.trabalho.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vinicius.infnet.trabalho.model.domain.Bebida;
import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.repository.BebidaRepository;

@Service
public class BebidaService {

	@Autowired
	private BebidaRepository bebidaRepository;
	
	public Collection<Bebida> obterLista(Usuario usuario){
		return (Collection<Bebida>) bebidaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "marca"));
	}

	public void incluir(Bebida bebida) {
		bebidaRepository.save(bebida);
	}
	
	public void excluir(Integer id) {
		bebidaRepository.deleteById(id);
	}
}