package br.com.ecomerce.infra.banco.dao;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

import br.com.ecomerce.infra.banco.hibernate.HibernateUtil;




public class DaoImp<T extends Serializable> implements Dao<T> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7730986088751058842L;
	
	private Class<T> entidade;

	public Session getSession(){
		return HibernateUtil.getSessionFactory().openSession();
	}
	
	public DaoImp(Class<T> classeEntidade) {
	    this.entidade = classeEntidade;
	}

	public void salvar(T entidade) throws Exception {
		Session session = null;
        Transaction transaction = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            session.save(entidade);
            transaction.commit();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction(transaction);
            HibernateUtil.closeSession(session);
            throw new Exception(e.getMessage());
        } finally {
            HibernateUtil.closeSession(session);
        }
		
	}
	
	public void excluir(T entidade) throws Exception {
		  Session session = null;
	        Transaction transaction = null;
	        try {
	            session = getSession();
	            transaction = session.beginTransaction();
	            session.delete(entidade);
	            transaction.commit();
	        } catch (Exception e) {
	            HibernateUtil.rollbackTransaction(transaction);
	            HibernateUtil.closeSession(session);
	            throw new Exception("Erro no metodo: public void remover(T entidade).", e);
	        } finally {
	            HibernateUtil.closeSession(session);
	        }
		
	}
	
	
	@SuppressWarnings("unchecked")
	public T obterPorId(Object id) throws Exception {
		 Session session = null;
	        Object objeto = null;
	        try {
	            session = getSession();
	            objeto = session.get(this.entidade, (Serializable) id);
	            HibernateUtil.closeSession(session);
	        } catch (Exception e) {
	            throw new Exception("Erro no metodo: public T buscarPorId(Object id)", e);
	        } finally {
	            HibernateUtil.closeSession(session);
	        }
	        return (T) objeto;
	}

	@SuppressWarnings("unchecked")
	public List<T> listar(Class<T> classe) throws Exception {
		List<T> lista = null;
		Transaction transaction = null;
		Session session = getSession();
		
		try{
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(classe);
			lista = criteria.addOrder(Order.asc("id")).list();
			transaction.commit();
		}catch(Exception e){
			throw new Exception("Erro no metodo:Listar", e);
        } finally {
            HibernateUtil.closeSession(session);
        }
		return lista;
	}
	
	public void atualizar(T entidade) throws Exception {
		  Session session = null;
	        Transaction transaction = null;
	        try {
	            session = getSession();
	            transaction = session.beginTransaction();
	            session.update(entidade);
	            transaction.commit();
	        } catch (Exception e) {
	            HibernateUtil.rollbackTransaction(transaction);
	            HibernateUtil.closeSession(session);
	            throw new Exception("Erro ao atualizar Entidade.", e);
	        } finally {
	            HibernateUtil.closeSession(session);
	        }
	}

	public boolean existe(T entidade) throws Exception {
		@SuppressWarnings("unused")
		Transaction transaction = null;
		Session session = getSession();
		Criteria criteria = null;
		Collection<T> result = null; 
		try{
			transaction = session.beginTransaction();
			criteria = session.createCriteria(entidade.getClass());
			Example example = Example.create(entidade);
			example.enableLike(MatchMode.EXACT);
			example.excludeZeroes();
			criteria.add(example);
			result = consultar(criteria);
		}catch(Exception e){
			throw new Exception("Erro no metodo:Existe", e);
        } finally {
            HibernateUtil.closeSession(session);
        }
		return !result.isEmpty();
	}

	@SuppressWarnings("unchecked")
	protected Collection<T> consultar(Criteria criteria) {
		Collection<T> colecao = criteria.list();
		return colecao;
	}
	
	public void salvar(String... x){
		
	}
	
	public  void main() {
		String[] x = new String[1];
		x[0] = "A";
		salvar("A","B","C","D");
	}
}
