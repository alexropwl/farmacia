package br.com.farmacia.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String usuario = "alexandre";
	private static final String senha = "private";
	private static final String url = "jdbc:mysql://localhost:3306/farmacia";

	public static Connection conectar() throws SQLException {

		Connection conexao = DriverManager.getConnection(url, usuario, senha);

		return conexao;

	}

	public static void main(String[] args) {

		Conexao conexao = new Conexao();
		try {
			conexao.conectar();
			System.out.println("Conectado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao conectar");

		}

	}

}
