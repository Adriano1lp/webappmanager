package br.com.webapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.webapp.connection.ConnectionFactory;
import br.com.webapp.controller.Log;
import br.com.webapp.model.Saida;
public class SaidaRepository{
    Connection con;
	public String login;
	public String serie;
	public SaidaRepository() {
		con = ConnectionFactory.getConnection();
	}
	public void setValores(Saida dados) {
		this.serie = dados.serie;
		this.login= dados.login;
    }
    public Boolean adicionaSaida(Saida dados){
        String sql = "select serie, casid, modelo, codigosap, segmento, statusreparo, diagnostico, notafiscalentrada, observacaoreparo from equipamento where serie = ? and saida = ?";
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getSerie());
            stmt.setString(2, "felse");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                System.out.println("Este item ja saiu");
                return false;
            }else{
                String sql1 = "update equipamento set notafiscalsaida = ?, pedidosaida = ?, saida = ?, usuariosaida = ?, datasaida = ?  where serie = ? and saida = ?";
                PreparedStatement stmt1 = con.prepareStatement(sql1);
                stmt1.setString(1, dados.getNotafiscalsaida());
                stmt1.setString(2, dados.getPedidosaida());
                stmt1.setString(3, "true");
                stmt1.setString(4, dados.getLogin());
                stmt1.setString(5, dados.getData());
                stmt1.setString(6, dados.getSerie());
                stmt1.setString(7, "false");
                stmt1.execute();
                stmt1.close();
                String sql2 = "insert into historicosaida (serie, casid, modelo, codigosap, segmento, statusreparo, diagnostico, notafiscalentrada, pedidosaida, notafiscalsaida, datasaida) values (?,?,?,?,?,?,?,?,?,?,?) ";
                PreparedStatement stmt2 = con.prepareStatement(sql2);
                stmt2.setString(1, (String) rs.getObject("serie")); 
                stmt2.setString(2, (String) rs.getObject("casid"));
                stmt2.setString(3, (String) rs.getObject("modelo"));
                stmt2.setString(4, (String) rs.getObject("codigosap"));
                stmt2.setString(5, (String) rs.getObject("segmento"));
                stmt2.setString(6, "REPARADO");
                stmt2.setString(7, (String) rs.getObject("diagnostico")+" "+rs.getObject("observacaoreparo"));
                stmt2.setString(8, (String) rs.getObject("notafiscalentrada"));
                stmt2.setString(9, (String) rs.getObject("pedidosaida"));
                stmt2.setString(10, (String) rs.getObject("notafiscalsaida"));
                stmt2.setString(11, (String) rs.getObject("datasaida"));
                stmt2.execute();
                stmt2.close();                
                return true;
            }
        }catch(SQLException e){
            String descricao = "Class SaidaRepository, Metodo adicionaSaida. SQLException";
			System.out.println("Erro ao inserir dados no banco de dados!!"+ descricao);
			Log.escreveLogErro(descricao);
			e.printStackTrace();
			return false;
        }
        
    }
}
