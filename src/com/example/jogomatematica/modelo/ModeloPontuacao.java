package com.example.jogomatematica.modelo;

import java.io.Serializable;

public class ModeloPontuacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private int iCod;
	private static String sTempoAtividade;
	private String sTempoAtividade2;
	private String sNomeJogo; 
	private String sNomeJogador;
	private static int iQtdAcertos;
	private int iQtdAcertos2;
	private static int iQtdErros;
	private int iQtdErros2;
	
	
	public String getsTempoAtividade2() {
		return sTempoAtividade2;
	}
	public void setsTempoAtividade2(String sTempoAtividade2) {
		this.sTempoAtividade2 = sTempoAtividade2;
	}
	public int getiQtdAcertos2() {
		return iQtdAcertos2;
	}
	public void setiQtdAcertos2(int iQtdAcertos2) {
		this.iQtdAcertos2 = iQtdAcertos2;
	}
	public int getiQtdErros2() {
		return iQtdErros2;
	}
	public void setiQtdErros2(int iQtdErros2) {
		this.iQtdErros2 = iQtdErros2;
	}
	public String getsNomeJogo() {
		return sNomeJogo;
	}
	public void setsNomeJogo(String sNomeJogo) {
		this.sNomeJogo = sNomeJogo;
	}
	public String getsNomeJogador() {
		return sNomeJogador;
	}
	public void setsNomeJogador(String sNomeJogador) {
		this.sNomeJogador = sNomeJogador;
	}
	public static String getsTempoAtividade() {
		return sTempoAtividade;
	}
	public static void setsTempoAtividade(String sTempoAtividade) {
		ModeloPontuacao.sTempoAtividade = sTempoAtividade;
	}
	public static int getiQtdAcertos() {
		return iQtdAcertos;
	}
	public static void setiQtdAcertos(int iQtdAcertos) {
		ModeloPontuacao.iQtdAcertos = iQtdAcertos;
	}
	public static int getiQtdErros() {
		return iQtdErros;
	}
	public static void setiQtdErros(int iQtdErros) {
		ModeloPontuacao.iQtdErros = iQtdErros;
	}
	public int getiCod() {
		return iCod;
	}
	public void setiCod(int iCod) {
		this.iCod = iCod;
	}

	
	

}
