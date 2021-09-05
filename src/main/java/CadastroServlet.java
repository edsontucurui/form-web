import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jdi.connect.spi.Connection;

@WebServlet("/cadastroServlet")
public class CadastroServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		String nomeCompleto = req.getParameter("nome-compreto");
		String telefone = req.getParameter("telefone");
		String dtNascimento = req.getParameter("dt-Nascimento");
		String email = req.getParameter("email");
		String sexo = req.getParameter("sexo");
		String[] tecnologia = req.getParameterValues("tecnologia");
		String escolaridade= req.getParameter("escolaridade");
		
		
		PrintWriter saida = res.getWriter();
		saida.println("<html>");
		saida.println(nomeCompleto);
		saida.println(telefone);
		saida.println(dtNascimento);
		saida.println(email);
		saida.println(sexo);
		String lsTecnologia = "";
		for (String t : tecnologia) {
			saida.println(t);
			lsTecnologia += t+",";
		}
		
		saida.println(escolaridade);
		saida.println("</html>");
		
		
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://chunee.db.elephantsql.com:5432/zenljtot";
			String usuarioDb = "zenljtot";
			String senhaDb = "mSM6ymspQ4RtqaNu85umheOu67sziooM";
			java.sql.Connection cont = DriverManager.getConnection(url,usuarioDb,senhaDb);
			saida.println("Ok para conexão");
			
			String sql ="insert into pessoas (nome_completo, telefone, dt_nascimento, email, sexo, tecnologia , escolaridade)"
					+ "values('"+nomeCompleto+"','"+telefone+"','"+dtNascimento+"','"+email+"','"+sexo+"','"+lsTecnologia+"','"+escolaridade+"') ";
			
			PreparedStatement pst = cont.prepareStatement(sql);
			pst.execute();
			pst.close();
			cont.close();
			
			saida.println("Registro Gravado");
			
			
		} catch (Exception e) {
			saida.println("Erro de conexão");
		
		}
			
		saida.println("</html>");
	}
}

	

