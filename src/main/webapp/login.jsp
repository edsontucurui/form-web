<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/estilo.css">
</head>
<body>
<%@ include file="menu.jsp" %>
    <fieldset>
    <form action="logindervlet" method="post">
        <legend><b>ACESSO</b></legend>
        <label for="login">Login</label>
        		<input type="text" id="Login" name="login" autocomplete="off" /> 
        <label for="senha">Senha</label>
        		<input type="password" name="senha" id="senha">
        <input type="submit" class="bt" value="Acessar">
    </form>
    </fieldset>
</body>
</html>