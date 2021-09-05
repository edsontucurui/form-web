package org.senai.dao;

import java.awt.List;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.senai.db.Conexao;
import org.senai.model.Pessoa;

public class PessoaDao {

	public boolean adicionar(Pessoa objP) {
		String lsTecnologia = "";
		for (String t : objP.getTecnologia()) {
			lsTecnologia += t+",";
		}
		try {
			//Conexao c = new Conexao();
		   java.sql.Connection cont = Conexao.conectar(); 
			
				String sql ="insert into pessoas (nome_completo, telefone, dt_nascimento, email, sexo, tecnologia , escolaridade)"
						+ "values('"+ objP.getNomeCompleto() +"','"+ objP.getTelefone()+"','"+ objP.getDtNascimento() +"','"+ objP.getEmail() +"','"+ objP.getSexo() +"','"+ lsTecnologia +"','"+ objP.getEscolaridade()+"') ";
				
				PreparedStatement pst = cont.prepareStatement(sql);
				pst.execute();
				pst.close();
				cont.close();
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public java.util.List<Pessoa> ListaPessoa(){
		
		java.util.List<Pessoa> ls = new ArrayList<>();
		try {
			Connection cont = Conexao.conectar();
			PreparedStatement pst = cont.prepareStatement("Select nome_completo, telefone, email from pessoas");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Pessoa p = new Pessoa();
				p.setNomeCompleto(rs.getString("nome_completo"));
				p.setTelefone(rs.getString("telefone"));
				p.setEmail(rs.getString("email"));
				ls.add(p);
			}
			cont.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
					
		return ls;
	}
	
}
