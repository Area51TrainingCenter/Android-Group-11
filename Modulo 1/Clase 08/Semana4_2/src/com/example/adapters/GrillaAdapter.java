package com.example.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.models.Imagenes;
import com.example.semana4_2.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class GrillaAdapter extends ArrayAdapter<Imagenes> {
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	Context context;
	ArrayList<Imagenes> listaImagenes;

	public GrillaAdapter(Context context, int resource,
			ArrayList<Imagenes> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.listaImagenes = objects;
	}

	static class ViewHolder {
		ImageView ivImagen;
		TextView lblTexto;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.list_item, parent, false);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.ivImagen = (ImageView) convertView
					.findViewById(R.id.ivImagenGrilla);
			viewHolder.lblTexto = (TextView) convertView
					.findViewById(R.id.lblTexto);
			convertView.setTag(viewHolder);
		}
		ViewHolder holder = (ViewHolder) convertView.getTag();
		imageLoader.displayImage(listaImagenes.get(position).getRutaImagen(),
				holder.ivImagen);
		holder.lblTexto.setText(listaImagenes.get(position).getTexto());
		return convertView;
	}

}
