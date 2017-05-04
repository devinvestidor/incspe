package com.example.jogomatematica.visao;


import com.example.jogomatematica.R;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class VisaoMainTelaInicial extends ActionBarActivity {
	
	private ImageView imgSound;
	public MediaPlayer media;
	public Boolean bMusicaFundo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_tela_inicial);
		
		imgSound = (ImageView) findViewById(R.id.imgSound);
		
	    media = MediaPlayer.create(this.getApplicationContext(), R.raw.musicafundocompleta);
	    media.setLooping(true);
		media.start();
		bMusicaFundo = true;
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_tela_inicial, menu);
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
	
	
	public void btnSair(View view) throws InterruptedException {		 
		finish();
		
		
	}
	
	
	public void imgSound(View view) throws InterruptedException {		
		
		if (bMusicaFundo == true ){			
			media.pause();
			bMusicaFundo = false;
			imgSound.setImageResource(R.drawable.notsound);
		}
		else{
			media.start();
			bMusicaFundo = true;
			imgSound.setImageResource(R.drawable.sound);
		}		
	}
	
	
	
	public void btnIniciar(View view) throws InterruptedException {
		
		Intent intent = new Intent(this, VisaoDefineNomeJogador.class);		
		startActivity(intent);	

	}
	
	
	public void btnPontuacao(View view) throws InterruptedException {
		Intent intent = new Intent(this, VisaoPontuacao.class);
		startActivity(intent);	

	}
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		media.stop();		
		
	}
	
	
	
}
