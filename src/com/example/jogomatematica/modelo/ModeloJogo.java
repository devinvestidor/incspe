package com.example.jogomatematica.modelo;

import java.io.Serializable;

public class ModeloJogo implements Serializable {

	private static final long serialVersionUID = 1L;
	private static String sNome;
	
	public static String getsNome() {
		return sNome;
	}
	public void setsNome(String sNome) {
		this.sNome = sNome;
	}
	

}
