package br.com.ecomerce.negocio.servico.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TBL_SERVICO")
@SequenceGenerator(name="SEQ_SERVICO",sequenceName="SEQ_SERVICO")
public class Servico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="SEQ_SERVICO")
	@Column(name="CD_SERVICO")
	private Long cdServico;
	
	@Column(name="DS_SERVICO")
	private String dsServico;
	
	@Column(name="TP_SERVICO")
	private String tpServico;

	public Servico() {
		// TODO Auto-generated constructor stub
	}
	
	public Servico(Long cdServico, String dsServico, String tpServico) {
		super();
		this.cdServico = cdServico;
		this.dsServico = dsServico;
		this.tpServico = tpServico;
	}

	public Long getCdServico() {
		return cdServico;
	}

	public void setCdServico(Long cdServico) {
		this.cdServico = cdServico;
	}

	public String getDsServico() {
		return dsServico;
	}

	public void setDsServico(String dsServico) {
		this.dsServico = dsServico;
	}

	public String getTpServico() {
		return tpServico;
	}

	public void setTpServico(String tpServico) {
		this.tpServico = tpServico;
	}
	
	
	

}
