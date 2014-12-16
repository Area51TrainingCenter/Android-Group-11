package com.area51.adapters;

import com.area51.semana3_1.R;
import com.area51.utils.Constant;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListaAdapter extends BaseAdapter {
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	Context context;

	public ListaAdapter(Context context) {
		super();
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Constant.listaPelicula.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return Constant.listaPelicula.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	static class ViewHolder {
		TextView lblTitulo;
		TextView lblDescripcion;
		ImageView ivImage;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.list_item, parent, false);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.ivImage = (ImageView) convertView
					.findViewById(R.id.ivImagen);
			viewHolder.lblTitulo = (TextView) convertView
					.findViewById(R.id.lblTitulo);
			viewHolder.lblDescripcion = (TextView) convertView
					.findViewById(R.id.lblDescripcion);
			convertView.setTag(viewHolder);
		}
		ViewHolder holder = (ViewHolder) convertView.getTag();
		holder.lblTitulo.setText(Constant.listaPelicula.get(position)
				.getTitulo());
		holder.lblDescripcion.setText(Constant.listaPelicula.get(position)
				.getDescripcion());
		// int idImagen = context.getResources().getIdentifier(
		// Constant.listaPelicula.get(position).getRutaImagen(), null,
		// context.getPackageName());
		// holder.ivImage.setImageDrawable(context.getResources().getDrawable(
		// idImagen));
		imageLoader.displayImage(Constant.listaPelicula.get(position)
				.getRutaImagen(), holder.ivImage);
		return convertView;
	}

}
