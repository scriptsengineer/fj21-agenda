<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bem-vindo!</title>
</head>
<body>
	<%-- Comentário de JSP aqui: nossa primeira página em JavaServer Pages --%>
	<% 
		String mensagem = "Bem-vindo ao sistema de agenda do FJ-21!";
	%>
	<%
		out.println(mensagem);
	%>
	</br>
	<%
		String desenvolvido = "Desenvolvido por Rafael Correa";
	%>
	<%=desenvolvido%>
	<%
		System.out.println("Tudo foi executado!");
	%>
</body>
</html>