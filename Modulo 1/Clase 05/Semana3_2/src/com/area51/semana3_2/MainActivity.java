package com.area51.semana3_2;

import java.util.ArrayList;

import com.area51.adapters.GrillaAdapter;
import com.area51.models.Item;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends Activity {
	GridView gvGrilla;
	GrillaAdapter adapter;
	ArrayList<Item> listaItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gvGrilla = (GridView) findViewById(R.id.gvGrilla);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (listaItems == null) {
			listaItems = new ArrayList<Item>();
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_005.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_006.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_007.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_008.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_009.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_010.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_012.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_013.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_014.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_015.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_016.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_018.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_019.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_020.jpg"));
//			listaItems
//					.add(new Item(
//							"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_021.jpg"));
			for (int i = 100; i < 368; i++) {
				listaItems
				.add(new Item(
						"http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_"+i+".jpg"));
			}
		}
		adapter = new GrillaAdapter(getApplicationContext(),
				R.layout.list_item, listaItems);
		gvGrilla.setAdapter(adapter);
	}
}
