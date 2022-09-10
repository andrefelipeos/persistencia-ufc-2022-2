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
		XmlMapper xmlMapper = new XmlMapper();
		Filme filme = xmlMapper.readValue(new File("filmes.xml"), Filme.class);
		
		System.out.println(filme.toString());
	}

}
