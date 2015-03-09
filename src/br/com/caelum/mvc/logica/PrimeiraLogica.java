package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Essa é a primeira lógica de servlet.
 * É usada para testes da interface <b>Logica</b>.
 * Retorna uma simples <i>string</i> da página JSP que será executada a lógica.
 * @author Rafael
 * @see Logica
 *
 */
public class PrimeiraLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Executando a primeira lógica...");
		System.out.println("Retornando o nome da página JSP...");
		return "primeira-logica.jsp";
	}

}
