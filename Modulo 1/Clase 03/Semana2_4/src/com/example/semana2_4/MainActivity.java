package com.example.semana2_4;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView lblTexto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lblTexto = (TextView) findViewById(R.id.lblTexto);
		lblTexto.setText(Html.fromHtml("Sign in with<br/>Google"));
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Typeface typeFace = Typeface.createFromAsset(getAssets(),
				"fonts/leadcoat.ttf");
		lblTexto.setTypeface(typeFace);
	}
}
