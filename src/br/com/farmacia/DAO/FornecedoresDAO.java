package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	public void excluir(Fornecedores fornecedores) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = Conexao.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setInt(1, fornecedores.getCodigo());
		comando.executeUpdate();

	}

	public void editar(Fornecedores fornecedores) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = Conexao.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, fornecedores.getDescricao());
		comando.setInt(2, fornecedores.getCodigo());
		comando.executeUpdate();

	}

	public Fornecedores buscaPorCodigo(Fornecedores fornecedores) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, fornecedores.getCodigo());

		ResultSet rs = comando.executeQuery();
		Fornecedores retorno = null;

		if (rs.next()) {

			retorno = new Fornecedores();
			retorno.setCodigo(rs.getInt("codigo"));
			retorno.setDescricao(rs.getString("descricao"));

		}

		return retorno;

	}

	public ArrayList<Fornecedores> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("from fornecedores ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet rs = comando.executeQuery();
		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (rs.next()) {
			Fornecedores f = new Fornecedores();
			f.setCodigo(rs.getInt("codigo"));
			f.setDescricao(rs.getString("descricao"));
             
			
			lista.add(f);
			
		
		}

		
		return lista;
	}

	public static void main(String[] args) throws SQLException {

		/**
		 * Fornecedores f = new Fornecedores(); f.setDescricao("novo");
		 * 
		 * FornecedoresDAO fr = new FornecedoresDAO(); fr.salvar(f);
		 * 
		 * 
		 * Fornecedores f = new Fornecedores(); f.setCodigo(1);
		 * 
		 * FornecedoresDAO fd = new FornecedoresDAO();
		 * 
		 * try { fd.excluir(f); System.out.println("Deletado com sucesso"); } catch
		 * (SQLException e) { e.printStackTrace(); System.out.println("Erro ao
		 * deletar");
		 * 
		 * }
		 * 
		 * 
		 * Fornecedores f = new Fornecedores(); f.setCodigo(5); f.setDescricao("alex");
		 * 
		 * FornecedoresDAO fd = new FornecedoresDAO();
		 * 
		 * try { fd.editar(f); System.out.println("Editado com sucessp");
		 * 
		 * } catch (Exception e) { e.printStackTrace(); System.out.println("Erro na
		 * edicao");
		 * 
		 * }
		 

		Fornecedores f = new Fornecedores();
		f.setCodigo(4);
		FornecedoresDAO fd = new FornecedoresDAO();

		try {
			Fornecedores f3 = fd.buscaPorCodigo(f);
			System.out.println("Codigo encontrado " + f3);

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("erro na busca");

		} **/
		
		
		FornecedoresDAO f = new FornecedoresDAO();
		
		try {
			ArrayList<Fornecedores>lista = f.listar();
			
			for(Fornecedores f1 : lista) {
			System.out.println("Listagem " + f1);
		}
			
		}catch(Exception e) {
			System.out.println("Erro na busca");
			
			
		}

	}
}
