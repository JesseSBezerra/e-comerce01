package br.com.ecomerce.json.teste;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;


public class JsonTeste {

public static void main(String[] args) throws IOException {
	try{
		URL url = new URL("http://api.walmartlabs.com/v1/search?query=tv&format=json&apiKey=k4fkjg3q2n972dawavvkj7jd");
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestProperty("Content-Type", "application/json");
		InputStream is = conn.getInputStream();
		JsonReader rdr = Json.createReader(is);
		JsonObject obj = rdr.readObject();
		
		javax.json.JsonArray array = obj.getJsonArray("items");
		for(int i = 0; i < array.size(); i++){
		System.out.println(array.getJsonObject(i).getString("name").replaceAll("\"", ""));	
		}
		System.out.println(obj);
		

	}catch(Exception e){
		e.printStackTrace();
	}
}	
}
