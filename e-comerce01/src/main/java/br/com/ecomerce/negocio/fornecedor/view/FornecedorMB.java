package br.com.ecomerce.negocio.fornecedor.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.negocio.fornecedor.controller.FornecedorController;
import br.com.ecomerce.negocio.fornecedor.model.Fornecedor;

@ManagedBean
@ViewScoped
public class FornecedorMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FornecedorController controller;
	private Fornecedor fornecedor;
	
	public FornecedorMB() {
		// TODO Auto-generated constructor stub
		controller = new FornecedorController();
		setFornecedor(new Fornecedor());
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public void salvar(){
		controller.salvar(fornecedor);
		limpar();
	}
	
	public void limpar(){
		setFornecedor(new Fornecedor());
	}
	

}
