package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	static Connection conexao;

	public static Connection faz_conexao() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/rankingdefilmesbdd", "root", "");

		} catch (SQLException e) {
			System.out.println("Erro ao conectar a base de dados.");
		}
		return conexao;
	}

	public void desconectar() {
		try {
			conexao.close();
		} catch (Exception e) {

		}
	}
}
