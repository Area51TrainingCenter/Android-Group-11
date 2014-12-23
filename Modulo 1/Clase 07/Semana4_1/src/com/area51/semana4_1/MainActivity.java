package com.area51.semana4_1;

import java.util.ArrayList;

import com.area51.adapters.GrillaAdapter;
import com.area51.models.Item;
import com.area51.utils.Constant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity {
	GrillaAdapter adapter;
	GridView grilla;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		grilla = (GridView) findViewById(R.id.grilla);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (Constant.listaItems == null) {
			Constant.listaItems = new ArrayList<Item>();
			for (int i = 100; i < 250; i++) {
				Constant.listaItems.add(new Item(
						"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_"
								+ i + ".jpg", "Texto " + i));
			}
		}
		adapter = new GrillaAdapter(getApplicationContext(),
				R.layout.list_gridview, Constant.listaItems);
		grilla.setAdapter(adapter);

		grilla.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						MostrarActivity.class);
				Bundle bundle = new Bundle();
				bundle.putInt(Constant.POSICION, position);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}
}
