package com.area51.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.area51.models.Imagenes;
import com.area51.semana3_3.R;
import com.area51.utils.Constant;
import com.nostra13.universalimageloader.core.ImageLoader;

public class GridAdapter extends ArrayAdapter<Imagenes> {
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	Context context;
	ArrayList<Imagenes> listaImagenes;

	public GridAdapter(Context context, int resource,
			ArrayList<Imagenes> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.listaImagenes = objects;
	}

	static class ViewHolder {
		ImageView imagen;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_grid, parent, false);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.imagen = (ImageView) convertView
					.findViewById(R.id.ivGrid);
			convertView.setTag(viewHolder);
		}
		ViewHolder holder = (ViewHolder) convertView.getTag();
		imageLoader.displayImage(Constant.listaImagenes.get(position)
				.getRutaImagen(), holder.imagen);
		return convertView;
	}
}
