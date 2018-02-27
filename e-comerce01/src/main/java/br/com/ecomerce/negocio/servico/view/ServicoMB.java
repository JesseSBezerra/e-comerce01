package br.com.ecomerce.negocio.servico.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.infra.crud.AbstractBean;
import br.com.ecomerce.negocio.servico.model.Servico;

@ManagedBean
@ViewScoped
public class ServicoMB extends AbstractBean<Servico>{

	/**
	 * 
	 */
	private Servico servico;
	
	private static final long serialVersionUID = 1L;

	public ServicoMB() {
		super(Servico.class);
	}

	@Override
	public Servico getInstance() {
		// TODO Auto-generated method stub
		try{
		return this.servico;
		}finally{
			clear();
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.servico = new Servico();
	}

	@Override
	public void onRowSelect() {
		// TODO Auto-generated method stub
		setServico(getObjetoSelecionado());
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}



	

}
