package br.com.ecomerce.infra.crud;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

public abstract class AbstractBean <T extends Serializable> extends AbstractCrud<T> implements Serializable {

	private AbstractController controller;
	public AbstractBean(Class<T> classe,AbstractController controller) {
		super(classe);
		this.controller = controller;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T t;
	private T objetoSelecionado;
	private List<T> listaFiltro;
	
	public abstract T getInstance();
	public abstract void clear();
	public abstract void onRowSelect();
	
	public void salvar(){
		this.t = getInstance();
		try {
			super.salvar(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(){
		this.t = getInstance();
		try {
			super.salvar(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<T> getLista(){
		List<T> lista = null;
		try {
			lista = super.getLitsta();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
		
	}

	public List<T> getListaFiltro() {
		return listaFiltro;
	}

	public void setListaFiltro(List<T> listaFiltro) {
		this.listaFiltro = listaFiltro;
	}

	public T getObjetoSelecionado() {
		return objetoSelecionado;
	}

	public void setObjetoSelecionado(T objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}
	
	public void execute(){
		this.controller.executeControler();
	}
	
	public void executeReport(){
		try {
			super.prepareReport();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
