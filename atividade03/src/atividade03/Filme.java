package atividade03;

import java.io.Serializable;

public class Filme implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String diretor;
	private int ano;

	public Filme(String nome, String diretor, int ano) {
		this.nome = nome;
		this.diretor = diretor;
		this.ano = ano;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(" (");
		sb.append(this.ano);
		sb.append("), dirigido por ");
		sb.append(this.diretor);
		sb.append(".");
		return sb.toString();
	}

}
