package atividade07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import atividade07.modelos.Aluno;

public class AlunoDAOImpl implements AlunoDAO {

	public Aluno save(Aluno aluno) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		if (aluno.getIdentificador() == null) {
			String sqlInserir = "INSERT INTO alunos "
					+ "(matricula, nome, cpf, email, telefone) "
					+ "VALUES (?, ?, ?, ?, ?);";
			PreparedStatement ps = conexao
					.prepareStatement(sqlInserir, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, aluno.getMatricula());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getCpf());
			ps.setString(4, aluno.getEmail());
			ps.setString(5, aluno.getTelefone());
			ps.executeUpdate();
			ResultSet chavesGeradas = ps.getGeneratedKeys();
			if (chavesGeradas.next()) {
				aluno.setIdentificador(chavesGeradas.getInt("identificador"));
			}
		}

		return aluno;
	}

	public List<Aluno> findAll() throws SQLException {
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
		}

		conexao.close();

		return alunos;
	}

	public boolean deleteByMatricula(int matricula) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sqlRemover = "DELETE FROM alunos WHERE matricula = ?;";
		PreparedStatement ps = conexao.prepareStatement(sqlRemover);
		ps.setInt(1, matricula);

		if (ps.executeUpdate() > 0) {
			return true;
		}

		return false;
	}


}
