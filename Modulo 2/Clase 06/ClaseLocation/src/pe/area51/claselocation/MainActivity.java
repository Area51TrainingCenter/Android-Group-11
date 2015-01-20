package pe.area51.claselocation;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView latitudeTextView;
	TextView longitudeTextView;
	LocationListener myLocationListener;
	LocationManager locationManager;

	boolean isRequestingLocationUpdates;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		latitudeTextView = (TextView) findViewById(R.id.activity_main_latitude_textview);
		longitudeTextView = (TextView) findViewById(R.id.activity_main_longitude_textview);

		isRequestingLocationUpdates = false;

		locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		myLocationListener = new LocationListener() {

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
			}

			@Override
			public void onProviderEnabled(String provider) {
			}

			@Override
			public void onProviderDisabled(String provider) {
			}

			@Override
			public void onLocationChanged(Location location) {
				latitudeTextView.setText("" + location.getLatitude());
				longitudeTextView.setText("" + location.getLongitude());
			}
		};

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.main_get_location) {
			if (!isRequestingLocationUpdates) {
				locationManager.requestLocationUpdates(
						LocationManager.GPS_PROVIDER, 0, 0, myLocationListener);
				locationManager.requestLocationUpdates(
						LocationManager.NETWORK_PROVIDER, 0, 0,
						myLocationListener);
				isRequestingLocationUpdates = true;
				Toast.makeText(this, R.string.location_enabled,
						Toast.LENGTH_SHORT).show();
			} else {
				locationManager.removeUpdates(myLocationListener);
				isRequestingLocationUpdates = false;
				Toast.makeText(this, R.string.location_disabled,
						Toast.LENGTH_SHORT).show();
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
