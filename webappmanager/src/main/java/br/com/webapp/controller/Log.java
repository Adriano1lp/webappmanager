package br.com.webapp.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Class Log com metodos responsaveis por registrar erros no sistema
 * Essa class é chamada quando há uma exception, os detalhes da exception são gravados no arquivo errolog.txt
 * Data de Edição: 24/09/2018
 * @author Adriano Lima Pereira
 * @version 1.0
 */
public class Log {	
	
	/**
	 * Metodo que cria, no caso de não existir, e escreve no arquivo errolog.txt
	 * Data de Edição: 24/09/2018
	 * @param abre arquivo no local definido e adiciona nova linha de informação
	 * @return null
	 */
	public static void escreveLogErro(String erro) {
		Date data = new Date();
		try{
			String newLine = System.getProperty("line.separator");
			FileWriter fw = new FileWriter("log/erroLog.txt", true);
		
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			out.append(">> "+erro+" Date: "+data+newLine);
			out.close();
			

		} catch (IOException e) {
			// Could not connect to the database 
			System.out.println("Erro ao escrever Exception: Metodo escreveLogErro, class Log.");
			e.printStackTrace();
		}
		
	}

}
