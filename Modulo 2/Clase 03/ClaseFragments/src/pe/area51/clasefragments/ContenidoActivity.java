package pe.area51.clasefragments;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ContenidoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_contenido);
		TextView contenidoTextView = (TextView) findViewById(R.id.fragment_contenido_textView);
		String contenido = getIntent().getExtras().getString(
				"pe.area51.clasefragments.contenido");
		if (contenido != null) {
			contenidoTextView.setText(contenido);
		}
	}

}
