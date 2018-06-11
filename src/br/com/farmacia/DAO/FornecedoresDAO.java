package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.Conexao;

public class FornecedoresDAO {

	public void salvar(Fornecedores fornecedores) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao)");
		sql.append("VALUES (?)");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, fornecedores.getDescricao());
		comando.executeUpdate();

	}

	public static void main(String[] args) throws SQLException {

		Fornecedores f = new Fornecedores();
		f.setDescricao("teste");

		FornecedoresDAO fr = new FornecedoresDAO();
		fr.salvar(f);

	}
}
