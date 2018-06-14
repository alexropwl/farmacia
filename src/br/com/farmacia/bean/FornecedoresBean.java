package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {

	private Fornecedores fornecedores;

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	private ListDataModel<Fornecedores> itens;

	public ListDataModel<Fornecedores> getItens() {

		return itens;
	}

	public void setItens(ListDataModel<Fornecedores> itens) {

		this.itens = itens;
	}

	@PostConstruct
	public void prepararPesquisa() {
        
		
		try {
			FornecedoresDAO fd = new FornecedoresDAO();
			ArrayList<Fornecedores> lista = fd.listar();

			itens = new ListDataModel<Fornecedores>(lista);

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

			ArrayList<Fornecedores> lista = fd.listar();

			itens = new ListDataModel<Fornecedores>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor salvo com sucesso");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
