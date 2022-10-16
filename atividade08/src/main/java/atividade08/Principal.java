package atividade08;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import atividade08.dao.AlunoDAO;
import atividade08.modelos.Aluno;

@SpringBootApplication
public class Principal implements CommandLineRunner {

	@Autowired
	private AlunoDAO alunoDAO;

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Principal.class, args);
	}

	public void run(String... args) throws Exception {
		Scanner teclado = new Scanner(System.in);

		String opcao;
		while (true) {
			System.out.println("Opções: 'cadastrar', 'atualizar', 'apagar' e 'listar'.");
			System.out.print(" > ");
			opcao = teclado.nextLine();
			if (opcao.equals("cadastrar")) {
				Aluno aluno = Principal.defineAlunoPeloTeclado(teclado);
				alunoDAO.save(aluno);
			} else if (opcao.equals("atualizar")) {
				System.out.print("Identificador: ");
				int identificador = Integer.parseInt(teclado.nextLine());
				Aluno aluno = Principal.defineAlunoPeloTeclado(teclado);
				aluno.setIdentificador(identificador);
				alunoDAO.save(aluno);
			} else if (opcao.equals("apagar")) {
				System.out.print("Matrícula: ");
				Integer matricula = Integer.valueOf(teclado.nextLine());
				if (alunoDAO.deleteByMatricula(matricula)) {
					System.out.println("O registro do aluno com matrícula"
							+ " " + matricula + " foi apagado.");
				}
			} else if (opcao.equals("listar")) {
				List<Aluno> listaDeAlunos = alunoDAO.findAll();
				for (Aluno aluno : listaDeAlunos) {
					System.out.println(aluno);
				}
			} else {
				break;
			}
		}
	}

	private static Aluno defineAlunoPeloTeclado(Scanner entrada) {
		String cpf;
		int matricula;
		String nome;
		String email;
		String telefone;

		System.out.print("CPF: ");
		cpf = entrada.nextLine();
		System.out.print("Matrícula: ");
		matricula = Integer.parseInt(entrada.nextLine());;
		System.out.print("Nome: ");
		nome = entrada.nextLine();
		System.out.print("E-mail: ");
		email = entrada.nextLine();
		System.out.print("Telefone: ");
		telefone = entrada.nextLine();

		Aluno novoAluno = new Aluno(matricula, nome, cpf, email, telefone);

		return novoAluno;
	}

}
