package atividade07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atividade07.dao.ConnectionFactory;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement ps = conexao.prepareStatement("SELECT * FROM alunos;");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("matricula") + " : " + rs.getString("nome"));
		}
		conexao.close();
	}

}
