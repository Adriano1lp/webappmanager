package br.com.webapp.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.webapp.controller.Log;
/**
 * Class que configura e abre a conexão com o banco de dados.
 * Data de Edição: 24/09/2018
 * @author Adriano Lima Pereira
 * @version 1.0
 */
public class ConnectionFactory {
	
	static String hostName = "localhost:3306";
	static String dbName = "db_controle";
	static String user = "root";
	static String password = "usuario123";
    static String url = String.format("jdbc:mysql://"+hostName+"/"+dbName+"?useTimezone=true&serverTimezone=UTC");
    static Connection connection = null;
	
    /**
     * Metodo carrega driver e abre conexão.
     * Data de Edição: 24/09/2018
     * @param driver jdbc mysql, dados de conexão
     * @return conexão aberta
     * 
     */
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			String descricao = "Class ConnectionFactory, Metodo getConnection";
			System.out.println("Erro ao carregar Drver de Conexão!! "+ descricao);
			Log.escreveLogErro(descricao);
			e1.printStackTrace();
		}
		
		try {
			System.out.println("Conexão Aberta!");
			return DriverManager.getConnection(url, user, password);
			
		}catch (SQLException e) {  
	        // Could not connect to the database 
			String descricao = "Class ConnectionFactory, Metodo getConnection";
			System.out.println("Erro ao conectar com banco!! "+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return null;
	    }
		
		
	}
	
	/**
	 * Metodo de fechamento de conexão
	 * @param connection.close()
	 * @return connection close
	 */
	public static Connection fechaConexao(){
		try {
			connection.close();
			System.out.println("Conexão Fechada!");
			return connection;
		}catch (SQLException e) {  
	        // Could not connect to the database 
	    	throw new RuntimeException(e);
	    }
		
	}

}

