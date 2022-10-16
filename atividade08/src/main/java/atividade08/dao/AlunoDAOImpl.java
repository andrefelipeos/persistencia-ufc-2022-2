package atividade08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import atividade08.modelos.Aluno;

@Repository
public class AlunoDAOImpl implements AlunoDAO {

	public Aluno save(Aluno aluno) {

		try (Connection conexao = ConnectionFactory.getConnection()) {
			if (aluno.getIdentificador() == null) {
				cadastraAluno(aluno, conexao);
			} else {
				alteraAluno(aluno, conexao);
			}
		} catch (SQLException e) {
			throw new DAOException("Não foi possível acessar o banco de dados", e);
		}

		return aluno;
	}

	private void cadastraAluno(Aluno aluno, Connection conexao) throws SQLException {
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

	private void alteraAluno(Aluno aluno, Connection conexao) throws SQLException {
		String sqlAlterar = "UPDATE alunos SET "
				+ "matricula = ?, "
				+ "nome = ?, "
				+ "cpf = ?, "
				+ "email = ?, "
				+ "telefone = ? "
				+ "WHERE identificador = ?;";
		PreparedStatement ps = conexao.prepareStatement(sqlAlterar);
		ps.setInt(1, aluno.getMatricula());
		ps.setString(2, aluno.getNome());
		ps.setString(3, aluno.getCpf());
		ps.setString(4, aluno.getEmail());
		ps.setString(5, aluno.getTelefone());
		ps.setInt(6, aluno.getIdentificador());
		ps.executeUpdate();
	}

	public List<Aluno> findAll() {
		List<Aluno> alunos = new ArrayList<Aluno>();

		try (Connection conexao = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM alunos;");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int identificador = rs.getInt("identificador");
				int matricula = rs.getInt("matricula");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");

				Aluno aluno = new Aluno(matricula, nome, cpf, email, telefone);
				aluno.setIdentificador(identificador);
				alunos.add(aluno);
			}
		} catch (SQLException e) {
			throw new DAOException("Não foi possível acessar o banco de dados", e);
		}

		return alunos;
	}

	public boolean deleteByMatricula(int matricula) {
		int linhasAfetadas = 0;

		try (Connection conexao = ConnectionFactory.getConnection()) {
			String sqlRemover = "DELETE FROM alunos WHERE matricula = ?;";
			PreparedStatement ps = conexao.prepareStatement(sqlRemover);
			ps.setInt(1, matricula);
			
			linhasAfetadas = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Não foi possível acessar o banco de dados", e);
		}

		if (linhasAfetadas == 0) {
			return false;
		} else {
			return true;
		}
	}

}
