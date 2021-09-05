<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
<link rel="stylesheet" href="css/estilo.css">


    <style>
        .bloco-inline label, 
        .bloco-inline input,
        .bloco-inline * {
            display: inline;
        }

    </style>


</head>

<body>
    <form action="cadastroServlet">
        <fieldset>
            <legend><b>CADASTRO</b></legend>
            <label for="nome">Nome Completo</label>
            <input class="larguratexto" type="text" id="nome" name="nome-compreto"> 
            <label for="telefone">Telefone</label>
            <input class="larguratexto" type="tel" placeholder="(61)9999-99999" name="telefone">
            <label for="dtNascimento">Data de Nascimento</label>
            <input class="larguratexto" type="date" id="dtNascimento" name="dt-Nascimento">
            <label for="email">E-mail</label>
            <input class="larguratexto" type="email" id="email" name="email">
            <label for="sexo">Sexo:</label>
            <div class="bloco-inline"> 
                <input type="radio" id="masc" name="sexo" value="m"><label for="masc"> Masculino</label> 
                <input type="radio" id="fem" name="sexo" value="f"> <label for="fem"> Feminino</label> 
            </div>
            <label for="sexo">Tecnologia:</label>
            <div class="bloco-inline"> 
                <input type="checkbox" id="html" name="tecnologia" value="html"> <label for="html"> HTML</label>
                <input type="checkbox" id="css" name="tecnologia" value="css">   <label for="css"> CSS</label> 
                <input type="checkbox" id="java" name="tecnologia" value="java"> <label for="java"> JAVA</label>    
                <input type="checkbox" id="php" name="tecnologia" value="php">   <label for="php"> PHP</label> 
            </div>
            <label for="">Escolaridade</label>
            <select name="escolaridade" id="escolaridade">
                <option value="Fundamental">Fundamental</option>
                <option value="Ensino Médio">Ensino Médio</option>
                <option value="Superior">Superior</option>

            </select>
            <input type="reset" class="bt" value="Limpar">
            <input type="submit" class="bt" value="Enviar">
            
        </fieldset>
    </form>
</body>

</html>