<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�gina JSP</title>
</head>
<body> 
P�gina JSP

<%

String app = request.getParameter("app");
out.print("Aqui � um conteudo JAVA "+app);

%>

</body>
</html>