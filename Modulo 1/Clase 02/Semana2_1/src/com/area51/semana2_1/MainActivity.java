package com.area51.semana2_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btnSiguiente;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		btnSiguiente.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						SegundoActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
