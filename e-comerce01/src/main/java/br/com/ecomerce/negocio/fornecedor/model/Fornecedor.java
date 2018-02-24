package br.com.ecomerce.negocio.fornecedor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TBL_FORNECEDOR")
@SequenceGenerator(name="SEQ_FORNECEDOR",sequenceName="SEQ_FORNECEDOR")
public class Fornecedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="SEQ_FORNECEDOR")
	@Column(name="CD_FORNECEDOR")
	private Long cdFornecedor;
	
	@Column(name="NM_FORNECEDOR")
	private String nmFornecedor;
	
	@Column(name="DS_EMAIL_FORNECEDOR")
	private String dsEmailFornecedor;
	
	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}

	public Long getCdFornecedor() {
		return cdFornecedor;
	}

	public void setCdFornecedor(Long cdFornecedor) {
		this.cdFornecedor = cdFornecedor;
	}

	public String getNmFornecedor() {
		return nmFornecedor;
	}

	public void setNmFornecedor(String nmFornecedor) {
		this.nmFornecedor = nmFornecedor;
	}

	public String getDsEmailFornecedor() {
		return dsEmailFornecedor;
	}

	public void setDsEmailFornecedor(String dsEmailFornecedor) {
		this.dsEmailFornecedor = dsEmailFornecedor;
	}
	
	

}
