package com.example.semana1_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView lblTexto;
	Button btnProbar;
	EditText txtTextoIngresado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lblTexto = (TextView) findViewById(R.id.lblTexto);
		btnProbar = (Button) findViewById(R.id.btnProbar);
		txtTextoIngresado = (EditText) findViewById(R.id.txtTextoIngresado);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		lblTexto.setText(R.string.home);

		btnProbar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// lblTexto.setText(R.string.texto_cambiado);
				lblTexto.setText(txtTextoIngresado.getText().toString());
			}
		});
	}
}
