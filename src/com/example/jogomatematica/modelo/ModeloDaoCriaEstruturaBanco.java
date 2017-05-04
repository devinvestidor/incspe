package com.example.jogomatematica.modelo;

import java.io.Serializable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ModeloDaoCriaEstruturaBanco extends SQLiteOpenHelper implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private static final String NOME_BD = "base_incspe";
	private static final int VERSAO_BD = 1;
	
	//Cria a estrutura do banco de dados
	public ModeloDaoCriaEstruturaBanco(Context ctx){
		super(ctx, NOME_BD, null, VERSAO_BD);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase bd) {
		bd.execSQL("create table pontuacao(	  _iCod integer primary key autoincrement, "+
				   "						  sNomeJogo text not null, 			       "+
				   "						  sNomeJogador text not null, 			   "+
				   "                          sTempoAtividade text not null,           "+
				   "						  iQtdAcertos integer, 			           "+
				   "                          iQtdErros integer);                      ");

	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
		bd.execSQL("drop table pontuacao;");
		onCreate(bd);
	}
	

	
	
	


	

}
