package br.com.webapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.webapp.connection.ConnectionFactory;
import br.com.webapp.controller.Log;
import br.com.webapp.model.Material;
public class MaterialRepository {
	
	Connection con;
	public String login;
	
	public MaterialRepository() {
		con = ConnectionFactory.getConnection();
	}
	
	public void setValores(Material dados) {
		this.login= dados.login;
		System.out.println("Teste    "+dados.getLogin());
	}
	public Boolean adicionaMaterial(Material dados) {
		String sql = "select * from equipamento where serie = ? and casid = ? and saida = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, dados.getSerie());
			stmt.setString(2, dados.getCasid());
			stmt.setString(3, "false");
	
			ResultSet rs = stmt.executeQuery();
			System.out.println("resultado  "+rs);
			if(!rs.next()) {
				String sql1 = "insert into equipamento (serie, casid, mac, codigosap, modelo, notafiscalentrada, pedidoentrada, segmento, dataentrada, entrada, saida, usuarioentrada ) values(?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement  stmt1 = con.prepareStatement(sql1);
				stmt1.setString(1, dados.getSerie());
				stmt1.setString(2, dados.getCasid());
				stmt1.setString(3, dados.getMac());
				stmt1.setString(4, dados.getCodigosap());
				stmt1.setString(5, dados.getModelo());
				stmt1.setString(6, dados.getNotafiscal());
				stmt1.setString(7, dados.getPedido());
				stmt1.setString(8, dados.getSegmento());
				stmt1.setString(9, dados.getData());
				stmt1.setString(10, "true");
				stmt1.setString(11, "false");
				stmt1.setString(12, dados.getLogin());
				stmt1.execute();
				stmt1.close();
				return true;
			}else {
				return false;
			}
		}catch (SQLException e) {
			String descricao = "Class MaterialRepository, Metodo adicionaMaterial. SQLException";
			System.out.println("Erro ao inserir dados no banco de dados!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return false;
		}
		
	}
	public List<Material> selectMaterialAdicionado() {
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		// Criando uma lista de material
		List<Material> material = new ArrayList<>();
		
		
		String sql = "select serie, casid, mac, modelo, codigosap, notafiscalentrada, pedidoentrada, dataentrada from equipamento where dataentrada = ? and usuarioentrada = ? ";
		try{
			PreparedStatement  stmt = con.prepareStatement(sql);
			stmt.setString(1, formatador.format(data));
			stmt.setString(2, this.login);
			stmt.execute();			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Material objeto = new Material();
				objeto.setSerie(rs.getString("serie"));
				objeto.setCasid(rs.getString("casid"));
				objeto.setMac(rs.getString("mac"));
				objeto.setModelo(rs.getString("modelo"));
				objeto.setCodigosap(rs.getString("codigosap"));
				objeto.setNotafiscal(rs.getString("notafiscalentrada"));
				objeto.setPedido(rs.getString("pedidoentrada"));
				objeto.setData(rs.getString("dataentrada"));				
				material.add(objeto);
				
			}	
			rs.close();
			stmt.close();
			return material;
			
		}catch (SQLException e) {
			String descricao = "Class MaterialRepository, Metodo List<Material> selectMaterialAdicionado. SQLException";
			System.out.println("Erro ao buscar dado adicionado no banco de dados!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return null;
		}
		

	}
	public Boolean deleteMaterial(Material dados) {
		String sql = "delete from equipamento where serie = ? and casid = ? and mac = ? and modelo = ? and codigosap= ? and notafiscalentrada = ? and pedidoentrada = ?  and dataentrada = ? and usuarioentrada = ?";
		try {
			PreparedStatement  stmt = con.prepareStatement(sql);
			stmt.setString(1, dados.getSerie());
			stmt.setString(2, dados.getCasid());
			stmt.setString(3, dados.getMac());
			stmt.setString(4, dados.getModelo());
			stmt.setString(5, dados.getCodigosap());
			stmt.setString(6, dados.getNotafiscal());
			stmt.setString(7, dados.getPedido());
			stmt.setString(8, dados.getData());	
			stmt.setString(9, this.login);	
			stmt.execute();
			stmt.close();
			return true;
		}catch (SQLException e) {
			String descricao = "Class MaterialRepository, Metodo deleteMaterial. SQLException";
			System.out.println("Erro ao deletar dados do banco de dados !!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return false;
		}
	}
}
