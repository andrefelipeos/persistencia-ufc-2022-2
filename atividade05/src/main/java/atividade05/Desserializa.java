/*
 * 3. Crie uma classe java de nome Desserializa para ler / desserializar os
 * objetos Serializados na Questão 2 e exibi-los também através do uso da
 * biblioteca Jackson.
 * */

package atividade05;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import atividade05.model.Livro;

public class Desserializa {

	public static void main(String[] args) throws Exception {
		String localDoArquivo = "livros.json";
		
		ObjectMapper mapper = new ObjectMapper();
		List<Livro> lista = mapper.readValue(new File(localDoArquivo), new TypeReference<List<Livro>>() {
		});
		for (Livro livro : lista) {
			System.out.println("* * * * * * * * * * * * * * * * * * * *");
			System.out.println(livro.toString());
			System.out.println("* * * * * * * * * * * * * * * * * * * *");
		}
	}

}
