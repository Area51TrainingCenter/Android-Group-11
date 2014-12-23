package com.area51.semana4_1;

import com.area51.adapters.FragmentAdapter;
import com.area51.utils.Constant;
import com.area51.views.ViewPagerCustom;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MostrarActivity extends FragmentActivity {
	FragmentAdapter adapter;
	ViewPagerCustom viewpager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mostrar);
		viewpager = (ViewPagerCustom) findViewById(R.id.viewpager);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Bundle bundle = getIntent().getExtras();
		int posicion = bundle.getInt(Constant.POSICION);
		adapter=new FragmentAdapter(getSupportFragmentManager());
		viewpager.setAdapter(adapter);
		viewpager.setCurrentItem(posicion);
	}
}
