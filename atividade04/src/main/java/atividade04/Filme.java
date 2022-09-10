/*
 * 1. Crie uma classe Java de entidade. Exemplo: Filme (id, titulo, sinopse, diretor).
 *       - OBS: A classe não precisa implementar a interface java.io.Serializable.
 * */

package atividade04;

public class Filme {

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
