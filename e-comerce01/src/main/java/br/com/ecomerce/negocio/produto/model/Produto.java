package br.com.ecomerce.negocio.produto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TBL_PRODUTO")
@SequenceGenerator(name="SEQ_PRODUTO",sequenceName="SEQ_PRODUTO")
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="SEQ_PRODUTO")
	@Column(name="CD_PRODUTO")
	private Long cdProduto;
	
	@Column(name="DS_PRODUTO")
	private String dsProduto;
	
	@Column(name="SN_CONTROLA_LOTE",length=1)
	private String snControlaLote;
	
	@Column(name="SN_CONTROLA_VALIDADE",length=1)
	private String snControlaValidade;
	
	@Column(name="TP_PRODUTO")
	private String tpProduto;
	
	@Column(name="VL_CUSTO_COMPRA")
	private Double vlCustoCompra;
	
	public Produto(Long cdProduto, String dsProduto, String snControlaLote,
			String snControlaValidade, String tpProduto) {
		super();
		this.cdProduto = cdProduto;
		this.dsProduto = dsProduto.toUpperCase();
		this.snControlaLote = snControlaLote;
		this.snControlaValidade = snControlaValidade;
		this.tpProduto = tpProduto;
	}
	
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(Long cdProduto) {
		this.cdProduto = cdProduto;
	}

	public String getDsProduto() {
		return dsProduto;
	}

	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto.toUpperCase();
	}

	public String getSnControlaLote() {
		return snControlaLote;
	}

	public void setSnControlaLote(String snControlaLote) {
		this.snControlaLote = snControlaLote;
	}

	public String getSnControlaValidade() {
		return snControlaValidade;
	}

	public void setSnControlaValidade(String snControlaValidade) {
		this.snControlaValidade = snControlaValidade;
	}

	public String getTpProduto() {
		return tpProduto;
	}

	public void setTpProduto(String tpProduto) {
		this.tpProduto = tpProduto;
	}

	public Double getVlCustoCompra() {
		return vlCustoCompra;
	}

	public void setVlCustoCompra(Double vlCustoCompra) {
		this.vlCustoCompra = vlCustoCompra;
	}
	
	
	
	
	

}
