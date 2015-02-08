package pe.area51.ejemploparcel;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	public static final String PARCEL_TAG = "parcelTest";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		List<String> stringList = new ArrayList<String>();
		stringList.add("Hola");
		stringList.add("Mundo");

		final ParcelTest parcelTest = new ParcelTest();
		parcelTest.setBooleanTest(true)
				.setIntArrayTest(new int[] { 1, 2, 3, 4, 5 }).setIntTest(100)
				.setLocationTest(new Location(LocationManager.GPS_PROVIDER))
				.setStringListTest(stringList).setStringTest("Test");

		findViewById(R.id.activity_main_button_sendobject).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						startActivity(new Intent(MainActivity.this,
								PreviewActivity.class).putExtra(PARCEL_TAG,
								parcelTest));
					}
				});
	}
}
