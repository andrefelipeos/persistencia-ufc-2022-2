package atividade06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controlador {

	public static void main(String[] args) throws SQLException {
		Connection conexao = DriverManager.getConnection(
				"jdbc:postgresql://localhost/persistencia",
				"postgres", "postgres");
		System.out.println("Conectado!");
		conexao.close();
	}

}
