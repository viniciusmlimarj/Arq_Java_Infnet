package br.com.vinicius.infnet.trabalho.model.test;

import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.infnet.trabalho.model.domain.Bebida;
import br.com.vinicius.infnet.trabalho.model.domain.Comida;
import br.com.vinicius.infnet.trabalho.model.domain.Produto;
import br.com.vinicius.infnet.trabalho.model.domain.Sobremesa;

public class ProdutoTeste {

	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<>();
		
		Bebida bebida = new Bebida("Coca cola", 5, 1);
		bebida.setGelada(true);
		bebida.setMarca("Coca cola");
		bebida.setTamanho(350);
		produtos.add(bebida);

		Comida comida = new Comida("Coxinha", 7, 2);
		produtos.add(comida);
		
		Sobremesa sobremesa = new Sobremesa("Pudim", 6, 3);
		produtos.add(sobremesa);
		
		for (Produto p : produtos) {
			System.out.println(p);
		}
	}
}