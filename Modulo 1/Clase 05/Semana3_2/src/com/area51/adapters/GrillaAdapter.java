package com.area51.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.area51.models.Item;
import com.area51.semana3_2.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class GrillaAdapter extends ArrayAdapter<Item> {
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	Context context;
	ArrayList<Item> listaItem;

	public GrillaAdapter(Context context, int resource, ArrayList<Item> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.listaItem = objects;
	}

	static class ViewHolder {
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
					.findViewById(R.id.ivImage);
			convertView.setTag(viewHolder);
		}
		ViewHolder holder = (ViewHolder) convertView.getTag();
		imageLoader.displayImage(listaItem.get(position).getRutaImagen(),
				holder.ivImage);
		return convertView;
	}

}
