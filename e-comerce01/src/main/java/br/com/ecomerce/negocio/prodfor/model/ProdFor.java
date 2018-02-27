package br.com.ecomerce.negocio.prodfor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.ecomerce.negocio.fornecedor.model.Fornecedor;
import br.com.ecomerce.negocio.produto.model.Produto;

@Entity
@Table(name = "PROD_FOR")
@SequenceGenerator(name = "SEQ_PROD_FOR", sequenceName = "SEQ_PROD_FOR")
public class ProdFor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProdForId prodForId;

	@ManyToOne
	@JoinColumn(name = "CD_FORNECEDOR", referencedColumnName = "CD_FORNECEDOR", nullable = false, updatable = false, insertable = false)
	private Fornecedor fornecedor;

	@ManyToOne
	@JoinColumn(name = "CD_PRODUTO", referencedColumnName = "CD_PRODUTO", nullable = false, updatable = false, insertable = false)
	private Produto produto;

	@Column(name = "SN_ATIVO", length = 1)
	private String snAtivo;

	public ProdForId getProdForId() {
		return prodForId;
	}

	public void setProdForId(ProdForId prodForId) {
		this.prodForId = prodForId;
	}

	public String getSnAtivo() {
		return snAtivo;
	}

	public void setSnAtivo(String snAtivo) {
		this.snAtivo = snAtivo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
