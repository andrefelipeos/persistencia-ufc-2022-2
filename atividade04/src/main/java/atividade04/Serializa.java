/*
 * 2. Crie uma classe Java de nome Serializa para instanciar objetos da classe
 * definida na Questão 1 e adicionar esses objetos em uma Lista. Depois,
 * percorrer a lista e Serializar os objetos em disco/ssd. Serialize usando XML
 * através da biblioteca Jackson (XML Serialization and Deserialization with
 * Jackson | Baeldung)
 * */
package atividade04;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Serializa {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		List<Filme> listaDeFilmes;
		String localDoArquivo = "filmes.xml";

		if (args.length > 0 && args[0].equals("i")) {
			listaDeFilmes = Serializa.interativo();
		} else {
			listaDeFilmes = Serializa.naoInterativo();
		}

		File arquivo = new File(localDoArquivo);
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
		xmlMapper.writeValue(arquivo, listaDeFilmes);
	}

	private static List<Filme> interativo() {
		List<Filme> listaDeFilmes = new ArrayList<Filme>();
		Scanner terminal = new Scanner(System.in);

		String titulo;
		String diretor;
		int ano;
		while (true) {
			System.out.print("Título: ");
			titulo = terminal.nextLine();
			System.out.print("Diretor: ");
			diretor = terminal.nextLine();
			System.out.print("Ano: ");
			ano = terminal.nextInt();
			listaDeFilmes.add(new Filme(titulo, diretor, ano));
			System.out.print("Adicionar mais? [s - sim]: ");
			if (!terminal.nextLine().equals("s")) {
				break;
			}
		}
		terminal.close();

		return listaDeFilmes;
	}

	private static List<Filme> naoInterativo() {
		List<Filme> listaDeFilmes = new ArrayList<Filme>();
		listaDeFilmes.add(new Filme("O Grande Truque", "Christopher Nolan", 2006));
		listaDeFilmes.add(new Filme("A Origem", "Christopher Nolan", 2010));
		listaDeFilmes.add(new Filme("Interestelar", "Christopher Nolan", 2014));
		listaDeFilmes.add(new Filme("Dunkirk", "Christopher Nolan", 2017));
		listaDeFilmes.add(new Filme("Tenet", "Christopher Nolan", 2020));
		return listaDeFilmes;
	}

}
