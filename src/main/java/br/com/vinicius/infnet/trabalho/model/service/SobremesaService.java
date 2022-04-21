package br.com.vinicius.infnet.trabalho.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vinicius.infnet.trabalho.model.domain.Sobremesa;
import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.repository.SobremesaRepository;

@Service
public class SobremesaService {

	@Autowired
	private SobremesaRepository sobremesaRepository;
	
	public Collection<Sobremesa> obterLista(Usuario usuario){
		return (Collection<Sobremesa>) sobremesaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public void incluir(Sobremesa sobremesa) {
		sobremesaRepository.save(sobremesa);
	}
	
	public void excluir(Integer id) {
		sobremesaRepository.deleteById(id);
	}
}