<%@page import="org.senai.model.Pessoa"%>
<%@page import="org.senai.dao.PessoaDao"%>
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

<%@ include file="menu.jsp" %>

<%
	Pessoa p = new Pessoa();

	try{
		
		int id = Integer.parseInt(request.getParameter("id"));	
		PessoaDao dao = new PessoaDao();
		p = dao.getPessoa(id);

	}catch (Exception e){ 
		
		
	}

	
%>


    <form action="cadastroServlet">
    <input type="hidden" name='id' value="<%=p.getId()%>">
    
        <fieldset>
            <legend><b>CADASTRO</b></legend>
            <label for="nome">Nome Completo</label>
            <input class="larguratexto" type="text" id="nome" name="nome-compreto" value="<%=p.getNomeCompleto() %>"> 
            <label for="telefone">Telefone</label>
            <input class="larguratexto" type="tel" placeholder="(61)9999-99999" name="telefone" value="<%=p.getTelefone() %>">
            <label for="dtNascimento">Data de Nascimento</label>
            <input class="larguratexto" type="date" id="dtNascimento" name="dt-Nascimento" value="<%=p.getDtNascimento()%>">
            <label for="email">E-mail</label>
            <input class="larguratexto" type="email" id="email" name="email" value="<%=p.getEmail() %>">
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
                <option value="Ensino M??dio">Ensino M??dio</option>
                <option value="Superior">Superior</option>

            </select>
<!--             <input type="reset" class="bt" value="Limpar"> -->
            <a class="bt" href="formCadastro.jsp">Novo Cadastro</a>
		    <%
		    if(p.getId()>0){
		    %>           
            <a class="bt" onclick=" return confirm('Voc?? realmente quer apagar esse registro?');" href="cadastroServlet?id=<%=p.getId()%>&acao=apagar">Apagar</a>
            <%
		    }else {
		    %>
		     <input type="reset" class="bt" value="Limpar">
		    <%
		    }
            %>
            <input type="submit" class="bt" value="Gravar">
            
        </fieldset>
    </form>

   
    <script type="text/javascript">
	var lsSexo = document.getElementsByName("sexo");
	for(i in lsSexo){
		if(lsSexo[i].value == '<%=p.getSexo()%>') {
			lsSexo[i].setAttribute('checked','checked');
		}
	}

	document.getElementById("escolaridade").value = '<%=p.getEscolaridade()%>';
	
	<%
	for (String t : p.getTecnologia()) {
		out.println("document.getElementById('"+t+"').setAttribute('checked','checked')");
		
	}
	
	%>
	</script>
    
    <div id="tb"> 
    
    <%@ include file="listaPessoas.jsp" %>
    
    </div>
</body>

</html>