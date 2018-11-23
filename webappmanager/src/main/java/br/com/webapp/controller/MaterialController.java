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
import br.com.webapp.repository.MaterialRepository;
import br.com.webapp.util.JsonUtil;

/**
 * Servlet MaterialController possui os metodos doGet e doPost.
 * O Objetivo da class é receber requisição http e convertela em object para class MaterialRepository
 * Data 16/11/2018
 * @author Adriano LIma Pereira
 *
 */
@WebServlet("/material")
public class MaterialController extends HttpServlet{
	
	MaterialRepository materialRepository = new MaterialRepository();
	Gson gson = new Gson();
	
	/**
	 * Metodo doGet recebe requisição http e converte em object para class MaterialReposytory.
	 * A requisição http vem no formato JSON.
	 * Esse metodo recebe um lista do metodo selectMaterialAdicionado da class MaterialReposutory.
	 * Data 16/11/2018
	 * @param le o formato json com JsonUtil converte com gson e envia para MaterialRepository.
	 * @return resp.getWriter().print()
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Material> material = materialRepository.selectMaterialAdicionado();
		resp.getWriter().print(gson.toJson(material));
		
	}
	
	/**
	 * Metodo doPost recebe requisição http e converte em object para class MaterialReposytory.
	 * A requisição http vem no formato JSON.
	 * Data 16/11/2018
	 * @param le o formato json com JsonUtil converte com gson e envia para MaterialRepository.
	 * @return resp.getWriter().print()
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = JsonUtil.lerJson(req.getReader());
		
		//Convertendo o json para objeto Material
		Material material = gson.fromJson(json.toString(), Material.class);
		materialRepository.setValores(material);
		resp.getWriter().print(material);
	if (materialRepository.adicionaMaterial(material)) {
			//Cliente salvo com sucesso
			resp.getWriter().print("Material salvo com sucesso\n");
			resp.getWriter().print(material);
	}else {
			//Erro ao cadastrar cliente 
			resp.getWriter().print("Erro ao cadastrar Material");
		}
	}
}
