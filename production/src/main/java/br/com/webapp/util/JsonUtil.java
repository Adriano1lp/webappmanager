package br.com.webapp.util;

import java.io.BufferedReader;
import java.io.IOException;

import br.com.webapp.controller.Log;
/**
 * Class JsonUtil responsaverl por ler a request e responce
 * @author adriano
 * Data Edi��o: 24/09/2018
 */
public class JsonUtil {
	/**
	 * Class JsonUtil
	 * Metodo lerJson usado na leitura de request no formato json
	 * @param reader
	 * @return
	 * Data Edi��o: 24/09/2018
	 */
	public static String lerJson(BufferedReader reader){
		
		StringBuffer json = new StringBuffer();
		String line = "";
		try {
			line = reader.readLine();
			while(line != null) {
				json.append(line);
				line = reader.readLine();
			
			}
		
		} catch (IOException e) {
			String descricao = "Class JsonUtil, Metodo lerJson. IOException";
			System.out.println("Erro na interpreta��o de json!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return null;
		}
		
		return json.toString();
	}
}
