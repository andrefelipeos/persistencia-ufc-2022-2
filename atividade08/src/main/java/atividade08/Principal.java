package atividade08;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import atividade08.dao.AlunoDAO;
import atividade08.dao.AlunoDAOImpl;
import atividade08.modelos.Aluno;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Scanner teclado = new Scanner(System.in);

		AlunoDAO alunoDAO = new AlunoDAOImpl();

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
				Integer matricula = Integer.valueOf(teclado.nextLine());
				alunoDAO.deleteByMatricula(matricula);
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
