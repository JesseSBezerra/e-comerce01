package br.com.ecomerce.integracao.wallmart;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import br.com.ecomerce.infra.banco.dao.Dao;
import br.com.ecomerce.infra.banco.dao.DaoImp;
import br.com.ecomerce.infra.json.JsonUtil;
import br.com.ecomerce.negocio.produto.model.Produto;

public class WallmartIntegra implements Serializable{

	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
List<String> produtos;
  private final String key = "k4fkjg3q2n972dawavvkj7jd";
  private Dao<Produto> dao;
  private Produto produto;
  
  public WallmartIntegra() {
	// TODO Auto-generated constructor stub
	  dao = new DaoImp<Produto>(Produto.class);
	  produtos = new ArrayList<String>();
	  produtos.add("tv");
	  produtos.add("refrigerator");
	  produtos.add("washing%machine");
	  produtos.add("cooker");
	  produtos.add("closet");
	  produtos.add("smart%phone");
  }
  
  public void chargeWallMart(){
	  for (String produto:produtos){
	     try {
			JsonArray array = JsonUtil.getArray(new URL("http://api.walmartlabs.com/v1/search?query="+produto+"&format=json&apiKey="+key));
			for(int i = 0; i < array.size(); i++){
			this.produto = new Produto();
			this.produto.setDsProduto(array.getJsonObject(i).getString("name").replaceAll("\"", ""));
			this.produto.setVlCustoCompra(array.getJsonObject(i).getJsonNumber("salePrice").doubleValue());
			this.produto.setSnControlaLote("N");
			this.produto.setSnControlaValidade("N");
			this.produto.setTpProduto("PATRIMONIO");
			this.dao.salvar(this.produto);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  }
  
  public static void main(String[] args) {
		WallmartIntegra integra = new WallmartIntegra();
		integra.chargeWallMart();
	}
  
	
}
