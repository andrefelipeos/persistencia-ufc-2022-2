/*
 * 3. Crie uma classe java de nome Desserializa para ler / desserializar os
 * objetos Serializados na Questão 2 e exibi-los também através do uso da
 * bilbioteca Jackson (XML Serialization and Deserialization with Jackson |
 * Baeldung).
 * */
package atividade04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Desserializa {

	public static void main(String[] args) throws IOException, ClassNotFoundException, XMLStreamException {
		XMLInputFactory f = XMLInputFactory.newFactory();
		File inputFile = new File("filmes.xml");
		XMLStreamReader sr = f.createXMLStreamReader(new FileInputStream(inputFile));

		XmlMapper mapper = new XmlMapper();
		sr.next();
		sr.next();
		Filme filme1 = mapper.readValue(sr, Filme.class);
		sr.next();
		Filme filme2 = mapper.readValue(sr, Filme.class);
		sr.next();
		Filme filme3 = mapper.readValue(sr, Filme.class);
		sr.next();
		Filme filme4 = mapper.readValue(sr, Filme.class);
		sr.next();
		Filme filme5 = mapper.readValue(sr, Filme.class);
		sr.close();
		
		System.out.println(filme1.toString());
		System.out.println(filme2.toString());
		System.out.println(filme3.toString());
		System.out.println(filme4.toString());
		System.out.println(filme5.toString());
	}

}
