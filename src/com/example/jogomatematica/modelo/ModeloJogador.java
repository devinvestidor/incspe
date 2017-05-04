package com.example.jogomatematica.modelo;

import java.io.Serializable;

public class ModeloJogador implements Serializable {

	private static final long serialVersionUID = 1L;
	private int iCod;
	private static String sNome;
	
	public int getiCod() {
		return iCod;
	}
	public void setiCod(int iCod) {
		this.iCod = iCod;
	}
	public static String getsNome() {
		return sNome;
	}
	public void setsNome(String sNome) {
		this.sNome = sNome;
	}
	
	
	

}
