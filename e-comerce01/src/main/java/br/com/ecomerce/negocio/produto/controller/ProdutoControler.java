package br.com.ecomerce.negocio.produto.controller;

import java.io.Serializable;
import java.util.List;

import br.com.ecomerce.infra.banco.dao.Dao;
import br.com.ecomerce.infra.banco.dao.DaoImp;
import br.com.ecomerce.integracao.wallmart.WallmartIntegra;
import br.com.ecomerce.negocio.produto.model.Produto;

public class ProdutoControler implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Dao<Produto> dao;
	private WallmartIntegra integra;
	
	public ProdutoControler() {
		// TODO Auto-generated constructor stub
		dao = new DaoImp<Produto>(Produto.class);
		integra = new WallmartIntegra();
	}
	
	public void salvarProduto(Produto produto){
		try {
		    if(produto.getCdProduto()==null){
			    dao.salvar(produto);
			}else{
				dao.atualizar(produto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void remover(Produto produto){
		try {
			dao.excluir(produto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Produto> listarProdutos(){
		List<Produto> lista = null;
		try {
			lista = dao.listar(Produto.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void gerarCargaInicial(){
		this.integra.chargeWallMart();
	}
	

}
