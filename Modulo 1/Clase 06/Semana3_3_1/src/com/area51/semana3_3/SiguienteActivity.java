package com.area51.semana3_3;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_siguiente);
		lvLista = (ListView) findViewById(R.id.lvLista);
		int height = getWindowManager().getDefaultDisplay().getHeight();
		lvLista.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				height / 2));
//		gvGrilla.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
//				height / 2));
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		adapterLista = new ListaAdapter(getApplicationContext());
		lvLista.setAdapter(adapterLista);

	}
}
