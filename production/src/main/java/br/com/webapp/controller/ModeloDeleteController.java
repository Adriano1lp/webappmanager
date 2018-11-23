package br.com.webapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.webapp.model.Modelo;
import br.com.webapp.repository.ModeloRepository;
import br.com.webapp.util.JsonUtil;

/**
 * Servlet implementation class ModeloDeleteController
 */
@WebServlet("/modelodelete")
public class ModeloDeleteController extends HttpServlet {
	
	ModeloRepository modeloRepository = new ModeloRepository();
	Gson gson = new Gson();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = JsonUtil.lerJson(req.getReader());
		
		//Convertendo o json para objeto Material
		Modelo modelo = gson.fromJson(json.toString(), Modelo.class);

		resp.getWriter().print(modelo);
	if (modeloRepository.deleteModelo(modelo)) {
			//Cliente salvo com sucesso
			resp.getWriter().print("Modelo Deletado com sucesso\n");
			resp.getWriter().print(modelo);
	}else {
			//Erro ao cadastrar cliente 
			resp.getWriter().print("Erro ao cadastrar Material");
		}
	}
}
