package br.com.farmacia.teste;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;

public class ProdutoDAOTeste {

	@Test
	@Ignore
	public void salvar() throws SQLException {

		Produtos p1 = new Produtos();
		p1.setDescricao("NOVALGINA");
		p1.setPreco(2.99);
		p1.setQuantidade(100);

		Fornecedores f = new Fornecedores();
		f.setCodigo(11);

		p1.setFornecedores(f);

		ProdutoDAO f1 = new ProdutoDAO();

		f1.salvar(p1);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		ProdutoDAO p = new ProdutoDAO();
		ArrayList<Produtos> lista = p.listar();

		for (Produtos p1 : lista) {

			System.out.println("Codigo do Produto: " + p1.getCodigo());
			System.out.println("Descrição: " + p1.getDescricao());
			System.out.println("Valor : " + p1.getPreco());
			System.out.println("Quantidade : " + p1.getQuantidade());

			System.out.println("Codigo do Fornecedor: " + p1.getFornecedores().getCodigo());
			System.out.println("Fornecedor : " + p1.getFornecedores().getDescricao());

		}

	}

	@Test
	public void excluir() throws SQLException {

		Produtos p = new Produtos();
		p.setCodigo(3);

		ProdutoDAO pd = new ProdutoDAO();

		pd.excluir(p);

	}

}
