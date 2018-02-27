package br.com.ecomerce.infra.json;

import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class JsonUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JsonArray getArray(URL url){
		JsonArray array = null;
		try{
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setRequestProperty("Content-Type", "application/json");
			InputStream is = conn.getInputStream();
			JsonReader rdr = Json.createReader(is);
			JsonObject obj = rdr.readObject();
			array = obj.getJsonArray("items");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return array;
	}
}
