package atividade08.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import atividade08.configuracoes.AppConfig;

public class ConnectionFactory {
	
	public static Connection getConnection() throws SQLException {
		Properties props = AppConfig.PROPS;
		return DriverManager.getConnection(
				props.getProperty("spring.datasource.url"),
				props.getProperty("spring.datasource.username"),
				props.getProperty("spring.datasource.password"));
	}

}
