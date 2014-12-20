package com.area51.semana3_3;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.area51.adapters.GridAdapter;
import com.area51.models.Imagenes;
import com.area51.models.Persona;
import com.area51.utils.Constant;

public class MainActivity extends Activity {
	EditText txtNombre;
	EditText txtApellido;
	Spinner spSexo;
	Button btnGrabar;
	Button btnSiguiente;
	GridView gvGrilla;
	GridAdapter adapterGrilla;
	String rutaImagen = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtNombre = (EditText) findViewById(R.id.txtNombre);
		txtApellido = (EditText) findViewById(R.id.txtApellido);
		spSexo = (Spinner) findViewById(R.id.spSexo);
		btnGrabar = (Button) findViewById(R.id.btnGrabar);
		btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
		gvGrilla = (GridView) findViewById(R.id.gvGrilla);
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
						&& !txtApellido.getText().toString().trim().equals("")
						&& !rutaImagen.equals("")) {
					Constant.listaPersona.add(new Persona(Constant.listaPersona
							.size(), txtNombre.getText().toString(),
							txtApellido.getText().toString(), spSexo
									.getSelectedItem().toString(), rutaImagen));
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
		if (Constant.listaImagenes == null) {
			Constant.listaImagenes = new ArrayList<Imagenes>();
			for (int i = 100; i < 200; i++) {
				Constant.listaImagenes.add(new Imagenes(
						"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_"
								+ i + ".jpg"));
			}
		}
		adapterGrilla = new GridAdapter(getApplicationContext(),
				R.layout.item_grid, Constant.listaImagenes);
		gvGrilla.setAdapter(adapterGrilla);
		gvGrilla.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				rutaImagen = Constant.listaImagenes.get(position)
						.getRutaImagen();
			}
		});
	}

	protected void limpiarCampos() {
		// TODO Auto-generated method stub
		txtNombre.setText("");
		txtApellido.setText("");
		spSexo.setSelection(0);
		rutaImagen = "";
	}
}
