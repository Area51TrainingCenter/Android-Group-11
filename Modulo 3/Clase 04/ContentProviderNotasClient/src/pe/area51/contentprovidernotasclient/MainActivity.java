package pe.area51.contentprovidernotasclient;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final Uri URI = Uri
			.parse("content://pe.area51.contentprovidernotas/notas");

	TextView textViewQuery;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textViewQuery = (TextView) findViewById(R.id.activity_main_textview_query);
		textViewQuery.setMovementMethod(new ScrollingMovementMethod());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.main_insert) {
			ContentValues contentValues = new ContentValues();
			contentValues.put("titulo", "Título de ejemplo");
			contentValues.put("contenido", "Contenido de ejemplo");
			getContentResolver().insert(URI, contentValues);
			return true;
		}
		if (id == R.id.main_query) {
			textViewQuery.setText("");
			String[] projection = new String[] { "_id", "titulo", "contenido" };
			Cursor cursor = getContentResolver().query(URI, projection, null,
					null, null);
			while (cursor.moveToNext()) {
				String _id = cursor.getString(cursor.getColumnIndex("_id"));
				String titulo = cursor.getString(cursor
						.getColumnIndex("titulo"));
				String contenido = cursor.getString(cursor
						.getColumnIndex("contenido"));
				textViewQuery.append(_id + " - " + titulo + " - " + contenido
						+ "\n");
			}
			return true;
		}
		if (id == R.id.main_delete_all) {
			getContentResolver().delete(URI, null, null);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
