package br.com.rogerio.desafioViaNuvem.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlanetaHttp {
	
	private int cod_planeta;
	private String nome;
	private String clima;
	private String terreno;
	private int qt_filmes;
	
	
	public PlanetaHttp(int cod_planeta, String nome, String clima, String terreno, int qt_filmes) {
		super();
		this.cod_planeta = cod_planeta;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.qt_filmes = qt_filmes;
	}
	public PlanetaHttp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCod_planeta() {
		return cod_planeta;
	}
	public void setCod_planeta(int cod_planeta) {
		this.cod_planeta = cod_planeta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	public int getQt_filmes() {
		return qt_filmes;
	}
	public void setQt_filmes(int qt_filmes) {
		this.qt_filmes = qt_filmes;
	}
	
	

}
