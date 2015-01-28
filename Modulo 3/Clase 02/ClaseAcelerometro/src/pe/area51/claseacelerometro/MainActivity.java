package pe.area51.claseacelerometro;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

	SensorManager sensorManager;

	TextView textViewX;
	TextView textViewY;
	TextView textViewZ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textViewX = (TextView) findViewById(R.id.activity_main_textview_x);
		textViewY = (TextView) findViewById(R.id.activity_main_textview_y);
		textViewZ = (TextView) findViewById(R.id.activity_main_textview_z);
	}

	@Override
	protected void onResume() {
		super.onResume();
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		Sensor accelerometer = sensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		// El tercer parámetro del método "registerListener" sirve
		// para indicar la frecuencia de muestreo del sensor,
		// la cual depende del fabricante, por lo que se usan valores
		// relativos.
		sensorManager.registerListener(this, accelerometer,
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(this);
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];

			textViewX.setText(getString(R.string.eje_x, x));
			textViewY.setText(getString(R.string.eje_y, y));
			textViewZ.setText(getString(R.string.eje_z, z));
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}
}
