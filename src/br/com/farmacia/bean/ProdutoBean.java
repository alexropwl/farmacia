package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBProdutos")
@ViewScoped
public class ProdutoBean {

	private Produtos produtos;
	private ArrayList<Produtos> itens;
	private ArrayList<Produtos> itensfiltrados;
	private ArrayList<Fornecedores> comboFornecedores;

	public ArrayList<Fornecedores> getComboFornecedores() {
		return comboFornecedores;
	}

	public void setComboFornecedores(ArrayList<Fornecedores> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Produtos> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produtos> itens) {
		this.itens = itens;
	}

	public ArrayList<Produtos> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<Produtos> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			ProdutoDAO pd = new ProdutoDAO();
			itens = pd.listar();

		}

		catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}

	}

	public void prepararNovo() {

		try {
	produtos = new Produtos();
	FornecedoresDAO fd = new FornecedoresDAO();
	comboFornecedores = fd.listar();
		
		
		}
		catch(Exception e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
			
			
		}
	}
	
		public void novo() {

			try {
				ProdutoDAO pd = new ProdutoDAO();
				pd.salvar(produtos);

				itens = pd.listar();

				JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso");

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	
		public void excluir() {

			try {
				ProdutoDAO fd = new ProdutoDAO();
				fd.excluir(produtos);

				itens = fd.listar();

				JSFUtil.adicionarMensagemSucesso("Produto excluido com sucesso");

			}

			catch (Exception e) {
				JSFUtil.adicionarMensagemErro("ex.getMessage()");
				e.printStackTrace();

			}

		}
	
	
	
		public void editar() {

			try {
				ProdutoDAO pd = new ProdutoDAO();
				pd.editar(produtos);

				itens = pd.listar();
				JSFUtil.adicionarMensagemSucesso("Editado com sucesso");

			} catch (Exception e) {

				e.printStackTrace();

				JSFUtil.adicionarMensagemErro("Falha na edição, contate o administrador do sistema.");

			}	
			
			
		}
	
		public void preparareditar() {
			
			try {
				produtos = new Produtos();
				FornecedoresDAO fd = new FornecedoresDAO();
				comboFornecedores = fd.listar();
					
					
					}
					catch(Exception e) {
						JSFUtil.adicionarMensagemErro("ex.getMessage()");
						e.printStackTrace();
						
						
					}
		
			
			
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
