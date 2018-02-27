package br.com.ecomerce.negocio.prodfor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProdForId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="CD_PRODUTO")
	private Long cdProduto;
	
	@Column(name="CD_FORNECEDOR")
	private Long cdFornecedor;

	
	public ProdForId() {
		super();
	}

	public ProdForId(Long cdProduto, Long cdFornecedor) {
		super();
		this.cdProduto = cdProduto;
		this.cdFornecedor = cdFornecedor;
	}



	public Long getCdProduto() {
		return cdProduto;
	}


	public void setCdProduto(Long cdProduto) {
		this.cdProduto = cdProduto;
	}


	public Long getCdFornecedor() {
		return cdFornecedor;
	}


	public void setCdFornecedor(Long cdFornecedor) {
		this.cdFornecedor = cdFornecedor;
	}


	
	
	
	

}
