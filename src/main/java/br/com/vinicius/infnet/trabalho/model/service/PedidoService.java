package br.com.vinicius.infnet.trabalho.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vinicius.infnet.trabalho.model.domain.Pedido;
import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public Collection<Pedido> obterLista(Usuario usuario){
		return pedidoRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "data"));
	}
	
	public Collection<Pedido> obterLista(){
		return pedidoRepository.findAll(Sort.by(Sort.Direction.ASC, "data"));
	}
	
	public void incluir(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public void excluir(Integer id) {
		pedidoRepository.deleteById(id);
	}
	
	public Pedido obterPorId(Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}
}