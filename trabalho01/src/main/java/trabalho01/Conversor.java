/*
 * 3. Crie uma classe Java que recebe via linha de comando o nome de um arquivo
 * qualquer em formato JSON e o converte para os formatos CSV e XML.
 * */

package trabalho01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;
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
		JsonNode jsonNode = (new ObjectMapper()).readTree(json);

		/* Converte JSON para XML */
		(new XmlMapper()).enable(SerializationFeature.INDENT_OUTPUT)
			.writeValue(new File(localDoArquivo + ".xml"), jsonNode);

		/* Converte JSON para CSV */
		Builder construtorDeEsquemaCSV = CsvSchema.builder();
		jsonNode.fieldNames().forEachRemaining(campo -> {
				construtorDeEsquemaCSV.addColumn(campo);
			});
		(new CsvMapper()).writerFor(JsonNode.class)
			.with(construtorDeEsquemaCSV.build().withHeader())
			.writeValue(new File(localDoArquivo + ".csv"), jsonNode);
	}

}
