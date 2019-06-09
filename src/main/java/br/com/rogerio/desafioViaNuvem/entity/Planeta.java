package br.com.rogerio.desafioViaNuvem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_PLANETA")
public class Planeta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COD_PLANETA")
	private int cod_planeta;
	
	@Column(name="nm_planeta", nullable = false, length = 50)
	private String nome;
	
	@Column(name="nm_clima", nullable = false, length = 50)
	private String clima;
	
	@Column(name="nm_terreno", nullable = false, length = 50)
	private String terreno;
	
	@Column(name="qt_filmes", nullable = false)
	private int qt_filmes;
	
	

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
