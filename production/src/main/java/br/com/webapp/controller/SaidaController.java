package br.com.webapp.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import br.com.webapp.model.Saida;
import br.com.webapp.repository.SaidaRepository;
import br.com.webapp.util.JsonUtil;

/**
 * Servlet implementation class ReparoController
 */
@WebServlet("/saida")
public class SaidaController extends HttpServlet {
	
	SaidaRepository saidaRepository = new SaidaRepository();
	Gson gson = new Gson();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Saida> material = saidaRepository.selectSaidaAdicionada();
		resp.getWriter().print(gson.toJson(material));
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = JsonUtil.lerJson(req.getReader());
		
		//Convertendo o json para objeto Material
		Saida material = gson.fromJson(json.toString(), Saida.class);
		saidaRepository.setValores(material);
		resp.getWriter().print(material);
	if (saidaRepository.adicionaSaida(material)) {
			//Cliente salvo com sucesso
			resp.getWriter().print("Reparo salvo com sucesso\n");

	}else {
			//Erro ao cadastrar cliente 
			resp.getWriter().print("Erro ao cadastrar Reparo");
		}
	}

}
