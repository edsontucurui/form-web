<%@page import="org.senai.model.Pessoa"%>
<%@page import="org.senai.dao.PessoaDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.senai.db.Conexao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Pessoas</title>
</head>
<body>

	<%
	PessoaDao objDao = new PessoaDao();
	java.util.List<Pessoa> ls  = objDao.ListaPessoa();		
	if(ls.size() >0) {
		
	
	%>
	<table>

		<tr>
			<th>Nome</th>
			<th>Telefone</th>
			<th>E-mail</th>
		</tr>
		
		<% 
		for(Pessoa p : ls) { 
		%>
		<tr>
			<td><%=p.getNomeCompleto() %></td>
			<td><%=p.getTelefone()%></td>
			<td><%=p.getEmail()%></td>
			
		</tr>
		<%} %>
		
	</table>
	 <% 
	 
	 }
				
     %>
</body>
</html>