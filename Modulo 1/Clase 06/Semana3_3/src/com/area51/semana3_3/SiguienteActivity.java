package com.area51.semana3_3;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;

import com.area51.adapters.GridAdapter;
import com.area51.adapters.ListaAdapter;
import com.area51.models.Imagenes;
import com.area51.utils.Constant;

public class SiguienteActivity extends Activity {
	ListView lvLista;
	ListaAdapter adapterLista;
	GridView gvGrilla;
	GridAdapter adapterGrilla;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_siguiente);
		lvLista = (ListView) findViewById(R.id.lvLista);
		gvGrilla = (GridView) findViewById(R.id.gvGrilla);
		int height = getWindowManager().getDefaultDisplay().getHeight();
		lvLista.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				height / 2));
		gvGrilla.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				height / 2));
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		adapterLista = new ListaAdapter(getApplicationContext());
		lvLista.setAdapter(adapterLista);

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
		
		gvGrilla.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
