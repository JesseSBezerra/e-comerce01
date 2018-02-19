package br.com.ecomerce.negocio.produto.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.negocio.produto.controller.ProdutoControler;
import br.com.ecomerce.negocio.produto.model.Produto;

@ManagedBean
@ViewScoped
public class ProdutoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Produto produto;
	private Produto produtoSelecionado;
	
	private ProdutoControler produtoControler;
	
	@SuppressWarnings("unused")
	private List<Produto> listaProdutos;
	private List<Produto> listaFiltro;
	
	public ProdutoMB() {
		// TODO Auto-generated constructor stub
		produto = new Produto();
		produtoSelecionado = new Produto();
		produtoControler = new ProdutoControler();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	public List<Produto> getListaProdutos() {
		return this.produtoControler.listarProdutos();
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public void salvar(){
		this.produtoControler.salvarProduto(produto);
		this.limpar();
	}
	
	public void remover(){
		this.produtoControler.remover(produto);
		this.limpar();
	}
	
	public void limpar(){
		this.produtoSelecionado = new Produto();
		this.produto = new Produto();
	}

	public List<Produto> getListaFiltro() {
		return listaFiltro;
	}

	public void setListaFiltro(List<Produto> listaFiltro) {
		this.listaFiltro = listaFiltro;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
	public void onRowSelect() {  
        setProduto(produtoSelecionado);
    }
	
	public void setProdutoVisao(Produto produto) {
		this.produto = produto;
	}
	

}
