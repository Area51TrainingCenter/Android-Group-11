package com.area51.semana3_1;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.area51.adapters.ListaAdapter;
import com.area51.models.Pelicula;
import com.area51.utils.Constant;

public class MainActivity extends Activity {
	ListView lvLista;
	ListaAdapter adapter;
	EditText txtTitulo;
	EditText txtDescripcion;
	Button btnRegistrar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lvLista = (ListView) findViewById(R.id.lvLista);
		txtTitulo = (EditText) findViewById(R.id.txtTitulo);
		txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
		btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (Constant.listaPelicula == null) {
			Constant.listaPelicula = new ArrayList<Pelicula>();
			// Constant.listaPelicula
			// .add(new Pelicula(1, "James Bond", "PElicula de ....",
			// "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_004.jpg"));
			// Constant.listaPelicula
			// .add(new Pelicula(2, "James Bond2", "PElicula de ....2",
			// "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_022.jpg"));
			// Constant.listaPelicula
			// .add(new Pelicula(3, "James Bond3", "PElicula de ....3",
			// "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_002.jpg"));
			// Constant.listaPelicula
			// .add(new Pelicula(4, "James Bond4", "PElicula de ....4",
			// "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_113.jpg"));
			// Constant.listaPelicula
			// .add(new Pelicula(5, "James Bond5", "PElicula de ....5",
			// "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_126.jpg"));
		}
		adapter = new ListaAdapter(getApplicationContext());
		lvLista.setAdapter(adapter);
		btnRegistrar.setTag(-1);
		btnRegistrar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (txtTitulo.getText().toString().equals(""))
					txtTitulo.setError("Campo titulo requerido");
				else if (txtDescripcion.getText().toString().equals(""))
					txtDescripcion.setError("Campo descripcion requerido");
				else if (!txtTitulo.getText().toString().equals("")
						&& !txtDescripcion.getText().toString().equals("")) {
					int idPelicula = Integer.parseInt(btnRegistrar.getTag()
							.toString());
					if (idPelicula == -1) {
						Constant.listaPelicula.add(new Pelicula(
								Constant.listaPelicula.size(), txtTitulo
										.getText().toString(), txtDescripcion
										.getText().toString(),
								"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_126.jpg"));
					} else {
						Constant.listaPelicula.get(idPelicula).setTitulo(
								txtTitulo.getText().toString());
						Constant.listaPelicula.get(idPelicula).setDescripcion(
								txtDescripcion.getText().toString());
						btnRegistrar.setTag(-1);
					}
					adapter.notifyDataSetChanged();
					limpiarDatos();
				} else
					Toast.makeText(getApplicationContext(),
							"Ingrese todos los datos", Toast.LENGTH_SHORT)
							.show();
			}
		});

		lvLista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					final int position, long id) {
				// TODO Auto-generated method stub
				// Toast.makeText(
				// getApplicationContext(),
				// Constant.listaPelicula.get(position).getTitulo()
				// + " - "
				// + Constant.listaPelicula.get(position)
				// .getDescripcion(), Toast.LENGTH_SHORT)
				// .show();
				AlertDialog.Builder dialog = new Builder(MainActivity.this);
				dialog.setTitle("Seleccione Opcion").setItems(R.array.opciones,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								switch (which) {
								case 0:
									txtTitulo.setText(Constant.listaPelicula
											.get(position).getTitulo());
									txtDescripcion
											.setText(Constant.listaPelicula
													.get(position)
													.getDescripcion());
									btnRegistrar.setTag(Constant.listaPelicula
											.get(position).getId());
									break;
								case 1:
									Constant.listaPelicula.remove(position);
									break;
								}
								adapter.notifyDataSetChanged();
							}
						});
				dialog.show();
			}
		});
	}

	protected void limpiarDatos() {
		// TODO Auto-generated method stub
		txtTitulo.setText("");
		txtDescripcion.setText("");
		txtTitulo.requestFocus();
	}
}
