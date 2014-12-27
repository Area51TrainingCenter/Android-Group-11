package com.example.semana4_2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.adapters.GrillaAdapter;
import com.example.models.Imagenes;
import com.example.views.ExpandableHeightGridView;

public class MainActivity extends Activity {
	ExpandableHeightGridView grilla;
	GrillaAdapter adapter;
	ArrayList<Imagenes> listaImagenes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		grilla = (ExpandableHeightGridView) findViewById(R.id.grilla);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (listaImagenes == null) {
			listaImagenes = new ArrayList<Imagenes>();
			for (int i = 100; i < 150; i++) {
				listaImagenes.add(new Imagenes("texto " + i,
						"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_"
								+ i + ".jpg"));
			}
		}
		adapter = new GrillaAdapter(getApplicationContext(),
				R.layout.list_item, listaImagenes);
		grilla.setAdapter(adapter);
		grilla.setExpanded(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
