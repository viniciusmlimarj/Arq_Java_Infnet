package br.com.vinicius.infnet.trabalho.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBebida")
public class Bebida extends Produto {
	
	private boolean gelada;
	private float tamanho;
	private String marca;

	public Bebida() {}
	
	public Bebida(String nome, float valor, int codigo) {
		super(nome, valor, codigo);
	}

	@Override
	public float calcularValorVenda() {
		return getValor() + tamanho * 0.10f;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append(";");
		sb.append(gelada);
		sb.append(";");
		sb.append(tamanho);
		sb.append(";");
		sb.append(marca);
		
		return sb.toString();
	}

	public boolean isGelada() {
		return gelada;
	}

	public void setGelada(boolean gelada) {
		this.gelada = gelada;
	}

	public float getTamanho() {
		return tamanho;
	}

	public void setTamanho(float tamanho) {
		this.tamanho = tamanho;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}