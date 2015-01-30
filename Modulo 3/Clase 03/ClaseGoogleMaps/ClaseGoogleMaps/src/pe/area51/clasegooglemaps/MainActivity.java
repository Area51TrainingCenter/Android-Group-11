package pe.area51.clasegooglemaps;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends Activity {

	MyMapFragment myMapFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myMapFragment = (MyMapFragment) getFragmentManager().findFragmentById(
				R.id.activity_main_map);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.main_map_hybrid) {
			myMapFragment.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			return true;
		}
		if (id == R.id.main_map_normal) {
			myMapFragment.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			return true;
		}
		if (id == R.id.main_map_satellite) {
			myMapFragment.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			return true;
		}
		if (id == R.id.main_map_terrain) {
			myMapFragment.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
