/*
 * 2. Crie uma classe Java para cadastrar dados relacionados à entidade
 * definida na questão 1. A classe deve receber dados via teclado e os salvar
 *  em um arquivo JSON.
 * */

package trabalho01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import trabalho01.model.Album;

public class Serializa {

	public static void main(String[] args) throws Exception {
		String localDoArquivo = "album.json";

		Album album = Serializa.defineAlbumPeloTeclado();

		Serializa.salvaComoJSON(localDoArquivo, album);
	}

	private static void salvaComoJSON(String localDoArquivo, Album album)
			throws IOException, StreamWriteException, DatabindException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.writeValue(new File(localDoArquivo), album);
	}

	private static Album defineAlbumPeloTeclado() {
		Scanner teclado = new Scanner(System.in);

		String titulo;
		String artista;
		String genero;
		String gravadora;
		int anoDeLancamento;

		System.out.print("Título: ");
		titulo = teclado.nextLine();
		System.out.print("Artista: ");
		artista = teclado.nextLine();
		System.out.print("Gênero: ");
		genero = teclado.nextLine();
		System.out.print("Gravadora: ");
		gravadora = teclado.nextLine();
		System.out.print("Ano de lançamento: ");
		anoDeLancamento = teclado.nextInt();

		Album novoAlbum = new Album();
		novoAlbum.setTitulo(titulo);
		novoAlbum.setArtista(artista);
		novoAlbum.setGenero(genero);
		novoAlbum.setGravadora(gravadora);
		novoAlbum.setAnoDeLancamento(anoDeLancamento);

		teclado.close();

		return novoAlbum;
	}

	@SuppressWarnings("unused")
	private static Album defineAlbumSemInteracao() {
		Album novoAlbum = new Album();
		novoAlbum.setTitulo("DawnFM");
		novoAlbum.setArtista("The Weeknd");
		novoAlbum.setGenero("Dance-pop, synth-pop");
		novoAlbum.setGravadora("XO e Republic Records");
		novoAlbum.setAnoDeLancamento(2022);
		return novoAlbum;
	}

}
