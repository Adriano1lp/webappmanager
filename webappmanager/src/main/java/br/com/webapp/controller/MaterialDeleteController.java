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
 * Class MaterialController responsavel pemo mapeamento de rotas get e post da tela Adiciona Material
 * @author adriano
 * Data Edição: 24/09/2018
 */
@WebServlet("/materialdelete")
public class MaterialDeleteController extends HttpServlet{
	
	MaterialRepository materialRepository = new MaterialRepository();
	Gson gson = new Gson();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Material> material = materialRepository.selectMaterialAdicionado();
		resp.getWriter().print(gson.toJson(material));
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = JsonUtil.lerJson(req.getReader());
	//	resp.getWriter().print(json);
		//Convertendo o json para objeto Material
		Material material = gson.fromJson(json.toString(), Material.class);
		materialRepository.setValores(material);
		System.out.println("Material delete "+material);
	if (materialRepository.deleteMaterial(material)) {
			//Cliente salvo com sucesso
		resp.getWriter().print("material deletado");
	}else {
			//Erro ao cadastrar cliente 
			resp.getWriter().print("Erro ao deletar");
		}
	}
	
}

