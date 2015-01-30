package pe.area51.clasegooglemaps;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MyMapFragment extends MapFragment implements OnMapReadyCallback,
		OnMyLocationButtonClickListener, OnMyLocationChangeListener {

	GoogleMap googleMap;

	public void setMapType(int mapType) {
		if (googleMap != null) {
			googleMap.setMapType(mapType);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		getMapAsync(this);
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onMapReady(GoogleMap googleMap) {
		this.googleMap = googleMap;
		googleMap.setMyLocationEnabled(true);
		googleMap.setOnMyLocationButtonClickListener(this);
		googleMap.setOnMyLocationChangeListener(this);
	}

	@Override
	public boolean onMyLocationButtonClick() {
		Toast.makeText(getActivity(), R.string.getting_location,
				Toast.LENGTH_SHORT).show();
		return false;
	}

	@Override
	public void onMyLocationChange(Location location) {
		Toast.makeText(
				getActivity(),
				getString(R.string.my_location_is, location.getLatitude(),
						location.getLongitude()), Toast.LENGTH_SHORT).show();
		updateCamera(location);
	}

	private void updateCamera(Location location) {
		// A diferencia de animateCamera(), moveCamera() nos envía al lugar sin
		// mostrar la animación de desplazamiento suave de la cámara.
		LatLng latLng = new LatLng(location.getLatitude(),
				location.getLongitude());
		CameraPosition cameraPosition = CameraPosition.builder().target(latLng)
				.zoom(20).bearing(70).tilt(40).build();
		CameraUpdate cameraUpdate = CameraUpdateFactory
				.newCameraPosition(cameraPosition);
		googleMap.animateCamera(cameraUpdate);
	}

}
