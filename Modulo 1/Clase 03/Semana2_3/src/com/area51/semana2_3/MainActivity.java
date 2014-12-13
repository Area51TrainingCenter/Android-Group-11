package com.area51.semana2_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	Spinner spUniversidades;
	TextView lblTexto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spUniversidades = (Spinner) findViewById(R.id.spUniversidades);
		lblTexto = (TextView) findViewById(R.id.lblTexto);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

//		spUniversidades.getSelectedItem().toString();

		spUniversidades.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				lblTexto.setText(spUniversidades.getItemAtPosition(position)
						.toString());
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
	}
}
