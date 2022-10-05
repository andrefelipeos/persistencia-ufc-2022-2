package atividade06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:postgresql://localhost/persistencia",
				"postgres", "postgres");
	}

}
