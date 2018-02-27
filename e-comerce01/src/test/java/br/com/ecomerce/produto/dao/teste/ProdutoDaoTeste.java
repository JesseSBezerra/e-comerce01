package br.com.ecomerce.produto.dao.teste;

import br.com.ecomerce.infra.banco.dao.Dao;
import br.com.ecomerce.infra.banco.dao.DaoImp;
import br.com.ecomerce.negocio.produto.model.Produto;

public class ProdutoDaoTeste {

	private Dao<Produto> dao;
	
	public ProdutoDaoTeste() {
		// TODO Auto-generated constructor stub
		dao = new DaoImp<Produto>(Produto.class);
	}
	
	public void cadastarProduto() throws Exception{
		Produto produto = new Produto(1L, "Feij�o tio jo�o", "S", "S", "P");
		dao.atualizar(produto);
	}
	
	public void listar(){
//		ProdutoControler produtoControler = new ProdutoControler();
//		for(Produto produto : produtoControler.listarProdutos()){
//			System.out.println(produto.getDsProduto());
//		}
	}
	
	public static void main(String[] args) {
		ProdutoDaoTeste daoTeste = new ProdutoDaoTeste();
		daoTeste.listar();
	}

}
