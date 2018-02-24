package br.com.ecomerce.infra.banco.dao.crud;

import java.io.Serializable;
import java.util.List;

import br.com.ecomerce.infra.banco.dao.Dao;
import br.com.ecomerce.infra.banco.dao.DaoImp;

public abstract class BaseCrud2<T extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Class<T> classe;
	private Dao<T> dao;
	
	public BaseCrud2(Class<T> classe) {
		this.classe = classe;
		this.dao = new DaoImp<T>(classe);
	}
	public void salvar(T entidade){
		try {
			dao.salvar(entidade);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void atualizar(T entidade){
		try {
			dao.atualizar(entidade);
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
	public List<T> listar(){
		List<T> lista = null;
		try {
			lista = dao.listar(classe);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	
	
	
}
