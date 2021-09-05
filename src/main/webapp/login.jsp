<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/estilo.css">
</head>
<body>
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