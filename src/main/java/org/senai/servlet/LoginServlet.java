package org.senai.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logindervlet")
public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String loginV = "edson";
	    String senhaV = "1234";
	    
	    String login = req.getParameter("login");
	    String senha = req.getParameter("senha");
	    
	    PrintWriter saida = res.getWriter();
		saida.println("<html>");
		
		if(login.equals(loginV) && senha.equals(senhaV)) {
			saida.println("Acesso Aprovado");
		}else {
		    saida.println("Acesso Negado");
		}
		saida.println("<html>");
		
	    
	    
	}
	}