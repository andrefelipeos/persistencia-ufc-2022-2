/*
 * 2. Crie uma classe Java de nome Serializa para instanciar objetos da classe
 * definida na Questão 1 e adicionar esses objetos em uma Lista. Depois,
 * percorrer a lista e Serializar os objetos em disco/ssd. Serialize usando
 * JSON através da biblioteca Jackson.
 * */

package atividade05;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import atividade05.model.Livro;

public class Serializa {

	public static void main(String[] args) throws Exception {
		String localDoArquivo = "livros.json";
		List<Livro> listaDeLivros = Serializa.naoInterativo();

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.writeValue(new File(localDoArquivo), listaDeLivros.get(0));
	}

	private static List<Livro> naoInterativo() {
		List<Livro> listaDeFilmes = new ArrayList<Livro>();

		Livro livro1 = new Livro("Ensaio sobre a cegueira",
				"José Saramago",
				"Português",
				"Companhia das Letras",
				2022);
		Livro livro2 = new Livro("Ensaio sobre a lucidez",
				"José Saramago",
				"Português",
				"Companhia das Letras",
				2022);
		listaDeFilmes.add(livro1);
		listaDeFilmes.add(livro2);

		return listaDeFilmes;
	}

}
