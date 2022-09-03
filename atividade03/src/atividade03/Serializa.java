package atividade03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Serializa {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		List<Filme> listaDeFilmes;
		String arquivo = "arquivo.txt";

		if (args.length > 0 && args[0].equals("i")) {
			listaDeFilmes = Serializa.interativo();
		} else {
			listaDeFilmes = Serializa.naoInterativo();
		}

		OutputStream os = new FileOutputStream(arquivo);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		for (Filme filme : listaDeFilmes) {
			oos.writeObject(filme);
			oos.flush();
		}
		oos.close();
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
