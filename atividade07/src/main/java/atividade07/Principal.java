package atividade07;

import java.sql.SQLException;
import java.util.List;

import atividade07.dao.AlunoDAO;
import atividade07.dao.AlunoDAOImpl;
import atividade07.modelos.Aluno;

public class Principal {

	public static void main(String[] args) throws SQLException {
		AlunoDAO alunoDAO = new AlunoDAOImpl();
		List<Aluno> listaDeAlunos = alunoDAO.findAll();
		for (Aluno aluno : listaDeAlunos) {
			System.out.println(aluno);
		}
	}

}
