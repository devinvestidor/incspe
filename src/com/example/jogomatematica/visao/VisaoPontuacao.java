package com.example.jogomatematica.visao;

import com.example.jogomatematica.R;
import com.example.jogomatematica.modelo.ModeloDaoPontuacao;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class VisaoPontuacao extends ActionBarActivity {
	
	private ImageView imgSound;
	private EditText edtResultadoRelatio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visao_pontuacao);
		
		imgSound = (ImageView) findViewById(R.id.imgSound);
		edtResultadoRelatio = (EditText) findViewById(R.id.edtResultadoRelatio);
		
		ModeloDaoPontuacao modeloDaoPontuacao = new ModeloDaoPontuacao(this);
		
		String sResultado = "";
		
		for (int i = 0; i < modeloDaoPontuacao.relatorioPontuacao().size(); i++) {
			sResultado = modeloDaoPontuacao.relatorioPontuacao().get(i).getsNomeJogador() 	  + "   |   " +						 
						 modeloDaoPontuacao.relatorioPontuacao().get(i).getiQtdErros2()    	  + "   |   " +
					     modeloDaoPontuacao.relatorioPontuacao().get(i).getiQtdAcertos2() 	  + "   |   " +
					     modeloDaoPontuacao.relatorioPontuacao().get(i).getsTempoAtividade2() + "\n"      +
					     sResultado;
			
		}
		
		sResultado = "Nome   |   Erros   |   Acertos   |   Tempo" + "\n" + sResultado;
		
		edtResultadoRelatio.setText(sResultado);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.visao_pontuacao, menu);
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
	
	
	
	
	public void imgSound(View view) throws InterruptedException {		
		
		
		
		
	}
	
	
}
