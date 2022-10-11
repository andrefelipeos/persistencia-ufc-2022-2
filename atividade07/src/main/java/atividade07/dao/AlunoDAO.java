package atividade07.dao;

import java.sql.SQLException;
import java.util.List;

import atividade07.modelos.Aluno;

public interface AlunoDAO {

	public List<Aluno> findAll() throws SQLException;

}
