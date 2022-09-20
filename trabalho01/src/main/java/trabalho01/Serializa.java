package trabalho01;

import java.io.File;
import java.io.IOException;

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
		Album novoAlbum = new Album();
		novoAlbum.setTitulo("DawnFM");
		novoAlbum.setArtista("The Weeknd");
		novoAlbum.setGenero("Dance-pop, synth-pop");
		novoAlbum.setGravadora("XO e Republic Records");
		novoAlbum.setAnoDeLancamento(2022);
		return novoAlbum;
	}

}
