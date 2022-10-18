package atividade08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import atividade08.modelos.Aluno;

@Repository
public class AlunoDAOImpl implements AlunoDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public Aluno save(Aluno aluno) {
		MapSqlParameterSource parametros = new MapSqlParameterSource();
		parametros.addValue("matricula", aluno.getMatricula());
		parametros.addValue("nome", aluno.getNome());
		parametros.addValue("cpf", aluno.getCpf());
		parametros.addValue("email", aluno.getEmail());
		parametros.addValue("telefone", aluno.getTelefone());

		if (aluno.getIdentificador() == null) {
			String sqlInserir = "INSERT INTO alunos "
					+ "(matricula, nome, cpf, email, telefone) "
					+ "VALUES (:matricula, :nome, :cpf, :email, :telefone);";
			jdbcTemplate.update(sqlInserir, parametros);
		} else {
			parametros.addValue("identificador", aluno.getIdentificador());
			String sqlAlterar = "UPDATE alunos SET "
					+ "matricula = :matricula, "
					+ "nome = :nome, "
					+ "cpf = :cpf, "
					+ "email = :email, "
					+ "telefone = :telefone "
					+ "WHERE identificador = :identificador;";
			jdbcTemplate.update(sqlAlterar, parametros);
		}

		return aluno;
	}

	@SuppressWarnings("unused")
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

	@SuppressWarnings("unused")
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
		String consultaSql = "SELECT * FROM alunos;";
		return jdbcTemplate.query(consultaSql, (rs, linha) -> {
			int identificador = rs.getInt("identificador");
			int matricula = rs.getInt("matricula");
			String nome = rs.getString("nome");
			String cpf = rs.getString("cpf");
			String email = rs.getString("email");
			String telefone = rs.getString("telefone");

			Aluno aluno = new Aluno(matricula, nome, cpf, email, telefone);
			aluno.setIdentificador(identificador);

			return aluno;
		});
	}

	public boolean deleteByMatricula(int matricula) {
		int linhasAfetadas = 0;

		String sqlRemover = "DELETE FROM alunos WHERE matricula = :matricula;";
		MapSqlParameterSource parametros = new MapSqlParameterSource();
		parametros.addValue("matricula", matricula);
		linhasAfetadas = jdbcTemplate.update(sqlRemover, parametros);

		return !(linhasAfetadas == 0);
	}

}
