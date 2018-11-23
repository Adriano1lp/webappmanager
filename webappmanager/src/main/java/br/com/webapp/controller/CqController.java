package br.com.webapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.webapp.model.Cq;
import br.com.webapp.repository.CqRepository;
import br.com.webapp.util.JsonUtil;

/**
 * Servlet implementation class CqController 
 * Data Edição: 16/11/2018
 * @author Adriano Lima Pereira
 * @version 1.0 
 */

@WebServlet("/cq")
public class CqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CqRepository cqRepository = new CqRepository();
	Gson gson = new Gson();
    /**
     * Metodo doGet
     * @param
     * @return
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Cq> cq = cqRepository.selectCqAdicionado();
		resp.getWriter().print(cq);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json = JsonUtil.lerJson(req.getReader());
		//Convertendo o json para objetos cq
		Cq cq = gson.fromJson(json.toString(), Cq.class);
		cqRepository.setValores(cq);
		if (cqRepository.adicionaCq(cq)) {
			resp.getWriter().print("Cq Adicionado com sucesso\n");
		
		}else {
			resp.getWriter().print("Erro ao adicionar Cq\n");
		}
	}

}
