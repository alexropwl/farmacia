package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.factory.Conexao;

public class ProdutoDAO {

	public void salvar(Produtos produtos) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produtos ");
		sql.append("(descricao, preco, quantidade, fornecedores_codigo)");
		sql.append("VALUES (?,?,?,?)");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, produtos.getDescricao());
		comando.setDouble(2, produtos.getPreco());
		comando.setInt(3, produtos.getQuantidade());
		comando.setInt(4, produtos.getFornecedores().getCodigo());
		comando.executeUpdate();

	}

	public ArrayList<Produtos> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.codigo, p.descricao, p.quantidade, p.preco,  f.codigo , f.descricao ");
		sql.append("from produtos p ");
		sql.append("INNER JOIN fornecedores f ON f.codigo = p.fornecedores_codigo");
		
		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet rs = comando.executeQuery();
		ArrayList<Produtos> lista = new ArrayList<Produtos>();

		while (rs.next()) {
			Fornecedores f = new Fornecedores();
			f.setCodigo(rs.getInt("f.codigo"));
			f.setDescricao(rs.getString("f.descricao"));

			Produtos p = new Produtos();
			p.setCodigo(rs.getInt("p.codigo"));
			p.setDescricao(rs.getString("p.descricao"));
			p.setQuantidade(rs.getInt("p.quantidade"));
			p.setPreco(rs.getDouble("p.preco"));
			p.setFornecedores(f);

			lista.add(p);

		}

		return lista;
	}

	
	public void excluir(Produtos produtos) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM produtos ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = Conexao.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setInt(1, produtos.getCodigo());
		comando.executeUpdate();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
