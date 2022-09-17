/*
 * 1. Crie uma classe Java de entidade. Exemplo: Filme (id, titulo, sinopse, diretor).
 *       - OBS: A classe não precisa implementar a interface java.io.Serializable.
 * */

package atividade05.model;

import java.time.Year;
import java.util.Collection;
import java.util.List;

public class Livro {

	private String titulo;
	private Collection<String> autores;
	private String idiomaOriginal;
	private String editora;
	private Year anoDaEdicao;

	public Livro(String titulo, List<String> autores,
			String idiomaOriginal, String editora, Year anoDaEdicao) {
		this.titulo = titulo;
		this.autores = autores;
		this.idiomaOriginal = idiomaOriginal;
		this.editora = editora;
		this.anoDaEdicao = anoDaEdicao;
	}

	public String getTitulo() {
		return titulo;
	}

	public Collection<String> getAutores() {
		return autores;
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
