package br.com.ecomerce.json.teste;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;


public class JsonTeste {

public static void main(String[] args) throws IOException {
	URL url = new URL("https://api.mercadolibre.com/sites/MLB/search?q=tv");
	 try (InputStream is = url.openStream();
	      JsonReader rdr = Json.createReader(is)) {
	 
	      JsonObject obj = rdr.readObject();
	      JsonArray results = obj.getJsonArray("data");
//	      for (JsonObject result : results.getValuesAs(JsonObject.class)) {
//	          System.out.print(result.getJsonObject("from").getString("name"));
//	          System.out.print(": ");
//	         System.out.println(result.getString("message", ""));
//	         System.out.println("-----------");
//	     }
	 }
}	
}
