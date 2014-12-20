package com.area51.adapters;

import com.area51.semana3_3.R;
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
		return Constant.listaPersona.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return Constant.listaPersona.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	static class ViewHolder {
		ImageView imagen;
		TextView nombre;
		TextView apellido;
		TextView sexo;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_list, parent, false);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.nombre = (TextView) convertView
					.findViewById(R.id.lblNombre);
			viewHolder.apellido = (TextView) convertView
					.findViewById(R.id.lblApellido);
			viewHolder.sexo = (TextView) convertView.findViewById(R.id.lblSexo);
			viewHolder.imagen = (ImageView) convertView
					.findViewById(R.id.ivImagenLogo);
			convertView.setTag(viewHolder);
		}
		ViewHolder holder = (ViewHolder) convertView.getTag();
		holder.nombre.setText(Constant.listaPersona.get(position).getNombre());
		holder.apellido.setText(Constant.listaPersona.get(position)
				.getApellido());
		holder.sexo.setText(Constant.listaPersona.get(position).getSexo());
		imageLoader.displayImage(Constant.listaPersona.get(position)
				.getRutaImagen(), holder.imagen);
		return convertView;
	}

}
