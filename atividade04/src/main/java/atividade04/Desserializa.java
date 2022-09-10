/*
 * 3. Crie uma classe java de nome Desserializa para ler / desserializar os
 * objetos Serializados na Questão 2 e exibi-los também através do uso da
 * bilbioteca Jackson (XML Serialization and Deserialization with Jackson |
 * Baeldung).
 * */
package atividade04;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Desserializa {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String localDoArquivo = "filmes.xml";
		XmlMapper xmlMapper = new XmlMapper();
		Biblioteca biblioteca = xmlMapper.readValue(new File(localDoArquivo), Biblioteca.class);
		
		System.out.println(biblioteca.toString());
	}

}
