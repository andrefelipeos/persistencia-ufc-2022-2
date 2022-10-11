package atividade07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import atividade07.dao.ConnectionFactory;
import atividade07.modelos.Aluno;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement ps = conexao.prepareStatement("SELECT * FROM alunos;");
		ResultSet rs = ps.executeQuery();

		List<Aluno> alunos = new ArrayList<Aluno>();

		while (rs.next()) {
			int matricula = rs.getInt("matricula");
			String nome = rs.getString("nome");
			String cpf = rs.getString("cpf");
			String email = rs.getString("email");
			String telefone = rs.getString("telefone");

			Aluno aluno = new Aluno(matricula, nome, cpf, email, telefone);
			alunos.add(aluno);
			System.out.println(aluno);
		}

		conexao.close();
	}

}
