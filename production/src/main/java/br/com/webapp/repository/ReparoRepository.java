package br.com.webapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.webapp.connection.ConnectionFactory;
import br.com.webapp.controller.Log;
import br.com.webapp.model.Reparo;

public class ReparoRepository {
	Connection con;
	public String login;
	public String serie;
	public ReparoRepository() {
		con = ConnectionFactory.getConnection();
	}
	public void setValores(Reparo dados) {
		this.serie = dados.serie;
		this.login= dados.login;
	}
	public Boolean adicionaReparo(Reparo dados) {
		String sql = "select * from equipamento where ( serie = ? or casid = ? ) and saida = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, dados.getSerie());
			stmt.setString(2, dados.getSerie());
			stmt.setString(3, "false");
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				if(dados.getReparo()=="true") {
					String sql1 = "update equipamento set usuarioreparo = ?, datadiagnostico = ?, diagnostico = ?, statusreparo = ?, observacaoreparo = ? where ( serie = ? or casid = ? ) and saida = ?";
					PreparedStatement  stmt1 = con.prepareStatement(sql1);
					stmt1.setString(1, dados.getLogin());
					stmt1.setString(2, dados.getData());
					stmt1.setString(3, dados.getDefeito());
					stmt1.setString(4, "REPARADO");
					stmt1.setString(5, dados.getObservacao());
					stmt1.setString(6, dados.getSerie());
					stmt1.setString(7, dados.getSerie());
					stmt1.setString(8, "false");
					stmt1.execute();
					stmt1.close();
					return true;
				}
				if(dados.getTriagem()=="true") {
					String sql1 = "update equipamento set usuarioreparo = ?, datadiagnostico = ?, diagnostico = ?, statusreparo = ?, observacaoreparo = ? where ( serie = ? or casid = ? ) and saida = ?";
					PreparedStatement  stmt1 = con.prepareStatement(sql1);
					stmt1.setString(1, dados.getLogin());
					stmt1.setString(2, dados.getData());
					stmt1.setString(3, dados.getDefeito());
					stmt1.setString(4, "TRIAGEM");
					stmt1.setString(5, dados.getObservacao());
					stmt1.setString(6, dados.getSerie());
					stmt1.setString(7, dados.getSerie());
					stmt1.setString(8, "false");
					stmt1.execute();
					stmt1.close();
					return true;					
				}
				if(dados.getScr()=="true") {
					String sql1 = "update equipamento set usuarioreparo = ?, datadiagnostico = ?, diagnostico = ?, statusreparo = ?, observacaoreparo = ? where ( serie = ? or casid = ? ) and saida = ?";
					PreparedStatement  stmt1 = con.prepareStatement(sql1);
					stmt1.setString(1, dados.getLogin());
					stmt1.setString(2, dados.getData());
					stmt1.setString(3, dados.getDefeito());
					stmt1.setString(4, "S.C.R");
					stmt1.setString(5, dados.getObservacao());
					stmt1.setString(6, dados.getSerie());
					stmt1.setString(7, dados.getSerie());
					stmt1.setString(8, "false");
					stmt1.execute();
					stmt1.close();
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}catch (SQLException e) {
			String descricao = "Class ReparoRepository, Metodo adicionaReparo. SQLException";
			System.out.println("Erro ao inserir dados no banco de dados!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Reparo> selectReparoAdicionado() {
		// Criando uma lista de material
		List<Reparo> material = new ArrayList<>();
		String sql = "select serie, casid, diagnostico, statusreparo, observacaoreparo, datadiagnostico from equipamento where (serie = ? or casid = ?) and usuarioreparo = ? ";
		try{
			PreparedStatement  stmt = con.prepareStatement(sql);
			stmt.setString(1, this.serie);
			stmt.setString(2, this.serie);
			stmt.setString(3, this.login);
			stmt.execute();			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Reparo objeto = new Reparo();
				objeto.setSerie(this.serie);					
				objeto.setReparo(rs.getString("statusreparo"));
				objeto.setObservacao(rs.getString("observacaoreparo"));
				objeto.setDefeito(rs.getString("diagnostico"));
				objeto.setData(rs.getString("datadiagnostico"));				
				material.add(objeto);				
			}	
			rs.close();
			stmt.close();
			return material;
			
		}catch (SQLException e) {
			String descricao = "Class ReparoRepository, Metodo List<Reparo> selectReparoAdicionado. SQLException";
			System.out.println("Erro ao buscar dado adicionado no banco de dados!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return null;
		}
	}
	public List<Reparo> selectReparoPesquisa() {
		// Criando uma lista de material
		List<Reparo> material = new ArrayList<>();
		String sql = "select serie, casid, diagnostico, statusreparo, observacaoreparo, datadiagnostico from equipamento where (serie = ? or casid = ?)";
		try{
			PreparedStatement  stmt = con.prepareStatement(sql);
			stmt.setString(1, this.serie);
			stmt.setString(2, this.serie);
			stmt.execute();			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Reparo objeto = new Reparo();
				objeto.setSerie(this.serie);
				objeto.setReparo(rs.getString("statusreparo"));
				objeto.setObservacao(rs.getString("observacaoreparo"));
				objeto.setDefeito(rs.getString("diagnostico"));
				objeto.setData(rs.getString("datadiagnostico"));				
				material.add(objeto);				
			}	
			rs.close();
			stmt.close();
			return material;
			
		}catch (SQLException e) {
			String descricao = "Class ReparoRepository, Metodo List<Reparo> selectReparoAdicionado. SQLException";
			System.out.println("Erro ao buscar dado adicionado no banco de dados!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return null;
		}
	}
	
	public Boolean deleteReparo(Reparo dados) {
		String sql1 = "update equipamento set usuarioreparo = ?, datadiagnostico = ?, diagnostico = ?, statusreparo = ?, observacaoreparo = ? where ( serie = ? or casid = ? ) and saida = ?";
		try {
			PreparedStatement  stmt1 = con.prepareStatement(sql1);
			stmt1.setString(1, "");
			stmt1.setString(2, "");
			stmt1.setString(3, "");
			stmt1.setString(4, "");
			stmt1.setString(5, "");
			stmt1.setString(6, dados.getSerie());
			stmt1.setString(7, dados.getSerie());
			stmt1.setString(8, "false");
			stmt1.execute();
			stmt1.close();
			return true;
		}catch (SQLException e) {
			String descricao = "Class ReparoRepository, Metodo adicionaReparo. SQLException";
			System.out.println("Erro ao inserir dados no banco de dados!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return false;
		}
		
	}
}
