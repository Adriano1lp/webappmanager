package br.com.webapp.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import br.com.webapp.model.Login;
import br.com.webapp.repository.LoginRepository;
import br.com.webapp.util.JsonUtil;
/**
 * Servlet LoginController possui os metodos doGet e doPost.
 * O Metodo doGet não esta sendo utilizado.
 * O Objetivo da class é receber requisição http e convertela em object para class LoginRepository
 * Data 16/11/2018
 * @author Adriano Lima Pereira
 * @version 1.0
 *
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	LoginRepository loginRepository = new LoginRepository();
	Gson gson = new Gson();
	/**
	 * Metodo doGet, sem função
	 * @param null
	 * @return null
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	/**
	 * Metodo doPost recebe requisição http e converte em object para class LoginReposytory.
	 * A requisição http vem no formato JSON.
	 * Data 16/11/2018
	 * @param le o formato json com JsonUtil converte com gson e envia para LoginRepository.
	 * @return resp.getWriter().print()
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String json = JsonUtil.lerJson(req.getReader());
		
		//Convertendo o json para objeto Material
		Login login = gson.fromJson(json.toString(), Login.class);
		if(loginRepository.verificaLogin(login)) {
			List<Login> dados = loginRepository.getLogin();
			resp.getWriter().print(gson.toJson(dados));
		}else {
			resp.getWriter().print("Usuario não encontrado!!");
		}
		
	}
}
