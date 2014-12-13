package com.area51.adapters;

import java.util.ArrayList;

import com.area51.models.Persona;
import com.example.semana2_2.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListaAdapter extends BaseAdapter {

	Context context;
	ArrayList<Persona> listaPersona;

	public ListaAdapter(Context context, ArrayList<Persona> listaPersona) {
		super();
		this.context = context;
		this.listaPersona = listaPersona;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listaPersona.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listaPersona.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return listaPersona.get(position).getId();
	}

	static class ViewHolder {
		ImageView imagen;
		TextView nombre;
		TextView fecha;
		TextView textoUno;
		TextView textoDos;
		ImageView ivCross;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_list, parent, false);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.imagen = (ImageView) convertView
					.findViewById(R.id.ivImagen);
			viewHolder.nombre = (TextView) convertView
					.findViewById(R.id.lblNombre);
			viewHolder.fecha = (TextView) convertView
					.findViewById(R.id.lblTiempo);
			viewHolder.textoUno = (TextView) convertView
					.findViewById(R.id.lblTextoUno);
			viewHolder.textoDos = (TextView) convertView
					.findViewById(R.id.lblTextoDos);
			viewHolder.ivCross = (ImageView) convertView
					.findViewById(R.id.ivCross);
			convertView.setTag(viewHolder);
		}
		ViewHolder holder = (ViewHolder) convertView.getTag();
		holder.imagen.setImageResource(listaPersona.get(position)
				.getRutaImagen());
		holder.nombre.setText(listaPersona.get(position).getNombre());
		holder.fecha.setText(listaPersona.get(position).getHora());
		holder.textoUno.setText(listaPersona.get(position).getTextoUno());
		holder.textoDos.setText(listaPersona.get(position).getTextoDos());
		holder.ivCross
				.setVisibility(listaPersona.get(position).isCross() ? View.VISIBLE
						: View.GONE);
		return convertView;
	}

}
