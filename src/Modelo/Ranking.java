package Modelo;

public class Ranking {
	private int idFilme, posicaoFilme, votosFilme;
	private String nomeFilme;
	public String getNomeFilme() {
		return nomeFilme;
	}
	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	public int getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	public int getPosicaoFilme() {
		return posicaoFilme;
	}
	public void setPosicaoFilme(int posicaoFilme) {
		this.posicaoFilme = posicaoFilme;
	}
	public int getVotosFilme() {
		return votosFilme;
	}
	public void setVotosFilme(int votosFilme) {
		this.votosFilme = votosFilme;
	}
	
}
