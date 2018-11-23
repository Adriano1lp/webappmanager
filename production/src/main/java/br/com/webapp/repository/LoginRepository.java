package br.com.webapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.webapp.connection.ConnectionFactory;
import br.com.webapp.controller.Log;
import br.com.webapp.model.Login;


public class LoginRepository {
	
	Connection con;
	static String user;
	static String password;
	public LoginRepository() {
		con = ConnectionFactory.getConnection();
	}
	
	public Boolean verificaLogin(Login dados) {
		String sql = "select usuario, senha, perfil, status from usuario where usuario = ? and senha = ?  ";
		try{
			PreparedStatement  stmt = con.prepareStatement(sql);
			stmt.setString(1, dados.getUsuario());
			stmt.setString(2, dados.getSenha());
			stmt.execute();			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				user = dados.getUsuario();
				password = dados.getSenha();
				return true;
				
			}else {
	
				return false;
			}
			}catch (SQLException e) {
				String descricao = "Class LoginRepository, Metodo verificaLogin. SQLException";
				System.out.println("Erro ao buscar usuario e senha!!"+ descricao);
				Log.escreveLogErro(descricao);
				e.printStackTrace();
				return null;
			}
			
	}
	public List<Login> getLogin() {
		
		// Criando uma lista de material
		List<Login> listlogin = new ArrayList<>();
		
		
		String sql = "select usuario, senha, perfil, status from usuario where usuario = ? and senha = ?  ";
		try{
			PreparedStatement  stmt = con.prepareStatement(sql);
			stmt.setString(1, user);
			stmt.setString(2, password);
			stmt.execute();	
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()==true) {
				Login objeto = new Login();
				objeto.setUsuario(rs.getString("usuario"));
				objeto.setSenha(rs.getString("senha"));
				objeto.setStatus(rs.getString("status"));
				objeto.setPerfil(rs.getString("perfil"));
				listlogin.add(objeto);
				rs.close();
				stmt.close();
				return listlogin;
			}else {
				System.out.println("Usuario não localizado!!");
				return null;
			}
			
		}catch (SQLException e) {
			String descricao = "Class LoginRepository, Metodo List<Login> getLogin. SQLException";
			System.out.println("Erro ao buscar usuario e senha!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return null;
		}
		

	}
	
	
}
