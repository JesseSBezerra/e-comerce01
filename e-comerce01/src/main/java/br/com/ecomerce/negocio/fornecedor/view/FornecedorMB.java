package br.com.ecomerce.negocio.fornecedor.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.infra.crud.AbstractBean;
import br.com.ecomerce.negocio.fornecedor.controller.FornecedorController;
import br.com.ecomerce.negocio.fornecedor.model.Fornecedor;

@ManagedBean
@ViewScoped
public class FornecedorMB extends AbstractBean<Fornecedor> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Fornecedor fornecedor;
	
	public FornecedorMB() {
		super(Fornecedor.class, new FornecedorController());
		fornecedor = new Fornecedor();
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
		
	}
		
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	

	@Override
	public Fornecedor getInstance() {
		// TODO Auto-generated method stub
		try{
			return this.fornecedor;
			}finally {
				clear();
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.fornecedor = new Fornecedor();
		
	}

	@Override
	public void onRowSelect() {
		// TODO Auto-generated method stub
		setFornecedor(super.getObjetoSelecionado());
		
	}
	

}
