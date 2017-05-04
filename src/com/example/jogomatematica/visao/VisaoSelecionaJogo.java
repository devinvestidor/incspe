package com.example.jogomatematica.visao;

import com.example.jogomatematica.R;
import com.example.jogomatematica.modelo.ModeloJogo;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class VisaoSelecionaJogo extends ActionBarActivity {
	ModeloJogo modeloJogo = new ModeloJogo();
	ImageView imgJogoMatematica;		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visao_seleciona_jogo);
		imgJogoMatematica = (ImageView) findViewById(R.id.imgJogoMatematica);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.visao_seleciona_jogo, menu);
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
	
	public void imgJogoMatematica(View view) throws InterruptedException {
		modeloJogo.setsNome("Jogo de Matemática");		
		Intent intent = new Intent(this, VisaoJogoMatematica.class);
		finish();
		startActivity(intent);	
	}
}
