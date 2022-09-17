/*
 * 1. Crie uma classe Java de entidade. Exemplo: Filme (id, titulo, sinopse, diretor).
 *       - OBS: A classe não precisa implementar a interface java.io.Serializable.
 * */

package atividade05.model;

import java.time.Year;

public class Livro {

	private String titulo;
	private String autor;
	private String idiomaOriginal;
	private String editora;
	private Year anoDaEdicao;

	public Livro(String titulo, String autor,
			String idiomaOriginal, String editora, Year anoDaEdicao) {
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

	public Year getAnoDaEdicao() {
		return anoDaEdicao;
	}

}
