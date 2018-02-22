package br.com.ecomerce.negocio.principal.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.ecomerce.negocio.servico.view.ServicoMB;

@ManagedBean
@SessionScoped
public class PrincipalMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{servicoB}")
	private ServicoMB servicoMB;

	public ServicoMB getServicoMB() {
		return servicoMB;
	}

	public void setServicoMB(ServicoMB servicoMB) {
		this.servicoMB = servicoMB;
	}
	
	

}

