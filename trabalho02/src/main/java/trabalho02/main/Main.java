package trabalho02.main;

import java.util.Scanner;

import trabalho02.dao.FilmeDao;
import trabalho02.dao.FilmeDaoImpl;
import trabalho02.modelos.Filme;

public class Main {

	private static Scanner teclado = new Scanner(System.in);
	private static FilmeDao filmeDao = new FilmeDaoImpl();

	public static void main(String[] args) {
		boolean exit;
		do {
			exit = menu();
		} while (!exit);
	}

	private static boolean menu() {
		System.out.println("OPÇÕES:");
		System.out.println("0 - sair");
		System.out.println("1 - listar-filmes");
		System.out.println("2 - adicionar-filme");
		System.out.println("3 - mostrar-filme");
		System.out.println("4 - remover-filme");
		System.out.println("5 - modificar-filme");
		System.out.print(" > ");

		String comando = teclado.nextLine();

		if (comando.equals("0") || comando.equals("sair")) {
			return true;
		} else if (comando.equals("1") || comando.equals("listar-filmes")) {
			listarFilmes();
		} else if (comando.equals("2") || comando.equals("adicionar-filme")) {
			adicionarFilme();
		} else if (comando.equals("3") || comando.equals("mostrar-filme")) {
			mostrarFilme();
		} else if (comando.equals("4") || comando.equals("remover-filme")) {
			removerFilme();
		} else if (comando.equals("5") || comando.equals("modificar-filme")) {
			modificarFilme();
		}

		return false;
	}

	private static void adicionarFilme() {
		String tituloDoFilme;
		String anoDoLancamento;

		System.out.print("Título do filme: ");
		tituloDoFilme = teclado.nextLine();
		System.out.print("Ano do lançamento do filme: ");
		anoDoLancamento = teclado.nextLine();

		filmeDao.save(new Filme(tituloDoFilme, Integer.parseInt(anoDoLancamento)));
	}

	private static void listarFilmes() {
		filmeDao.findAll().forEach(System.out::println);
	}

	private static void modificarFilme() {
		System.out.println("Identificador do filme: ");
		Filme filme = filmeDao.findByIdentifier(Integer.parseInt(teclado.nextLine()));

		System.out.print("Novo título do filme: ");
		filme.setTitulo(teclado.nextLine());
		System.out.print("Novo ano do lançamento do filme: ");
		filme.setAnoDeLancamento(Integer.parseInt(teclado.nextLine()));

		filmeDao.save(filme);
	}

	private static void mostrarFilme() {
		System.out.println("Identificador do filme: ");
		System.out.println(filmeDao.findByIdentifier(Integer.parseInt(teclado.nextLine())));
	}

	private static void removerFilme() {
		System.out.println("Identificador do filme: ");
		filmeDao.deleteByIdentifier(Integer.parseInt(teclado.nextLine()));
	}

}
