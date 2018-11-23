package br.com.webapp.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import br.com.webapp.model.Reparo;
import br.com.webapp.repository.ReparoRepository;
import br.com.webapp.util.JsonUtil;

/**
 * Servlet implementation class ReparoController
 */
@WebServlet("/reparo")
public class ReparoController extends HttpServlet {
	
	ReparoRepository reparoRepository = new ReparoRepository();
	Gson gson = new Gson();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Reparo> material = reparoRepository.selectReparoAdicionado();
		resp.getWriter().print(gson.toJson(material));
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = JsonUtil.lerJson(req.getReader());
		
		//Convertendo o json para objeto Material
		Reparo material = gson.fromJson(json.toString(), Reparo.class);
		reparoRepository.setValores(material);
		resp.getWriter().print(material);
	if (reparoRepository.adicionaReparo(material)) {
			//Cliente salvo com sucesso
			resp.getWriter().print("Reparo salvo com sucesso\n");

	}else {
			//Erro ao cadastrar cliente 
			resp.getWriter().print("Erro ao cadastrar Reparo");
		}
	}

}
