package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {

	private Fornecedores fornecedores;
	private ArrayList<Fornecedores> itens;
	private ArrayList<Fornecedores> itensfiltrados;

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	public ArrayList<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fornecedores> itens) {
		this.itens = itens;
	}

	public ArrayList<Fornecedores> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<Fornecedores> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			FornecedoresDAO fd = new FornecedoresDAO();
			itens = fd.listar();

		}

		catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}

	}

	public void preparanovo() {

		fornecedores = new Fornecedores();

	}

	public void novo() {

		try {
			FornecedoresDAO fd = new FornecedoresDAO();
			fd.salvar(fornecedores);

			itens = fd.listar();

			JSFUtil.adicionarMensagemSucesso("Fornecedor salvo com sucesso");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void excluir() {

		try {
			FornecedoresDAO fd = new FornecedoresDAO();
			fd.excluir(fornecedores);

			itens = fd.listar();

			JSFUtil.adicionarMensagemSucesso("Fornecedor excluido com sucesso");

		}

		catch (Exception e) {
			JSFUtil.adicionarMensagemErro("Não é possivel excluir um fornecedor que tenha um produto associado.");
			e.printStackTrace();

		}

	}

	public void editar() {

		try {
			FornecedoresDAO fd = new FornecedoresDAO();
			fd.editar(fornecedores);

			itens = fd.listar();
			JSFUtil.adicionarMensagemSucesso("Editado com sucesso");

		} catch (Exception e) {

			e.printStackTrace();

			JSFUtil.adicionarMensagemErro("Falha na edição, contate o administrador do sistema.");

		}

	}

}
