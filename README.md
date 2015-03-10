# fj21-agenda

Projeto de aprendizado da Apostila da Caelum FJ21 - FJ21-Agenda Web

## Usando o JSP (Java Server Pages)

Aqui tento dizer sobre o Java Server Pages

## Taglibs


	
## MVC - Model View Controller

### Request Dispatcher - Usando o JSP e o Servlet juntos!
A função dele é redirecionar requisições entre recursos, como no exemplo, entre JSP e Servlet.Representado pela classe **RequestDispatcher** e está incluido dentro da API dos Servlets.

Aqui seque o código que permite que usamos os dois juntos:


* No java:

		RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request,response);
	
* No JSP:

		<html>
			<body>
				Contato ${param.nome} adicionado com sucesso
			</body>
		</html>
	
> **Os métodos forward e include**
O método *forward* só é chamado quando nada foi escrito na página. Se precisar somente adicionar algum dado, precisa-se utilizar o método *include*


### Interface Lógica dos servlets
	
	public interface Logica {
		String executa(HttpServletRequest request,HttpServletResponse response) throws Exception;
	}
	
> **Switch e a ideia do polimorfismo**
No java o comportamento switch ou parecidos (if e elses encadeados) podem sempre ser transformados pelo polimorfismo.

### O Principal elemento: O Controller

Principal elemento da MVC pois receve o parametro de qualquer lógica do sistema e cria uma classe apartir do método *newInstance*, passando também o caminho completo para o comando *forName*.

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

>	*Class.forName* usa o design pattern de **factory**!

### teste

> dsiaodioasidoiasodiaosi ndasodioasidoio

[ola](README.md "Teste")

https://github.com/RafaelMCorrea/fj21-agenda.git


