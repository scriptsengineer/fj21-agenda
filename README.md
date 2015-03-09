# fj21-agenda

Projeto de aprendizado da Apostila da Caelum FJ21 - FJ21-Agenda Web

## Usando o JSP (Java Server Pages)

Aqui tento dizer sobre o Java Server Pages

## Taglibs

### Usando o JSP e o Servlet juntos!
Aqui seque o código que permite que usamos os dois juntos:

	RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
	rd.forward(request,response);
	
## MVC

<a href="www.google.com.br">google</a>
### Interface Lógica dos servlets
	
	public interface Logica {
		String executa(HttpServletRequest request,HttpServletResponse response) throws Exception;
	}

