package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

/**
 * Classe que cordenará o uso de nossa aplicação.
 * @author Rafael
 *
 */
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.caelum.mvc.logica."+parametro;
		try{
			Class classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica)classe.newInstance();
			String pagina = logica.executa(request, response);
			request.getRequestDispatcher(pagina).forward(request,response);
		}catch(Exception e){
			throw new ServletException("A lógica dos negócios causou uma excessão!");
		}
	}
	
}
