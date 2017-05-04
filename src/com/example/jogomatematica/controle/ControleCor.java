package com.example.jogomatematica.controle;

import java.io.Serializable;
import android.graphics.Color;
import android.widget.ImageView;

public class ControleCor implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	public String sCorIncorreta;
	
	
	
	public String[][] matrizDeCoresComRgb = { { "Azul", "000", "000", "255" },
			{ "Vermelho", "255", "000", "000" },
			{ "Verde", "000", "255", "000" },

			{ "Amarelo", "255", "255", "000" },
			{ "Rosa", "255", "000", "255" },
			{ "AzulBebe", "000", "255", "255" } };
	

	public Integer retornaPosicaoCorNaMatrizDeCores(String sDescricaoCor, Boolean bRespostaCorreta, Boolean bRespostaIncorreta) {

		Integer iPosicaoCor = 0;

		if (bRespostaCorreta == true) {
			mainLoop: for (int i = 0; i < matrizDeCoresComRgb.length; i++) {
				for (int j = 0; j < matrizDeCoresComRgb[i].length; j++) {
					if (matrizDeCoresComRgb[i][j].toString().equals(sDescricaoCor)) {
						iPosicaoCor = i;
						break mainLoop;
					}
				}
			}
		}

		if (bRespostaIncorreta == true) {
			mainLoop: for (int i = ControleUtil.gerarNumeroRandomicamente(0, 5); i < matrizDeCoresComRgb.length; i++) {
				for (int j = 0; j < matrizDeCoresComRgb[i].length; j++) {
					if (matrizDeCoresComRgb[i][j].toString() != (sDescricaoCor)) {
						if (matrizDeCoresComRgb[i][j].toString() != (sCorIncorreta)) {
							iPosicaoCor = i;
							sCorIncorreta = matrizDeCoresComRgb[i][j].toString();
							break mainLoop;
						} else
							continue mainLoop;

					} else
						continue mainLoop;
				}
			}
		}
		return iPosicaoCor;
	}
	

	public String identificaJuncaoDasCores(String sCor1, String sCor2) {

		String sResultado = "";

		if (sCor1.equals(sCor2)) {
			sResultado = sCor1;
		}

		if (sCor1.equals("Azul") && sCor2.equals("Verde")
				|| (sCor1.equals("Verde") && sCor2.equals("Azul"))) {
			sResultado = "AzulBebe";
		}

		if (sCor1.equals("Azul") && sCor2.equals("Vermelho")
				|| (sCor1.equals("Vermelho") && sCor2.equals("Azul"))) {
			sResultado = "Rosa";
		}

		if (sCor1.equals("Vermelho") && sCor2.equals("Verde")
				|| (sCor1.equals("Verde") && sCor2.equals("Vermelho"))) {
			sResultado = "Amarelo";
		}
		
		return sResultado;
	}

	
	public String realizaTrocaDeCores(ImageView imgResultado, ImageView imgResposta, Integer iPosicaoVetor) {		

		Integer CorR = Integer.parseInt(matrizDeCoresComRgb[iPosicaoVetor][1].toString());
		Integer CorG = Integer.parseInt(matrizDeCoresComRgb[iPosicaoVetor][2].toString());
		Integer CorB = Integer.parseInt(matrizDeCoresComRgb[iPosicaoVetor][3].toString());

		imgResultado.setBackgroundColor(Color.rgb(CorR, CorG, CorB));
		
		imgResposta.setBackgroundColor(Color.rgb(CorR, CorG, CorB));

		return matrizDeCoresComRgb[iPosicaoVetor][0].toString();
	}
}
