package br.com.vinicius.infnet.trabalho.model.test;

import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.infnet.trabalho.model.domain.Bebida;
import br.com.vinicius.infnet.trabalho.model.domain.Pedido;
import br.com.vinicius.infnet.trabalho.model.domain.Produto;
import br.com.vinicius.infnet.trabalho.model.domain.Solicitante;

public class PedidoTeste {

	public static void main(String[] args) {
		
		Bebida b1 = new Bebida("coca cola", 5, 1);
		b1.setGelada(true);
		b1.setMarca("coca cola");
		b1.setTamanho(500);
		
		Bebida b2 = new Bebida("coca cola", 5, 1);
		b2.setGelada(true);
		b2.setMarca("coca cola");
		b2.setTamanho(500);

		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(b1);
		produtos.add(b2);
		
		Pedido pedido = new Pedido();
		pedido.setDescricao("Duas cocas");
		pedido.setProdutos(produtos);
		
		Solicitante solicitante = new Solicitante("Vinicius Mello Lima", "121321321", "vinicius.lima@al.infnet.edu.br");
		pedido.setSolicitante(solicitante);
		pedido.setWeb(false);
		System.out.println(pedido);
	}
}
