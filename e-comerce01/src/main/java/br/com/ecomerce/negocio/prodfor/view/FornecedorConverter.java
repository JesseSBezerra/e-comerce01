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
import br.com.ecomerce.negocio.fornecedor.model.Fornecedor;

@FacesConverter("fornecedorConverter")
public class FornecedorConverter implements Serializable, Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Dao<Fornecedor> dao;
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		this.dao = new DaoImp<>(Fornecedor.class); 
		List<Fornecedor> lista = null;
		try {
			lista = dao.listar(Fornecedor.class);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(value != null && value.trim().length() > 0) {
	            try {
	            	for(Fornecedor fornecedor:lista){
	            		if(fornecedor.getNmFornecedor().equals(value)){
	            			return fornecedor;
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
            return String.valueOf(((Fornecedor) object).getCdFornecedor());
        }
        else {
            return null;
        }
	}

}
