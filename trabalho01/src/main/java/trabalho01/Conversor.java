/*
 * 3. Crie uma classe Java que recebe via linha de comando o nome de um arquivo
 * qualquer em formato JSON e o converte para os formatos CSV e XML.
 * */

package trabalho01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Conversor {

	public static void main(String[] args) throws IOException {
		String localDoArquivo;

		if (args.length == 0) {
			System.out.println("Passe o caminho para um arquivo como parâmentro!");
			return;
		} else {
			localDoArquivo = args[0];
		}
		
		String json = new String(Files.readAllBytes(Paths.get(localDoArquivo)));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(json);
		
		ObjectMapper xmlMapper = new XmlMapper();
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
		String xml = xmlMapper.writeValueAsString(jsonNode);
		System.out.println(xml);
	}

}
