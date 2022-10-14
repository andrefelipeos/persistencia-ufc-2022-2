package atividade08.dao;

import java.sql.SQLException;
import java.util.List;

import atividade08.modelos.Aluno;

public interface AlunoDAO {

	public List<Aluno> findAll() throws SQLException;

	public Aluno save(Aluno aluno) throws SQLException;

	public boolean deleteByMatricula(int matricula) throws SQLException;

}
