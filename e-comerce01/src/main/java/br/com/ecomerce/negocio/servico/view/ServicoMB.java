package br.com.ecomerce.negocio.servico.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.negocio.servico.controller.ServicoController;
import br.com.ecomerce.negocio.servico.model.Servico;

@ManagedBean
@ViewScoped
public class ServicoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Servico servico;
	private ServicoController controller;
	private List<Servico> lista;
	
	@PostConstruct
	public void init(){
		servico = new Servico();
		controller = new ServicoController();
		lista = new ArrayList<Servico>();
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public ServicoController getController() {
		return controller;
	}

	public void setController(ServicoController controller) {
		this.controller = controller;
	}

	public List<Servico> getLista() {
		return lista;
	}

	public void setLista(List<Servico> lista) {
		this.lista = lista;
	}
	
	public void salvar(){
		this.controller.salvar(servico);
		limpar();
	}
	
	public void limpar(){
		this.servico = new Servico();
	}

}
