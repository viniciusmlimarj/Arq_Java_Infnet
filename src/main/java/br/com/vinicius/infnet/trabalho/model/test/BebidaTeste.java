package br.com.vinicius.infnet.trabalho.model.test;

import br.com.vinicius.infnet.trabalho.model.domain.Bebida;

public class BebidaTeste {

	public static void main(String[] args) {
		Bebida b1 = new Bebida("Coca cola", 10, 987);
		b1.setGelada(true);
		b1.setMarca("coca cola");
		b1.setTamanho(500);
		System.out.println(b1);

		Bebida b2 = new Bebida("fanta", 10, 987);
		b2.setGelada(true);
		b2.setMarca("coca cola");
		b2.setTamanho(500);
		System.out.println("Valor de venda = " + b2.calcularValorVenda());
	}
}