package br.com.ecomerce.negocio.prodfor.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.ecomerce.infra.banco.dao.Dao;
import br.com.ecomerce.infra.banco.dao.DaoImp;
import br.com.ecomerce.negocio.produto.model.Produto;

@FacesConverter("produtoConverter")
public class ProdutoConverter implements Serializable, Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Dao<Produto> dao;
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		this.dao = new DaoImp<>(Produto.class); 
		List<Produto> lista = null;
		try {
			lista = dao.listar(Produto.class);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(value != null && value.trim().length() > 0) {
	            try {
	            	for(Produto Produto:lista){
	            		if(Produto.getDsProduto().equals(value)){
	            			return Produto;
	            		}
	            	}
	            } catch(NumberFormatException e) {
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
	            }
	        }
	        else {
	            return null;
	        }
		return lista;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if(object != null) {
            return String.valueOf(((Produto) object).getCdProduto());
        }
        else {
            return null;
        }
	}

}
