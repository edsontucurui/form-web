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
		if(objP.getTecnologia() != null ) {
	 		for (String t : objP.getTecnologia()) {
				lsTecnologia += t + ",";
	 	
	 	  }
		
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
			PreparedStatement pst = cont.prepareStatement("Select id, nome_completo, telefone, email from pessoas order by id");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getInt("id"));
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
	
	
	public Pessoa getPessoa(int id) {
		Pessoa p = new Pessoa();
		
		try {
			Connection cont = Conexao.conectar();
			PreparedStatement pst = cont.prepareStatement("Select * from pessoas where id = ? ");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				p.setId(rs.getInt("id"));
				p.setNomeCompleto(rs.getString("nome_completo"));
				p.setTelefone(rs.getString("telefone"));
				p.setDtNascimento(rs.getString("dt_nascimento"));
				p.setEmail(rs.getString("email"));
				p.setSexo(rs.getString("sexo"));
				p.setTecnologia(rs.getString("tecnologia").split(","));
				p.setEscolaridade(rs.getString("escolaridade"));
									
			}
			cont.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		return p;
	}
	
	 public boolean alterar(Pessoa objP) {
		 
		 String lsTecnologia = "";
		 	if(objP.getTecnologia() != null ) {
		 		for (String t : objP.getTecnologia()) {
					lsTecnologia += t + ",";
		 	
		 	  }
			
			}
			try {
				//Conexao c = new Conexao();
			   java.sql.Connection cont = Conexao.conectar(); 
				
					String sql = " update pessoas set "  
					       + "nome_completo = ?,"
						   + "telefone = ?,"
						   + "dt_nascimento = ?,"
						   + "email = ?,"
						   + "sexo = ?,"
						   + "tecnologia = ?," 
						   + "escolaridade = ?"
						   + "where "
						   + "id= ?";
					
					PreparedStatement pst = cont.prepareStatement(sql);
					pst.setString(1,objP.getNomeCompleto());
					pst.setString(2,objP.getTelefone());
					pst.setString(3,objP.getDtNascimento());
					pst.setString(4,objP.getEmail());
					pst.setString(5,objP.getSexo());
					pst.setString(6,lsTecnologia);
					pst.setString(7,objP.getEscolaridade());
					pst.setInt(8,objP.getId());
					
					pst.execute();
					pst.close();
					cont.close();
					return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		 
	 }
	
public boolean apagar(int id) {

			try {
			   java.sql.Connection cont = Conexao.conectar(); 
				
					String sql = " delete from pessoas where id = ?";
					
					PreparedStatement pst = cont.prepareStatement(sql);
					pst.setInt(1,id);
					
					pst.execute();
					pst.close();
					cont.close();
					return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
	 }
	 
}
