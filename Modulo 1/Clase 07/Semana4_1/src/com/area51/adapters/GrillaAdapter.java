package com.area51.adapters;

import java.util.ArrayList;
import java.util.List;

import com.area51.models.Item;
import com.area51.semana4_1.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class GrillaAdapter extends ArrayAdapter<Item> {
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	Context context;
	ArrayList<Item> listaItems;

	public GrillaAdapter(Context context, int resource, ArrayList<Item> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.listaItems = objects;
	}

	static class ViewHolder {
		ImageView image;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.list_gridview, parent, false);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.image = (ImageView) convertView
					.findViewById(R.id.imagenGrid);
			convertView.setTag(viewHolder);
		}
		ViewHolder holder = (ViewHolder) convertView.getTag();
		imageLoader.displayImage(listaItems.get(position).getRutaImagen(),
				holder.image);
		return convertView;
	}

}
