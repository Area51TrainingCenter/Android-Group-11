package pe.area51.ejemploactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final String TAG = "MainActivity";

	public static final int EXAMPLE_ACTIVITY_1_REQUEST = 1;
	public static final int EXAMPLE_ACTIVITY_2_REQUEST = 2;

	public static final String INTENT_RESULT_TEXT_KEY = "resultText";

	TextView resultTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		resultTextView = (TextView) findViewById(R.id.activity_main_textview_result);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Se debe iniciar la actividad con el método "startActivityForResult()"
	// para poder obtener una respuesta de esta. La respuesta se envía al
	// momento de finalizarse la actividad.
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.main_item_example_activity_1) {
			startActivityForResult(new Intent(this, ExampleActivity1.class),
					EXAMPLE_ACTIVITY_1_REQUEST);
			return true;
		}
		if (id == R.id.main_item_example_activity_2) {
			startActivityForResult(new Intent(this, ExampleActivity2.class),
					EXAMPLE_ACTIVITY_2_REQUEST);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// Este método capturará la respuesta (o resultado) de cada actividad.
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d(TAG, "RequestCode: " + requestCode + ", ResultCode: "
				+ resultCode);
		resultTextView
				.setText(getString(
						R.string.result,
						requestCode == EXAMPLE_ACTIVITY_1_REQUEST ? "EXAMPLE_ACTIVITY_1_REQUEST"
								: "EXAMPLE_ACTIVITY_2_REQUEST",
						resultCode == RESULT_OK ? "RESULT_OK"
								: "RESULT_CANCELED",
						data != null ? data
								.getStringExtra(INTENT_RESULT_TEXT_KEY)
								: "NULL"));
	}
}
