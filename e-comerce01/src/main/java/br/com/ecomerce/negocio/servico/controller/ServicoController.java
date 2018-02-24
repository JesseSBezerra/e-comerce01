package br.com.ecomerce.negocio.servico.controller;

import java.io.Serializable;
import java.util.List;

import br.com.ecomerce.infra.banco.dao.Dao;
import br.com.ecomerce.infra.banco.dao.DaoImp;
import br.com.ecomerce.infra.banco.dao.crud.BaseCrud;
import br.com.ecomerce.negocio.servico.model.Servico;

public class ServicoController extends BaseCrud<Servico> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ServicoController() {
		super(Servico.class);
	}
    
   
    
    
	

}
