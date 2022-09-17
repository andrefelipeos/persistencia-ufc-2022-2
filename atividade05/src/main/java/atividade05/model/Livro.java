/*
 * 1. Crie uma classe Java de entidade. Exemplo: Filme (id, titulo, sinopse, diretor).
 *       - OBS: A classe não precisa implementar a interface java.io.Serializable.
 * */

package atividade05.model;

import java.time.Year;
import java.util.Collection;

public class Livro {

	private String titulo;
	@SuppressWarnings("unused")
	private String subtitulo;
	@SuppressWarnings("unused")
	private String tituloOriginal;
	@SuppressWarnings("unused")
	private String subtituloOriginal;
	private Collection<String> autores;
	@SuppressWarnings("unused")
	private Collection<String> tradutores;
	private String idiomaOriginal;
	@SuppressWarnings("unused")
	private String idiomaDaTraducao;
	private String editora;
	@SuppressWarnings("unused")
	private Year anoDaObra;
	private Year anoDaEdicao;

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
