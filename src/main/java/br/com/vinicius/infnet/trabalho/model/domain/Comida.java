package br.com.vinicius.infnet.trabalho.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TComida")
public class Comida extends Produto {

	public Comida(String nome, float valor, int codigo) {
		super(nome, valor, codigo);
	}

	@Override
	public float calcularValorVenda() {
		return 0;
	}	
}