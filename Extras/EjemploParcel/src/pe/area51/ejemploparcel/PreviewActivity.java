package pe.area51.ejemploparcel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preview);

		((TextView) findViewById(R.id.activity_preview_textview_objectvalues))
				.setText(getIntent().getExtras()
						.getParcelable(MainActivity.PARCEL_TAG).toString());
	}

}
