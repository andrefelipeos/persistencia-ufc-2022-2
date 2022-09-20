package trabalho01;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import trabalho01.model.Album;

public class Serializa {

	public static void main(String[] args) throws Exception {
		String localDoArquivo = "album.json";

		Album album = new Album();
		album.setTitulo("DawnFM");
		album.setArtista("The Weeknd");
		album.setGenero("Dance-pop, synth-pop");
		album.setGravadora("XO e Republic Records");
		album.setAnoDeLancamento(2022);

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.writeValue(new File(localDoArquivo), album);
	}

}
