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
		mapper.writeValue(new File(localDoArquivo), listaDeLivros);
	}

	private static List<Livro> naoInterativo() {
		List<Livro> listaDeLivros = new ArrayList<Livro>();

		listaDeLivros.add(new Livro("Ensaio sobre a cegueira",
				"José Saramago",
				"Português",
				"Companhia das Letras",
				2022));
		listaDeLivros.add(new Livro("Ensaio sobre a lucidez",
				"José Saramago",
				"Português",
				"Companhia das Letras",
				2022));
		listaDeLivros.add(new Livro("Me encontre",
				"André Aciman",
				"Inglês",
				"Intrínseca",
				2019));
		listaDeLivros.add(new Livro("Cai o pano: o último caso de Poirot",
				"Agatha Christie",
				"Inglês",
				"L&PM editores",
				2021));
		listaDeLivros.add(new Livro("A coragem de ser imperfeito",
				"Brené Brown",
				"Inglês",
				"Sextante",
				2019));

		return listaDeLivros;
	}

}
