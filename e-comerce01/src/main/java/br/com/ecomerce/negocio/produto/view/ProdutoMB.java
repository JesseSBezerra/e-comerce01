package br.com.ecomerce.negocio.produto.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.infra.report.bean.AbstractReportBean;
import br.com.ecomerce.negocio.produto.controller.ProdutoControler;
import br.com.ecomerce.negocio.produto.model.Produto;

@ManagedBean
@ViewScoped
public class ProdutoMB extends AbstractReportBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Produto produto;
	private Produto produtoSelecionado;

	private ProdutoControler produtoControler;
	private final String COMPILE_FILE_NAME = "produtos";

	@SuppressWarnings("unused")
	private List<Produto> listaProdutos;
	private List<Produto> listaFiltro;
	private boolean isChargeDisabled;

	@PostConstruct
	public void init() {
		produto = new Produto();
		produtoSelecionado = new Produto();
		produtoControler = new ProdutoControler();
		getChargeEnabled();
	}

	private void getChargeEnabled() {
		if (this.produtoControler.listarProdutos() != null && this.produtoControler.listarProdutos().size() > 10) {
			this.isChargeDisabled = true;
		} else {
			this.isChargeDisabled = false;
		}
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

	public void salvar() {
		this.produtoControler.salvarProduto(produto);
		this.limpar();
	}

	public void remover() {
		this.produtoControler.remover(produto);
		this.limpar();
	}

	public void limpar() {
		this.produtoSelecionado = new Produto();
		this.produto = new Produto();
	}

	public void gerarCarga() {
		this.produtoControler.gerarCargaInicial();
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

	public boolean isChargeDisabled() {
		return isChargeDisabled;
	}

	public void setChargeDisabled(boolean isChargeDisabled) {
		this.isChargeDisabled = isChargeDisabled;
	}

	@Override
	protected String getCompileFileName() {
		return COMPILE_FILE_NAME;
	}

	  public String execute() {
		try {
			super.prepareReport();
		} catch (Exception e) {
			// make your own exception handling
			e.printStackTrace();
		}

		return null;
	}

}
