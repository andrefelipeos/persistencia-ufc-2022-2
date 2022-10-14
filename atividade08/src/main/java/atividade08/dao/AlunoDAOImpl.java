package atividade08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import atividade08.modelos.Aluno;

public class AlunoDAOImpl implements AlunoDAO {

	public Aluno save(Aluno aluno) {
		Connection conexao = null;

		try {
			conexao = ConnectionFactory.getConnection();
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
			} else {
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
		} catch (SQLException e) {
			throw new DAOException("Não foi possível acessar o banco de dados", e);
		} finally {
			if (conexao != null) {
				try {
					conexao.close();
				} catch (SQLException e) {
					String mensagem = "Um erro ocorreu ao tentar encerrar a conexão"
							+ " com o banco de dados";
					throw new DAOException(mensagem, e);
				}
			}
		}

		return aluno;
	}

	public List<Aluno> findAll() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		Connection conexao = null;
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM alunos;");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int matricula = rs.getInt("matricula");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");

				Aluno aluno = new Aluno(matricula, nome, cpf, email, telefone);
				alunos.add(aluno);
			}
		} catch (SQLException e) {
			throw new DAOException("Não foi possível acessar o banco de dados", e);
		} finally {
			if (conexao != null) {
				try {
					conexao.close();
				} catch (SQLException e) {
					String mensagem = "Um erro ocorreu ao tentar encerrar a conexão"
							+ " com o banco de dados";
					throw new DAOException(mensagem, e);
				}
			}
		}

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
