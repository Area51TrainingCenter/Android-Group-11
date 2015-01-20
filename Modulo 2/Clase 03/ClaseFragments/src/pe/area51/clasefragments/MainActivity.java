package pe.area51.clasefragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity implements ListadoInterface {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		((FragmentListado) getFragmentManager().findFragmentById(
				R.id.activity_main_fragmentListado)).setListadoInterface(this);
	}

	/* Prueba de funcionamiento de menú */
	// En este método se crea el menú.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// En este método se captura el botón de menú presionado.
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.menu_hello) {
			Toast.makeText(this, getString(R.string.hello_world),
					Toast.LENGTH_SHORT).show();
			return true;
		}
		if (id == R.id.menu_bye) {
			Toast.makeText(this, getString(R.string.bye_world),
					Toast.LENGTH_SHORT).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/* Fin */

	@Override
	public void onItemSelected(Nota mensaje) {
		FragmentContenido fragmentDetalle = ((FragmentContenido) getFragmentManager()
				.findFragmentById(R.id.activity_main_fragmentDetalle));
		if (fragmentDetalle != null) {
			fragmentDetalle.setContenido(mensaje.getContenido());
		} else {
			startActivity(new Intent(this, ContenidoActivity.class).putExtra(
					"pe.area51.clasefragments.contenido",
					mensaje.getContenido()));
		}
	}
}
