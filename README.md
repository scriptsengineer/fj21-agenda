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
	

#### Os métodos forward e include
O método *forward* só é chamado quando nada foi escrito na página. Se precisar somente adicionar algum dado, precisa-se utilizar o método *include*


### Interface Lógica dos servlets
	
	public interface Logica {
		String executa(HttpServletRequest request,HttpServletResponse response) throws Exception;
	}

### O Principal elemento: O Controller

### teste

> dsiaodioasidoiasodiaosi ndasodioasidoio

[ola](README.md "Teste")


