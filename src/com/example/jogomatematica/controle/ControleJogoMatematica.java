package com.example.jogomatematica.controle;

import java.io.Serializable;
import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.jogomatematica.R;
import com.example.jogomatematica.modelo.ModeloPontuacao;


public class ControleJogoMatematica implements Serializable {
	
	public Button btnTeste;
	private int iQtdJogadas;//iTotRespCertas, iTotRespErradas, 
	int iAleatorio1, iAleatorio2, iResultado, iResultadoFinal, iResultadoFinalIncorreto1, iResultadoFinalIncorreto2;
	


	ControleCor cor = new ControleCor();
	ModeloPontuacao modeloPontuacao = new ModeloPontuacao();
	
		
	public String[][] matrizDeNumeros = {
			{ "0", String.valueOf(R.drawable.zero), "zero" },
			{ "1", String.valueOf(R.drawable.um), "um" },
			{ "2", String.valueOf(R.drawable.dois), "dois" },
			{ "3", String.valueOf(R.drawable.tres), "tres" },
			{ "4", String.valueOf(R.drawable.quatro), "quatro" },
			{ "5", String.valueOf(R.drawable.cinco), "cinco" },
			{ "6", String.valueOf(R.drawable.seis), "seis" },
			{ "7", String.valueOf(R.drawable.sete), "sete" },
			{ "8", String.valueOf(R.drawable.oito), "oito" },
			{ "9", String.valueOf(R.drawable.nove), "nove" },
			{ "10", String.valueOf(R.drawable.dez), "dez" },
			{ "11", String.valueOf(R.drawable.onze), "onze" },
			{ "12", String.valueOf(R.drawable.doze), "doze" },
			{ "13", String.valueOf(R.drawable.treze), "treze" },
			{ "14", String.valueOf(R.drawable.quatorze), "quatorze" },
			{ "15", String.valueOf(R.drawable.quinze), "quinze" },
			{ "16", String.valueOf(R.drawable.dezeseis), "dezeseis" },
			{ "17", String.valueOf(R.drawable.dezesete), "dezesete" },
			{ "18", String.valueOf(R.drawable.dezoito), "dezoito" } 
	};
	

	public Integer consultaMatrizDeNumerosPorInteiro(int iNumero) {
		int iResultado = 0;

		for (int i = 0; i < matrizDeNumeros.length; i++) {

			for (int j = 0; j < matrizDeNumeros[i].length; j++) {
				if (matrizDeNumeros[i][j].toString().equals(
						Integer.toString(iNumero))) {
					// Obtendo valor em String
					iResultado = Integer.parseInt(matrizDeNumeros[i][j + 1].toString());
				}
			}
		}
		return iResultado;
	}


	public String consultaMatrizDeNumerosPorString(String sNumero) {
		String sResultado = "";

		for (int i = 0; i < matrizDeNumeros.length; i++) {

			for (int j = 0; j < matrizDeNumeros[i].length; j++) {
				if (matrizDeNumeros[i][j].toString().equals(sNumero)) {
					// Obtendo valor em String
					sResultado = matrizDeNumeros[i][j - 2].toString();
					break;
				}
			}
		}
		return sResultado;
	}



	public void totalizaRespostasCorretasEIncorretas(String sValor, TextView txtCerto, TextView txtErrado, Context cClasseVisao) {
		
		if (consultaMatrizDeNumerosPorString(sValor).equals(Integer.toString(iResultado))) {
			
			modeloPontuacao.setiQtdAcertos(modeloPontuacao.getiQtdAcertos() + 1);			
			txtCerto.setText("Certas: " + Integer.toString(modeloPontuacao.getiQtdAcertos()));
			ControleToast.show(cClasseVisao, "     Acertou!!!", 1);
		} else{
			modeloPontuacao.setiQtdErros(modeloPontuacao.getiQtdErros() + 1);
			txtErrado.setText("Erradas: " + Integer.toString(modeloPontuacao.getiQtdErros()));
			ControleToast.show(cClasseVisao, "     Errou!", 0);}
	}
	
	
	public Boolean iniciaOperacao(ImageView imgNumero1, ImageView imgNumero2, ImageView imgResultado1, ImageView imgResultado2, ImageView imgResultado3, ImageView imgResposta1, ImageView imgResposta2, ImageView imgResposta3) {
		String sCorImgNumero1, sCorImgNumero2;
		Boolean bConcluiuJogadas;
		iQtdJogadas = iQtdJogadas + 1;
		

		iAleatorio1 = ControleUtil.gerarNumeroRandomicamente(0, 10);
		iAleatorio2 = ControleUtil.gerarNumeroRandomicamente(0, 10);

		// Troca imagem 1
		imgNumero1.setImageResource(consultaMatrizDeNumerosPorInteiro(iAleatorio1));
		sCorImgNumero1 = cor.realizaTrocaDeCores(imgNumero1, imgNumero1, ControleUtil.gerarNumeroRandomicamente(0, 3));

		// Troca imagem 2
		imgNumero2.setImageResource(consultaMatrizDeNumerosPorInteiro(iAleatorio2));
		sCorImgNumero2 = cor.realizaTrocaDeCores(imgNumero2, imgNumero2, ControleUtil.gerarNumeroRandomicamente(0, 3));

		// Calculo
		iResultado = iAleatorio1 + iAleatorio2;

		// Pegando valor da imagem
		iResultadoFinal = consultaMatrizDeNumerosPorInteiro(iResultado);

		// Atribui valores randomicos para as opções incorretas
		iResultadoFinalIncorreto1 = consultaMatrizDeNumerosPorInteiro(ControleUtil.gerarNumeroRandomicamente(0, 19));
		iResultadoFinalIncorreto2 = consultaMatrizDeNumerosPorInteiro(ControleUtil.gerarNumeroRandomicamente(0, 19));

		// Altera o valor das respostas, caso seja igual a alguma outra
		while (iResultadoFinalIncorreto1 == iResultadoFinal) {
			iResultadoFinalIncorreto1 = consultaMatrizDeNumerosPorInteiro(ControleUtil.gerarNumeroRandomicamente(0, 19));
		}

		while ((iResultadoFinalIncorreto2 == iResultadoFinal)
				|| (iResultadoFinalIncorreto2 == iResultadoFinalIncorreto1)) {
			iResultadoFinalIncorreto2 = consultaMatrizDeNumerosPorInteiro(ControleUtil.gerarNumeroRandomicamente(0, 19));
		}

		// Realiza o set na imagem
		switch (ControleUtil.gerarNumeroRandomicamente(1, 3)) { // setTag = para
															// conseguir obter a
															// descrição da
															// imagem
		case 1:
			imgResultado1.setImageResource(iResultadoFinal);
			imgResultado1.setTag(iResultadoFinal);
			cor.realizaTrocaDeCores(imgResultado1, imgResposta1, cor.retornaPosicaoCorNaMatrizDeCores(cor.identificaJuncaoDasCores(sCorImgNumero1, sCorImgNumero2), true, false));
		

			imgResultado2.setImageResource(iResultadoFinalIncorreto1);
			imgResultado2.setTag(iResultadoFinalIncorreto1);
			cor.realizaTrocaDeCores(imgResultado2, imgResposta2, cor.retornaPosicaoCorNaMatrizDeCores(cor.identificaJuncaoDasCores(sCorImgNumero1, sCorImgNumero2), false, true));
		

			imgResultado3.setImageResource(iResultadoFinalIncorreto2);
			imgResultado3.setTag(iResultadoFinalIncorreto2);
			cor.realizaTrocaDeCores(imgResultado3, imgResposta3, cor.retornaPosicaoCorNaMatrizDeCores(cor.identificaJuncaoDasCores(sCorImgNumero1, sCorImgNumero2), false, true));
		
			break;

		case 2:
			imgResultado2.setImageResource(iResultadoFinal);
			imgResultado2.setTag(iResultadoFinal);
			cor.realizaTrocaDeCores(imgResultado2, imgResposta2, cor.retornaPosicaoCorNaMatrizDeCores(cor.identificaJuncaoDasCores(sCorImgNumero1, sCorImgNumero2), true, false));
		

			imgResultado1.setImageResource(iResultadoFinalIncorreto1);
			imgResultado1.setTag(iResultadoFinalIncorreto1);
			cor.realizaTrocaDeCores(imgResultado1, imgResposta1, cor.retornaPosicaoCorNaMatrizDeCores(cor.identificaJuncaoDasCores(sCorImgNumero1, sCorImgNumero2), false, true));
		

			imgResultado3.setImageResource(iResultadoFinalIncorreto2);
			imgResultado3.setTag(iResultadoFinalIncorreto2);
			cor.realizaTrocaDeCores(imgResultado3, imgResposta3, cor.retornaPosicaoCorNaMatrizDeCores(cor.identificaJuncaoDasCores(sCorImgNumero1, sCorImgNumero2), false, true));
		
			break;

		case 3:
			imgResultado3.setImageResource(iResultadoFinal);
			imgResultado3.setTag(iResultadoFinal);
			cor.realizaTrocaDeCores(imgResultado3, imgResposta3, cor.retornaPosicaoCorNaMatrizDeCores(cor.identificaJuncaoDasCores(sCorImgNumero1, sCorImgNumero2), true, false));
		

			imgResultado1.setImageResource(iResultadoFinalIncorreto1);
			imgResultado1.setTag(iResultadoFinalIncorreto1);
			cor.realizaTrocaDeCores(imgResultado1, imgResposta1, cor.retornaPosicaoCorNaMatrizDeCores(cor.identificaJuncaoDasCores(sCorImgNumero1, sCorImgNumero2), false, true));
		

			imgResultado2.setImageResource(iResultadoFinalIncorreto2);
			imgResultado2.setTag(iResultadoFinalIncorreto2);
			cor.realizaTrocaDeCores(imgResultado2, imgResposta2, cor.retornaPosicaoCorNaMatrizDeCores(cor.identificaJuncaoDasCores(sCorImgNumero1, sCorImgNumero2), false, true));
		
			break;
		}
		
		bConcluiuJogadas = false;
		
		
		if (iQtdJogadas == 11){
			bConcluiuJogadas = true;			
		}
		
		return bConcluiuJogadas;
	}
}
