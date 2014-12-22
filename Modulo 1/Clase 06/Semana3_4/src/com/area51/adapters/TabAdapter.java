package com.area51.adapters;

import com.area51.fragments.TabDosFragment;
import com.area51.fragments.TabUnoFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

	public TabAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int id) {
		// TODO Auto-generated method stub
		Object fragment = null;
		switch (id) {
		case 0:
			fragment = new TabUnoFragment();
			break;
		case 1:
			fragment = new TabDosFragment();
			break;
		}
		return (Fragment) fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

}
