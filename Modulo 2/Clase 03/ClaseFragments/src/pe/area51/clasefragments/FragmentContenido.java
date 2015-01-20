package pe.area51.clasefragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentContenido extends Fragment {

	TextView contenidoTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_contenido, container);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		contenidoTextView = (TextView) getView().findViewById(
				R.id.fragment_contenido_textView);
	}

	public void setContenido(String contenido) {
		if (contenidoTextView != null) {
			contenidoTextView.setText(contenido);
		}
	}

}
