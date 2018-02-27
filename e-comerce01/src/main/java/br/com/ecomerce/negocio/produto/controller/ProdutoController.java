package br.com.ecomerce.negocio.produto.controller;

import br.com.ecomerce.infra.crud.AbstractController;
import br.com.ecomerce.integracao.wallmart.WallmartIntegra;

public class ProdutoController implements AbstractController {

	private WallmartIntegra integra; 
	
	public ProdutoController() {
		// TODO Auto-generated constructor stub
		integra = new WallmartIntegra();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void executeControler() {
		// TODO Auto-generated method stub
		integra.chargeWallMart();
		
	}

}
