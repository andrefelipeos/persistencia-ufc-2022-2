/*
 * 1. Defina uma entidade principal com pelo menos 5 atributos e relacionada a
 * um domínio de problema. Crie também uma classe Java para representá-la. A
 * entidade deve estar relacionada a algo que você gosta bastante como: hobbie,
 * esporte, pet, alimentação, educação, música, filmes, séries, redes sociais, etc.
 * */

package trabalho01.model;

public class Album {

	private String titulo;
	private String artista;
	private String genero;
	private String gravadora;
	private int anoDeLancamento;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getGravadora() {
		return gravadora;
	}

	public void setGravadora(String gravadora) {
		this.gravadora = gravadora;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

}
