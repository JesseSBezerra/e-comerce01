package br.com.ecomerce.infra.properties;

import java.util.ResourceBundle;

public class PropertiesUtil {
    public static ResourceBundle prop = ResourceBundle.getBundle("mensagens_projeto");
	
	public static String getProp(String key){
		return prop.getString(key);
	}
}
