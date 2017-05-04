package com.example.jogomatematica.visao;

import com.example.jogomatematica.R;
import com.example.jogomatematica.modelo.ModeloDaoPontuacao;
import com.example.jogomatematica.modelo.ModeloJogador;
import com.example.jogomatematica.modelo.ModeloPontuacao;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class VisaoEncerraJogo extends ActionBarActivity {
	TextView tvNomeJogador, tvCerto, tvErrada, tvTempoAtividade;
	ModeloJogador modeloJogador = new ModeloJogador();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visao_encerra_jogo);
		
		tvNomeJogador = (TextView) findViewById(R.id.tvNomeJogador);
		tvCerto = (TextView) findViewById(R.id.tvCerto);
		tvErrada = (TextView) findViewById(R.id.tvErrada);
		tvTempoAtividade = (TextView) findViewById(R.id.tvTempoAtividade);
	
		
		
		//Atribuindo valores para o xml
		tvNomeJogador.setText(ModeloJogador.getsNome());
		tvCerto.setText("Certas: " + Integer.toString(ModeloPontuacao.getiQtdAcertos()) );
		tvErrada.setText("Erradas: " + Integer.toString(ModeloPontuacao.getiQtdErros()));
		tvTempoAtividade.setText("Tempo Atividade: " + ModeloPontuacao.getsTempoAtividade());
		
		ModeloDaoPontuacao modeloDaoPontuacao = new ModeloDaoPontuacao(this); 
		modeloDaoPontuacao.inserir();		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.visao_encerra_jogo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void btnVoltar(View view) throws InterruptedException {
		ModeloPontuacao.setiQtdAcertos(0);
		ModeloPontuacao.setiQtdErros(0);
		Intent intent = new Intent(this, VisaoMainTelaInicial.class);
		finish();
		startActivity(intent);
		
		
		
	}
	
}
