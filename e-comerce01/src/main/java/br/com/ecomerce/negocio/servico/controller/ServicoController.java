package br.com.ecomerce.negocio.servico.controller;

import java.io.Serializable;
import java.util.List;

import br.com.ecomerce.infra.banco.dao.Dao;
import br.com.ecomerce.infra.banco.dao.DaoImp;
import br.com.ecomerce.negocio.servico.model.Servico;

public class ServicoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Dao<Servico> dao;
	
	public ServicoController() {
		// TODO Auto-generated constructor stub
		dao = new DaoImp<Servico>(Servico.class);
	}
	
	public void salvar(Servico servico){
		try {
			if(servico.getCdServico()==null){
			dao.salvar(servico);
			}else{
		    dao.atualizar(servico);	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void remover(Servico servico){
		try {
			dao.excluir(servico);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public List<Servico> getServicos(){
    	List<Servico> lista = null;
		try {
			lista =	dao.listar(Servico.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
    	return lista;
    }
    
    
	

}
