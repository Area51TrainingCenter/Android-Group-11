package com.area51.semana3_3;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.area51.models.Persona;
import com.area51.utils.Constant;

public class MainActivity extends Activity {
	EditText txtNombre;
	EditText txtApellido;
	Spinner spSexo;
	Button btnGrabar;
	Button btnSiguiente;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtNombre = (EditText) findViewById(R.id.txtNombre);
		txtApellido = (EditText) findViewById(R.id.txtApellido);
		spSexo = (Spinner) findViewById(R.id.spSexo);
		btnGrabar = (Button) findViewById(R.id.btnGrabar);
		btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		if (Constant.listaPersona == null)
			Constant.listaPersona = new ArrayList<Persona>();

		btnGrabar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!txtNombre.getText().toString().trim().equals("")
						&& !txtApellido.getText().toString().trim().equals("")) {
					Constant.listaPersona.add(new Persona(Constant.listaPersona
							.size(), txtNombre.getText().toString(),
							txtApellido.getText().toString(), spSexo
									.getSelectedItem().toString(),
							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_002.jpg"));
					Toast.makeText(getApplicationContext(),
							getResources().getString(R.string.mensaje_exitoso),
							Toast.LENGTH_SHORT).show();
					limpiarCampos();
				} else {
					Toast.makeText(getApplicationContext(),
							getResources().getString(R.string.campo_requerido),
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		btnSiguiente.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						SiguienteActivity.class);
				startActivity(intent);
				// finish();
			}
		});
	}

	protected void limpiarCampos() {
		// TODO Auto-generated method stub
		txtNombre.setText("");
		txtApellido.setText("");
		spSexo.setSelection(0);
	}
}
