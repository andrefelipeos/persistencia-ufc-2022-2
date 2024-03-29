package trabalho02.main;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import trabalho02.dao.AtorDao;
import trabalho02.dao.AtorDaoImpl;
import trabalho02.dao.FilmeDao;
import trabalho02.dao.FilmeDaoImpl;
import trabalho02.modelos.Ator;
import trabalho02.modelos.Filme;

public class Main {

	private static Scanner teclado = new Scanner(System.in);
	private static FilmeDao filmeDao = new FilmeDaoImpl();
	private static AtorDao atorDao = new AtorDaoImpl();

	public static void main(String[] args) {
		System.out.println("Dica: use 'listar-comandos' para listar todos os comandos disponíveis.");
		boolean repeat;
		do {
			repeat = menu();
		} while (repeat);
	}

	private static boolean menu() {
		System.out.print(" > ");
		String comando = teclado.nextLine();

		if (comando.equals("0") || comando.equals("sair")) {
			return false;
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
		} else if (comando.equals("6") || comando.equals("listar-atores")) {
			listarAtores();
		} else if (comando.equals("7") || comando.equals("adicionar-ator")) {
			adicionarAtor();
		} else if (comando.equals("8") || comando.equals("mostrar-ator")) {
			mostrarAtor();
		} else if (comando.equals("9") || comando.equals("remover-ator")) {
			removerAtor();
		} else if (comando.equals("10") || comando.equals("modificar-ator")) {
			modificarAtor();
		} else if (comando.equals("11") || comando.equals("associar-entidades")) {
			associarEntidades();
		} else if (comando.equals("12") || comando.equals("filmes-por-ano")) {
			filtrarFilmesPorAno();
		} else if (comando.equals("13") || comando.equals("atores-do-filme")) {
			listarAtoresDeUmFilme();
		} else if (comando.equals("14") || comando.equals("filmes-do-ator")) {
			listarFilmesDeUmAtor();
		} else if (comando.equals("15") || comando.equals("filmes-por-substring")) {
			listarFilmesPorSubstring();
		} else if (comando.equals("16") || comando.equals("atores-por-ano-nascimento")) {
			listarAtorPorAnoDeNascimento();
		} else if (comando.equals("17") || comando.equals("quantidade-de-filmes")) {
			mostraQuantidadeTotalDeFilmesCadastrados();
		} else if (comando.equals("18") || comando.equals("listar-comandos")) {
			listarComandos();
		}

		return true;
	}

	private static void mostraQuantidadeTotalDeFilmesCadastrados() {
		System.out.println(filmeDao.findTotalNumberOfRegisteredMovies());
	}

	private static void listarComandos() {
		System.out.println("OPÇÕES:");
		System.out.println("0 - sair");
		System.out.println("1 - listar-filmes");
		System.out.println("2 - adicionar-filme");
		System.out.println("3 - mostrar-filme");
		System.out.println("4 - remover-filme");
		System.out.println("5 - modificar-filme");
		System.out.println("6 - listar-atores");
		System.out.println("7 - adicionar-ator");
		System.out.println("8 - mostrar-ator");
		System.out.println("9 - remover-ator");
		System.out.println("10 - modificar-ator");
		System.out.println("11 - associar-entidades");
		System.out.println("12 - filmes-por-ano");
		System.out.println("13 - atores-do-filme");
		System.out.println("14 - filmes-do-ator");
		System.out.println("15 - filmes-por-substring");
		System.out.println("16 - atores-por-ano-nascimento");
		System.out.println("17 - quantidade-de-filmes");
		System.out.println("18 - listar-comandos");
	}

	private static void adicionarAtor() {
		String nomeDoAtor;
		String dataDeNascimento;

		System.out.print("Nome do ator: ");
		nomeDoAtor = teclado.nextLine();
		System.out.print("Data do nascimento do ator no formato DD-MM-AAAA: ");
		dataDeNascimento = teclado.nextLine();

		atorDao.save(new Ator(nomeDoAtor, LocalDate.parse(dataDeNascimento, DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
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

	private static void associarEntidades() {
		System.out.print("Identificador do filme: ");
		Filme filme = filmeDao.findByIdentifier(Integer.parseInt(teclado.nextLine()));
		System.out.print("Identificador do ator: ");
		Ator ator = atorDao.findByIdentifier(Integer.parseInt(teclado.nextLine()));

		filme.adicionarParticipacaoDo(ator);
		filmeDao.save(filme);
	}

	private static void filtrarFilmesPorAno() {
		System.out.print("Ano: ");
		String ano = teclado.nextLine();
		filmeDao.findTitlesOfAllMoviesReleasedIn(Year.of(Integer.parseInt(ano))).forEach(System.out::println);
	}

	private static void listarAtores() {
		atorDao.findAll().forEach(System.out::println);
	}

	private static void listarAtoresDeUmFilme() {
		System.out.print("Identificador do filme: ");
		filmeDao.findNamesOfAllActorsIn(filmeDao.findByIdentifier(Integer.parseInt(teclado.nextLine())))
				.forEach(System.out::println);
	}

	private static void listarAtorPorAnoDeNascimento() {
		System.out.print("Ano: ");
		atorDao.findNamesOfAllActorsBornIn(Year.of(Integer.parseInt(teclado.nextLine()))).forEach(System.out::println);
	}

	private static void listarFilmes() {
		filmeDao.findAll().forEach(System.out::println);
	}

	private static void listarFilmesDeUmAtor() {
		System.out.print("Identificador do ator: ");
		atorDao.findTitlesOfAllMoviesWith(atorDao.findByIdentifier(Integer.parseInt(teclado.nextLine())))
				.forEach(System.out::println);
	}

	public static void listarFilmesPorSubstring() {
		System.out.print("Termo de busca: ");
		filmeDao.findTitlesOfAllMoviesContaining(teclado.nextLine()).forEach(System.out::println);
	}

	private static void modificarAtor() {
		System.out.print("Identificador do ator: ");
		Ator ator = atorDao.findByIdentifier(Integer.parseInt(teclado.nextLine()));

		System.out.print("Novo nome do ator: ");
		ator.setNome(teclado.nextLine());
		System.out.print("Nova data de nascimento do ator: ");
		ator.setDataDeNascimento(LocalDate.parse(teclado.nextLine()));

		atorDao.save(ator);
	}

	private static void modificarFilme() {
		System.out.print("Identificador do filme: ");
		Filme filme = filmeDao.findByIdentifier(Integer.parseInt(teclado.nextLine()));

		System.out.print("Novo título do filme: ");
		filme.setTitulo(teclado.nextLine());
		System.out.print("Novo ano do lançamento do filme: ");
		filme.setAnoDeLancamento(Integer.parseInt(teclado.nextLine()));

		filmeDao.save(filme);
	}

	private static void mostrarAtor() {
		System.out.print("Identificador do ator: ");
		System.out.println(atorDao.findByIdentifier(Integer.parseInt(teclado.nextLine())));
	}

	private static void mostrarFilme() {
		System.out.print("Identificador do filme: ");
		System.out.println(filmeDao.findByIdentifier(Integer.parseInt(teclado.nextLine())));
	}

	private static void removerAtor() {
		System.out.print("Identificador do ator: ");
		atorDao.deleteByIdentifier(Integer.parseInt(teclado.nextLine()));
	}

	private static void removerFilme() {
		System.out.print("Identificador do filme: ");
		filmeDao.deleteByIdentifier(Integer.parseInt(teclado.nextLine()));
	}

}
