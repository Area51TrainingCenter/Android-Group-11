package com.area51.fragments;

import com.area51.semana4_1.R;
import com.area51.utils.Constant;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleFragment extends Fragment {
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	ImageView ivImage;
	TextView lblTexto;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_detalle, container,
				false);
		ivImage = (ImageView) rootView.findViewById(R.id.image);
		lblTexto = (TextView) rootView.findViewById(R.id.lblTexto);
		Bundle bundle = getArguments();
		int posicion = bundle.getInt(Constant.POSICION);
		imageLoader.displayImage(Constant.listaItems.get(posicion)
				.getRutaImagen(), ivImage);
		lblTexto.setText(Constant.listaItems.get(posicion).getTexto());
		return rootView;
	}
}
