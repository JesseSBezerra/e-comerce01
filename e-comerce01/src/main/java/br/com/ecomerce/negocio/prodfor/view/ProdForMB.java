package br.com.ecomerce.negocio.prodfor.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.infra.crud.AbstractBean;
import br.com.ecomerce.negocio.fornecedor.model.Fornecedor;
import br.com.ecomerce.negocio.prodfor.model.ProdFor;
import br.com.ecomerce.negocio.prodfor.model.ProdForId;
import br.com.ecomerce.negocio.produto.model.Produto;

@ManagedBean
@ViewScoped
public class ProdForMB extends AbstractBean<ProdFor>{

	private ProdFor prodFor;
	private Produto produto;
	private Fornecedor fornecedor;
	
	private List<Produto> produtos;
    private List<Fornecedor> fornecedores;
        
	@SuppressWarnings("unchecked")
	public ProdForMB() {
		super(ProdFor.class);
		// TODO Auto-generated constructor stub
		this.produtos = getListByObject(Produto.class);
		this.fornecedores = getListByObject(Fornecedor.class);
		this.prodFor = new ProdFor();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public List<Produto> complete(String query){
		List<Produto> lista = new ArrayList<>();
	    for(Produto produto:this.produtos){
	    	if(produto.getDsProduto().contains(query.toUpperCase())){
	    		lista.add(produto);
	    	}
	    }
	    return lista;
	}
	
	public List<Fornecedor> completeFor(String query){
		List<Fornecedor> lista = new ArrayList<>();
	    for(Fornecedor produto:this.fornecedores){
	    	if(produto.getNmFornecedor().toUpperCase().contains(query.toUpperCase())){
	    		lista.add(produto);
	    	}
	    }
	    return lista;
	}

	@Override
	public ProdFor getInstance() {
		// TODO Auto-generated method stub
        this.prodFor.setProdForId(new ProdForId(this.produto.getCdProduto(),this.fornecedor.getCdFornecedor()));
		return this.prodFor;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		setProdFor(new ProdFor());
		setProduto(null);
		setFornecedor(null);
		
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
		setProdFor(this.getObjetoSelecionado());
		
	}

	public ProdFor getProdFor() {
		return prodFor;
	}

	public void setProdFor(ProdFor prodFor) {
		this.prodFor = prodFor;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	

}
