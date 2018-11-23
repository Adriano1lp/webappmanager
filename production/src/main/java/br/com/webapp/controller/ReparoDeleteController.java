package br.com.webapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.webapp.model.Material;
import br.com.webapp.model.Reparo;
import br.com.webapp.repository.ReparoRepository;
import br.com.webapp.util.JsonUtil;

/**
 * Servlet implementation class ReparoDeleteController
 */
@WebServlet("/reparodelete")
public class ReparoDeleteController extends HttpServlet {
	
	ReparoRepository reparoRepository = new ReparoRepository();
	Gson gson = new Gson();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = JsonUtil.lerJson(req.getReader());
	//	resp.getWriter().print(json);
		//Convertendo o json para objeto Material
		Reparo material = gson.fromJson(json.toString(), Reparo.class);
		reparoRepository.setValores(material);
	if (reparoRepository.deleteReparo(material)) {
			//Cliente salvo com sucesso
		resp.getWriter().print("reparo deletado");
	}else {
			//Erro ao cadastrar cliente 
			resp.getWriter().print("Erro ao deletar");
		}
	}
	
}
