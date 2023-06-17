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
	
}
