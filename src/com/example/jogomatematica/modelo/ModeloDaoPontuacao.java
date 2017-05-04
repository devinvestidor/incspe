package com.example.jogomatematica.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ModeloDaoPontuacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private SQLiteDatabase bd;
	
	//Realiza as operações no banco já criado
	public ModeloDaoPontuacao(Context context){
		ModeloDaoCriaEstruturaBanco auxBd = new ModeloDaoCriaEstruturaBanco(context);
		bd = auxBd.getWritableDatabase();
	}
	
	
	public void inserir(){
		ContentValues valores = new ContentValues();
		valores.put("sNomeJogo", ModeloJogador.getsNome());
		valores.put("sNomeJogador", ModeloJogador.getsNome());
		valores.put("sTempoAtividade", ModeloPontuacao.getsTempoAtividade());
		valores.put("iQtdAcertos", ModeloPontuacao.getiQtdAcertos());
		valores.put("iQtdErros", ModeloPontuacao.getiQtdErros());
		
		bd.insert("pontuacao", null, valores);
	}
	
	
	
	//Realiza a consulta no banco de dados
	public List<ModeloPontuacao> relatorioPontuacao(){
		List<ModeloPontuacao> list = new ArrayList<ModeloPontuacao>();
		String[] colunas = new String[]{"sNomeJogo, sNomeJogador, sTempoAtividade, iQtdAcertos, iQtdErros"};
		
		
		Cursor cursor = bd.query("pontuacao", colunas, null, null, null, null, "sNomeJogador ASC");
		
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			
			do{
				//Fazer relatório
				ModeloPontuacao pontuacao = new ModeloPontuacao();
				
				pontuacao.setsNomeJogo(cursor.getString(0));
				pontuacao.setsNomeJogador(cursor.getString(1));				
				pontuacao.setsTempoAtividade2(cursor.getString(2));
				pontuacao.setiQtdAcertos2(cursor.getInt(3));
				pontuacao.setiQtdErros2(cursor.getInt(4));
								
				list.add(pontuacao); 
				
				
			}while(cursor.moveToNext());
		}		
		
		return(list);
	}


}
