package atividade06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import atividade06.modelos.Aluno;

public class Controlador {

	public static void main(String[] args) throws SQLException {
		Scanner teclado = new Scanner(System.in);

		String opcao;
		while (true) {
			System.out.println("Opções: 'cadastrar' e 'listar'.");
			System.out.print(" > ");
			opcao = teclado.nextLine();
			if (opcao.equals("cadastrar")) {
				Controlador.cadastrarUmAluno(teclado);
			} else if (opcao.equals("listar")) {
				Controlador.listarAlunos();
			} else {
				break;
			}
		}

		teclado.close();
	}

	private static void listarAlunos() throws SQLException {
		Connection conexao = FabricaDeConexoes.getConnection();

		PreparedStatement ps = conexao.prepareStatement("SELECT * FROM aluno");
		ResultSet rs = ps.executeQuery();

		int id;
		String cpf;
		int matricula;
		String nome;
		String email;
		String telefone;

		while (rs.next()) {
			id = rs.getInt("id");
			cpf = rs.getString("cpf");
			matricula = rs.getInt("matricula");
			nome = rs.getString("nome");
			email = rs.getString("email");
			telefone = rs.getString("telefone");

			Aluno aluno = new Aluno(id, cpf, matricula, nome, email, telefone);
			System.out.println(aluno.toString());
		}

		conexao.close();
	}

	private static void cadastrarUmAluno(Scanner scanner) throws SQLException {
		Connection conexao = FabricaDeConexoes.getConnection();

		Aluno aluno = Controlador.defineAlunoPeloTeclado(scanner);

		String sqlDeInsercao = "INSERT INTO aluno(id, cpf, matricula, nome, email, telefone) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conexao.prepareStatement(sqlDeInsercao);

		ps.setInt(1, aluno.getId());
		ps.setString(2, aluno.getCpf());
		ps.setInt(3, aluno.getMatricula());
		ps.setString(4, aluno.getNome());
		ps.setString(5, aluno.getEmail());
		ps.setString(6, aluno.getTelefone());

		ps.executeUpdate();

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
		id = Integer.parseInt(entrada.nextLine());
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

		Aluno novoAluno = new Aluno(id, cpf, matricula, nome, email, telefone);

		return novoAluno;
	}

}
