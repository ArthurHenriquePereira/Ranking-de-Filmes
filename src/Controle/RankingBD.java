package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.Ranking;


public class RankingBD {

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	ArrayList<Ranking> lista = new ArrayList<>();
	
	public ArrayList <Ranking> pesquisarFilmes(){
		String sql = "select * from filme order by posicaoFilme";

		conn = new Conexao().faz_conexao();

		try {
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();


			while(rs.next()) {
				Ranking rank = new Ranking();
				rank.setIdFilme(rs.getInt("idFilme"));
				rank.setNomeFilme(rs.getString("nomeFilme"));
				rank.setPosicaoFilme(rs.getInt("posicaoFilme"));
				rank.setVotosFilme(rs.getInt("votosFilme"));
				
				lista.add(rank);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao pesquisar os filmes -> " + e);
		}
		return lista;
	}
	
	public void cadastrarFilme(Ranking filme) {
		String sql = "insert into filme (posicaoFilme, nomeFilme,  votosFilme) values (?,?,?)";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filme.getPosicaoFilme());
			stmt.setString(2, filme.getNomeFilme());
			stmt.setInt(3, filme.getVotosFilme());			
			
			stmt.execute();
			stmt.close();

		
			JOptionPane.showMessageDialog(null, "FIlme inserido com sucesso!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha os campos para cadastrar!");
		}
		
	}
	
	 public void aumentarVotosFilme(int idFilme) {
         String sql = "UPDATE filme SET votosFilme = votosFilme + 1 WHERE idFilme = ?";
		  
          
         conn = new Conexao().faz_conexao();
          
	        try {
	         
	            
	        	stmt = conn.prepareStatement(sql);	            
	        	stmt.setInt(1, idFilme);	            
	        	stmt.executeUpdate();
	            
	        	stmt.close();
	        	stmt.close();
	            
	        } catch (SQLException e) {
	            System.out.println("Erro ao registrar o voto: " + e.getMessage());
	        }
	    }
	 public void atualizarPosicoesFilmes() {
		 String updateSql = "UPDATE filme SET posicaoFilme = ? WHERE idFilme = ?";
		 
		 conn = new Conexao().faz_conexao();
		 try {
		      
		        stmt = conn.prepareStatement(updateSql);
		        
		        String selectSql = "SELECT idFilme FROM filme WHERE votosFilme > 0 ORDER BY votosFilme DESC";
		        Statement selectStatement = conn.createStatement();
		        ResultSet resultSet = selectStatement.executeQuery(selectSql);
		        
		        int posicao = 1;
		        
		        while (resultSet.next()) {
		            int idFilme = resultSet.getInt("idFilme");
		            
		            stmt.setInt(1, posicao);
		            stmt.setInt(2, idFilme);
		            
		            stmt.executeUpdate();
		            
		            posicao++;
		        }
		        
		        resultSet.close();
		        selectStatement.close();
		        stmt.close();
		        conn.close();
		        

		    } catch (SQLException e) {
		        System.out.println("Erro ao atualizar as posições: " + e.getMessage());
		    }
}
	 public void excluirFilme(Ranking filme) {
			String sql = "delete from filme where idFilme = ?";

			conn = new Conexao().faz_conexao();
			
			try {
				
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, filme.getIdFilme());
				
				stmt.execute();
				stmt.close();
				
				JOptionPane.showMessageDialog(null,"Filme excluido com sucesso!");
				
			} catch (SQLException e) {
				
				JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao excluir -> " + e);
			}
		}
}
