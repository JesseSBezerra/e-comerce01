package br.com.ecomerce.infra.banco.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	 private static final SessionFactory sessionFactory;
	    static {
	        try {
	            sessionFactory = new Configuration().configure().buildSessionFactory();
	        } catch (Throwable t) {
	            Exception exception = new Exception("Falha ao criar o SessionFactory. ", t);
	            throw new ExceptionInInitializerError(exception);
	        }
	    }
	 
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	 
	    public static void closeSession(Session session) {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	 
	    public static void rollbackTransaction(Transaction transaction) {
	        if (transaction != null && !transaction.wasCommitted() && !transaction.wasRolledBack()) {
	            transaction.rollback();
	        }
	    }
	    
	    public static void main(String[] args) {
			Session session = null;
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				System.out.println("Conectou");
			}catch(Exception e){
				System.out.println("Não conectou");
				e.getStackTrace();
			}finally{
				session.close();
			}
			
		}
}
