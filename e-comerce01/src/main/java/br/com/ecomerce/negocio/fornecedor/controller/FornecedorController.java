package br.com.ecomerce.negocio.fornecedor.controller;

import java.io.Serializable;

import br.com.ecomerce.infra.banco.dao.crud.BaseCrud;
import br.com.ecomerce.negocio.fornecedor.model.Fornecedor;

public class FornecedorController extends BaseCrud<Fornecedor> implements
		Serializable {

	public FornecedorController() {
		super(Fornecedor.class);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
