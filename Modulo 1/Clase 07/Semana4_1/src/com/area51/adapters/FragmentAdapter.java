package com.area51.adapters;

import com.area51.fragments.DetalleFragment;
import com.area51.utils.Constant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {

	public FragmentAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int posicion) {
		// TODO Auto-generated method stub
		DetalleFragment fragmento=new DetalleFragment();
		Bundle bundle=new Bundle();
		bundle.putInt(Constant.POSICION, posicion);
		fragmento.setArguments(bundle);
		return fragmento;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Constant.listaItems.size();
	}

}
