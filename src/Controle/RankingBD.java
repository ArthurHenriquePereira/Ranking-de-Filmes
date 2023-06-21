package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.Ranking;

public class RankingBD {

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	ArrayList<Ranking> lista = new ArrayList<>();
	
	public ArrayList <Ranking> pesquisarFilmes(){
		String sql = "select * from filme";

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
	
}
