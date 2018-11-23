package br.com.webapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.webapp.connection.ConnectionFactory;
import br.com.webapp.controller.Log;
import br.com.webapp.model.Cq;

public class CqRepository {
	
	Connection con;
	public String login;
	
	public CqRepository() {
		con = ConnectionFactory.getConnection();
	}
	
	public void setValores(Cq dados) {
		this.login = dados.login;
	}
	
	public Boolean adicionaCq(Cq dados) {
		String sql = "select * from equipamento where ( serie = ? or casid = ? ) and saida = ?";
		try {
			PreparedStatement  stmt = con.prepareStatement(sql);
			stmt.setString(1, dados.getSerie());
			stmt.setString(2, dados.getSerie());
			stmt.setString(3, "false");
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String sql1 = "update equipamento set usuariocq = ?, datacq = ?, statuscq = ?, observacaocq = ? where ( serie = ? or casid = ? ) and saida = ?";
				PreparedStatement  stmt1 = con.prepareStatement(sql1);
				stmt1.setString(1, dados.getLogin());
				stmt1.setString(2, dados.getData());
				stmt1.setString(3, dados.getStatuscq());
				stmt1.setString(4, dados.getObservacaocq());
				stmt1.setString(5, dados.getSerie());
				stmt1.setString(6, dados.getSerie());
				stmt1.setString(7, "false");
				stmt1.execute();
				stmt1.close();
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			String descricao = "Class ReparoRepository, Metodo adicionaReparo. SQLException";
			System.out.println("Erro ao inserir dados no banco de dados!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Cq> selectCqAdicionado(){
		List<Cq> material = new ArrayList<>();
		String sql = "select serie, statuscq, observacaocq, datacq from equipamento where usuariocq = ? and saida = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, this.login);
			stmt.setString(2, "false");
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cq objeto = new Cq();
				objeto.setSerie(rs.getString("serie"));
				objeto.setStatuscq(rs.getString("statuscq"));
				objeto.setObservacaocq(rs.getString("observacaocq"));
				objeto.setData(rs.getString("datacq"));
				material.add(objeto);
				
			}
			rs.close();
			stmt.close();
			return material;
			
		}catch (SQLException e ) {
			String descricao = "Metodo selectCqAdicionado. SQLException";
			System.out.println("Erro ao inserir dados no banco de dados!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	

}
