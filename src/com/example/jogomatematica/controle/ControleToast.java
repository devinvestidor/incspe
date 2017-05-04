package com.example.jogomatematica.controle;
import com.example.jogomatematica.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



public class ControleToast {
	
	public static final int ERRO       = 0;
	public static final int ACERTO     = 1;
	
	public static void show(Context context, String text, int toastType) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.toast_layout, null);
		
		TextView tv = (TextView) layout.findViewById(R.id.tvTexto);
		tv.setText(text);
		
		LinearLayout llRoot = (LinearLayout) layout.findViewById(R.id.llRoot);
		
		Drawable img = null;
		int bg = 0;
		
		switch (toastType) {
		case ERRO:
			img = context.getResources().getDrawable(R.drawable.triste);
			bg  = R.drawable.toast_background_red; 
			break;
		case ACERTO:
			img = context.getResources().getDrawable(R.drawable.feliz);
			bg  = R.drawable.toast_background_green;
			break;
		}
 		tv.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
 		llRoot.setBackgroundResource(bg);
		
		Toast toast = new Toast(context);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(layout);		
		toast.show();		
	}

}
