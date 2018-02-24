package br.com.ecomerce.infra.banco.dao.crud;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.ecomerce.infra.banco.dao.Dao;
import br.com.ecomerce.infra.banco.dao.DaoImp;

public abstract class BaseCrud<T extends Serializable> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Dao<T> dao;
	private Class<T> classe;
	public BaseCrud(Class<T> classe) {
		// TODO Auto-generated constructor stub
		this.classe = classe;
		dao = new DaoImp<T>(classe);
	}
	
	public void salvar(T t){
		 try {
			dao.salvar(t);
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aten��o", "Registro salvo com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, fm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aten��o", e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, fm);
		}
		
	}
	
	public void atualizar(T t){
		 try {
				dao.atualizar(t);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void remover(T t){
		 try {
				dao.atualizar(t);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public List<T> getLitsta(){
		List<T> lista = null; 
		try {
			lista = dao.listar(classe);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return lista;
	}
	
	

}
