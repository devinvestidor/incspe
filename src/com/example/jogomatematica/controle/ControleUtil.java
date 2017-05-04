package com.example.jogomatematica.controle;

import java.io.Serializable;
import java.util.Calendar;


public class ControleUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static Integer gerarNumeroRandomicamente(int iDe, int iAte) {
		int iResultado = 0;

		iResultado = iDe + (int) (Math.random() * iAte);
		return iResultado;
	}
	
	
	public static String pegaParteString(String sValor, String sCaracter, int iPosicaoRetorno){
		String[] sValorAlterado = sValor.split(sCaracter);
		return sValorAlterado[iPosicaoRetorno];
	}
	
	public static Calendar retornaDataAtual() throws InterruptedException{
		Calendar dtAtual = Calendar.getInstance();		
		return dtAtual;
	}

	public static String identificaDiferencaDeMinutos(Calendar dtInicial, Calendar dtFinal){
		
		long lMinutos = (dtFinal.getTimeInMillis() - dtInicial.getTimeInMillis() ) / 60000;
		long lSegundos = (dtFinal.getTimeInMillis() - dtInicial.getTimeInMillis()) / 1000;		
		long lDiferenca = lSegundos - (lMinutos * 60);
		
		String sVAlorCompleto = String.valueOf(lMinutos) + " minuto(s) e " + String.valueOf(lDiferenca) + " segundo(s)";
		
		return sVAlorCompleto;
	}
	
	
}
