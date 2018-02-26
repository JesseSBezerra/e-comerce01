package br.com.ecomerce.infra.crud;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.ecomerce.infra.banco.dao.Dao;
import br.com.ecomerce.infra.banco.dao.DaoImp;
import br.com.ecomerce.infra.report.bean.AbstractReportBean;

public abstract class AbstractCrud<T extends Serializable> extends AbstractReportBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Dao<T> dao;
	private Class<T> classe;
	public AbstractCrud(Class<T> classe) {
		// TODO Auto-generated constructor stub
		this.classe = classe;
		dao = new DaoImp<T>(classe);
	}
	
	public void salvar(T t){
		try {
			dao.salvar(t);
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atenção", "Registro salvo com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, fm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção", e.getMessage());
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
	
	public void remover(T entidade){
		 try {
			 dao.excluir(entidade);
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
	
	public String getCompileFileName(){
	return classe.getSimpleName().toLowerCase();	
	}

}
