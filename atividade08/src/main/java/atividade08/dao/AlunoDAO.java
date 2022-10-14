package atividade08.dao;

import java.util.List;

import atividade08.modelos.Aluno;

public interface AlunoDAO {

	public List<Aluno> findAll();

	public Aluno save(Aluno aluno);

	public boolean deleteByMatricula(int matricula);

}
