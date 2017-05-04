package com.example.jogomatematica.visao;


import java.util.Calendar;
import com.example.jogomatematica.R;
import com.example.jogomatematica.controle.ControleJogoMatematica;
import com.example.jogomatematica.controle.ControleUtil;
import com.example.jogomatematica.modelo.ModeloJogador;
import com.example.jogomatematica.modelo.ModeloPontuacao;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class VisaoJogoMatematica extends ActionBarActivity {

	private TextView txtCerto, txtErrado;	
	private ImageView imgNumero1, imgNumero2, imgResultado3, imgResultado2,
			imgResultado1, imgResposta1, imgResposta2, imgResposta3;
	private String sRespostaSelecionada;
	Calendar dtInicioJogo, dtFinalJogo;
		
	
	
	ControleJogoMatematica controleJogoMatematica = new ControleJogoMatematica();
	ModeloJogador modeloJogador = new ModeloJogador();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		try {
			dtInicioJogo = ControleUtil.retornaDataAtual();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Carregando valores para as variaveis	
		imgNumero1 = (ImageView) findViewById(R.id.imgNumero1);
		imgNumero2 = (ImageView) findViewById(R.id.imgNumero2);
		
		imgResposta1 = (ImageView)findViewById(R.id.imgResposta1);
		imgResposta2 = (ImageView)findViewById(R.id.imgResposta2);
		imgResposta3 = (ImageView)findViewById(R.id.imgResposta3);
		
		imgResultado1 = (ImageView) findViewById(R.id.imgResultado1);
		imgResultado2 = (ImageView) findViewById(R.id.imgResultado2);
		imgResultado3 = (ImageView) findViewById(R.id.imgResultado3);
		txtCerto = (TextView) findViewById(R.id.txtCerto);
		txtErrado = (TextView) findViewById(R.id.txtErrado);
		
		//Iniciando os valores
		controleJogoMatematica.iniciaOperacao(imgNumero1, imgNumero2, imgResultado1, imgResultado2, imgResultado3, imgResposta1, imgResposta2, imgResposta3);
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;

	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar  m clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	
	// Resposta 1
	public void imgResultado1(View view) throws InterruptedException {
		//Obtendo o valor da imagem selecionada
		sRespostaSelecionada = getResources().getResourceName((Integer) imgResultado1.getTag());
		
		//Atualiza label de respostas corretas e incorretas
		controleJogoMatematica.totalizaRespostasCorretasEIncorretas(ControleUtil.pegaParteString(sRespostaSelecionada, "/", 1), txtCerto, txtErrado, VisaoJogoMatematica.this);
		
		
		//Gera novos valores
		if(controleJogoMatematica.iniciaOperacao(imgNumero1, imgNumero2, imgResultado1, imgResultado2, imgResultado3, imgResposta1, imgResposta2, imgResposta3) == true){
			dtFinalJogo = ControleUtil.retornaDataAtual();
			ModeloPontuacao.setsTempoAtividade(ControleUtil.identificaDiferencaDeMinutos(dtInicioJogo, dtFinalJogo));
			Intent intent = new Intent(this, VisaoEncerraJogo.class);
			finish();
			startActivity(intent);			
		}		
	}

	// Resposta 2
	public void imgResultado2(View view) throws InterruptedException {
		sRespostaSelecionada = getResources().getResourceName((Integer) imgResultado2.getTag());
		controleJogoMatematica.totalizaRespostasCorretasEIncorretas(ControleUtil.pegaParteString(sRespostaSelecionada, "/", 1), txtCerto, txtErrado, VisaoJogoMatematica.this);
		
		if(controleJogoMatematica.iniciaOperacao(imgNumero1, imgNumero2, imgResultado1, imgResultado2, imgResultado3, imgResposta1, imgResposta2, imgResposta3) == true){
			dtFinalJogo = ControleUtil.retornaDataAtual();
			ModeloPontuacao.setsTempoAtividade(ControleUtil.identificaDiferencaDeMinutos(dtInicioJogo, dtFinalJogo));
			Intent intent = new Intent(this, VisaoEncerraJogo.class);
			finish();
			startActivity(intent);
		}
	}

	// Resposta 3
	public void imgResultado3(View view) throws InterruptedException {
		sRespostaSelecionada = getResources().getResourceName((Integer) imgResultado3.getTag());
		controleJogoMatematica.totalizaRespostasCorretasEIncorretas(ControleUtil.pegaParteString(sRespostaSelecionada, "/", 1), txtCerto, txtErrado, VisaoJogoMatematica.this);
		if(controleJogoMatematica.iniciaOperacao(imgNumero1, imgNumero2, imgResultado1, imgResultado2, imgResultado3, imgResposta1, imgResposta2, imgResposta3) == true){
			dtFinalJogo = ControleUtil.retornaDataAtual();
			ModeloPontuacao.setsTempoAtividade(ControleUtil.identificaDiferencaDeMinutos(dtInicioJogo, dtFinalJogo));
			Intent intent = new Intent(this, VisaoEncerraJogo.class);
			finish();
			startActivity(intent);
		}
	}	
}

