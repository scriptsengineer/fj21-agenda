<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de contatos</title>
</head>
<body>

	<c:import url="cabecalho.jsp"/>
	
	<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"/>
	
	<% request.setAttribute( "test", dao.getLista() ); %>

	<display:table name="test">
	  <display:column property="nome" title="Nome" sortable="true"/>
	  <display:column property="email" title="E-mail"/>
	  <display:column property="endereco" title="Endereço"/>
	  <display:column format="{0,date,dd-MM-yyyy}" property="dataNascimento.time" title="Data de Nascimento"/>
	</display:table>
	
	
	
	<c:import url="rodape.jsp"/>

</body>
</html>