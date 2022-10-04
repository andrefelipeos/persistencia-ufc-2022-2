package atividade06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import atividade06.modelos.Aluno;

public class Controlador {

	public static void main(String[] args) throws SQLException {
		Connection conexao = DriverManager.getConnection(
				"jdbc:postgresql://localhost/persistencia",
				"postgres", "postgres");
		System.out.println("Conectado!");
		conexao.close();
	}

	private static Aluno defineAlunoPeloTeclado(Scanner entrada) {
		int id;
		String cpf;
		int matricula;
		String nome;
		String email;
		String telefone;

		System.out.print("Identificador: ");
		id = entrada.nextInt();
		System.out.print("CPF: ");
		cpf = entrada.nextLine();
		System.out.print("Matrícula: ");
		matricula = entrada.nextInt();
		System.out.print("Nome: ");
		nome = entrada.nextLine();
		System.out.print("E-mail: ");
		email = entrada.nextLine();
		System.out.print("Telefone: ");
		telefone = entrada.nextLine();

		Aluno novoAluno = new Aluno(id, cpf, matricula, nome, email, telefone);

		return novoAluno;
	}

}
