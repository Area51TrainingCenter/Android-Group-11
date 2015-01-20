package pe.area51.clasefragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentListado extends Fragment {

	ListadoInterface listadoInterface;

	public void setListadoInterface(ListadoInterface listadoInterface) {
		this.listadoInterface = listadoInterface;
	}

	private Nota[] notas = new Nota[] { new Nota("Asunto 1", "Contenido 1"),
			new Nota("Asunto 2", "Contenido 2"),
			new Nota("Asunto 3", "Contenido 3"),
			new Nota("Asunto 4", "Contenido 4"),
			new Nota("Asunto 5", "Contenido 5") };

	private ListView listado;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_listado, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		listado = (ListView) getView().findViewById(
				R.id.fragment_listado_listView);
		listado.setAdapter(new ListadoAdapter(getActivity()));
		listado.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (listadoInterface != null) {
					listadoInterface.onItemSelected((Nota) parent
							.getItemAtPosition(position));
				}
			}
		});
	}

	class ListadoAdapter extends ArrayAdapter<Nota> {

		private Activity activity;

		public ListadoAdapter(Activity activity) {
			super(activity, R.layout.nota_listview_element, notas);
			this.activity = activity;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater layoutInflater = activity.getLayoutInflater();
			View listadoView = layoutInflater.inflate(
					R.layout.nota_listview_element, null);
			TextView textViewTitulo = (TextView) listadoView
					.findViewById(R.id.nota_listview_element_asunto);
			textViewTitulo.setText(getItem(position).getAsunto());
			return listadoView;
		}

	}

}
