package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface que modela lógica de todos servlet.
 * Utilizado por Geração de classes lógicas dos servlet.
 * @author Rafael
 *
 */
public interface Logica {
	String executa(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
