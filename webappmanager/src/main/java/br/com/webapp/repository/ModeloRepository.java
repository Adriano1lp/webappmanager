package br.com.webapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.webapp.connection.ConnectionFactory;
import br.com.webapp.controller.Log;
import br.com.webapp.model.Modelo;
import br.com.webapp.model.Reparo;

public class ModeloRepository {
	Connection con;

	public ModeloRepository() {
		con = ConnectionFactory.getConnection();
	}
	
	public Boolean adicionaMaterial(Modelo dados) {
		String sql = "select * from modelo where codigosap = ? and segmento = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, dados.getCodigosap());
			stmt.setString(2, dados.getSegmento());
	
			ResultSet rs = stmt.executeQuery();
			System.out.println("resultado  "+rs);
			if(!rs.next()) {
				String sql1 = "insert into modelo (codigosap, modelo, segmento) values(?,?,?)";
				PreparedStatement  stmt1 = con.prepareStatement(sql1);
				stmt1.setString(1, dados.getCodigosap());
				stmt1.setString(2, dados.getModelo());
				stmt1.setString(3, dados.getSegmento());
				stmt1.execute();
				stmt1.close();
				return true;
			}else {
				return false;
			}
		}catch (SQLException e) {
			String descricao = "Class ModeloRepository, Metodo adicionaModelo. SQLException";
			System.out.println("Erro ao inserir dados no banco de dados!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Modelo> selectModelo() {
		// Criando uma lista de material
		List<Modelo> modelo = new ArrayList<>();
		String sql = "select codigosap, modelo, segmento from modelo";
		try{
			PreparedStatement  stmt = con.prepareStatement(sql);
			stmt.execute();			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Modelo objeto = new Modelo();
				objeto.setCodigosap(rs.getString("codigosap"));
				objeto.setModelo(rs.getString("modelo"));
				objeto.setSegmento(rs.getString("segmento"));
				modelo.add(objeto);				
			}	
			rs.close();
			stmt.close();
			return modelo;
			
		}catch (SQLException e) {
			String descricao = "Class ModeloRepository, Metodo List<Modelo> selectReparoAdicionado. SQLException";
			System.out.println("Erro ao buscar dado adicionado no banco de dados!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return null;
		}
	}
	
	public Boolean deleteModelo(Modelo dados) {
		String sql1 = "delete from modelo where codigosap = ? and segmento = ?";
		try {
			PreparedStatement  stmt1 = con.prepareStatement(sql1);
			stmt1.setString(1, dados.getCodigosap());
			stmt1.setString(2, dados.getSegmento());
			stmt1.execute();
			stmt1.close();
			return true;
		}catch (SQLException e) {
			String descricao = "Class ModeloRepository, Metodo deleteModelo. SQLException";
			System.out.println("Erro ao inserir dados no banco de dados!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return false;
		}
		
	}
}
