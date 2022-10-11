package atividade07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Connection conexao = DriverManager
				.getConnection("jdbc:postgresql://localhost/persistencia",
						"postgres", "postgres");
		PreparedStatement ps = conexao.prepareStatement("SELECT * FROM alunos;");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("nome") + " : " + rs.getString("matricula"));
		}
		conexao.close();
	}

}
