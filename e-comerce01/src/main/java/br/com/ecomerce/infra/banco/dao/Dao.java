package br.com.ecomerce.infra.banco.dao;


import java.io.Serializable;
import java.util.List;

public interface Dao <T extends Serializable> extends Serializable{

	public void salvar(T entidade) throws Exception;
	 
	public void atualizar(T entidade) throws Exception;
	
	public List<T> listar(Class<T> classe) throws Exception;
	
	public List<T> getListByObject(Class<?> classe) throws Exception;
	
	public boolean existe(T entidade) throws Exception;
	
	public void excluir(T entidade) throws Exception;
	
	public T obterPorId(Object id) throws Exception;
	
}
