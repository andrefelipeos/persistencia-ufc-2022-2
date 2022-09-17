/*
 * 1. Crie uma classe Java de entidade. Exemplo: Filme (id, titulo, sinopse, diretor).
 *       - OBS: A classe não precisa implementar a interface java.io.Serializable.
 * */

package atividade05.model;

public class Livro {

	private String titulo;
	private String autor;
	private String idiomaOriginal;
	private String editora;
	private int anoDaEdicao;

	public Livro() {
		super();
	}

	public Livro(String titulo, String autor,
			String idiomaOriginal, String editora, int anoDaEdicao) {
		this.titulo = titulo;
		this.autor = autor;
		this.idiomaOriginal = idiomaOriginal;
		this.editora = editora;
		this.anoDaEdicao = anoDaEdicao;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getIdiomaOriginal() {
		return idiomaOriginal;
	}

	public String getEditora() {
		return editora;
	}

	public int getAnoDaEdicao() {
		return anoDaEdicao;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.titulo);
		sb.append(", escrito originalmente em ");
		sb.append(this.idiomaOriginal.toLowerCase());
		sb.append(" por ");
		sb.append(this.autor);
		sb.append(".");
		sb.append("\nEdição da editora ");
		sb.append(this.editora);
		sb.append(", lançada em ");
		sb.append(this.anoDaEdicao);
		sb.append(".");
		return sb.toString();
	}

}
