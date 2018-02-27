package br.com.ecomerce.negocio.produto.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.infra.crud.AbstractBean;
import br.com.ecomerce.negocio.produto.controller.ProdutoController;
import br.com.ecomerce.negocio.produto.model.Produto;

@ManagedBean
@ViewScoped
public class ProdutoMB extends AbstractBean<Produto>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Produto produto;

	public ProdutoMB() {
		super(Produto.class, new ProdutoController());
		// TODO Auto-generated constructor stub
		produto = new Produto();
	}
	@Override
	public Produto getInstance() {
		return this.produto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public void onRowSelect() {
		// TODO Auto-generated method stub
		setProduto(this.getObjetoSelecionado());
		
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		setProduto(new Produto());
	}	
	

}
