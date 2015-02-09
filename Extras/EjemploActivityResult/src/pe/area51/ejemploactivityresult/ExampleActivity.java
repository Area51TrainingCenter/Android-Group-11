package pe.area51.ejemploactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ExampleActivity extends Activity {

	TextView resultTextView;
	Button sendResultButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_example);

		resultTextView = (TextView) findViewById(R.id.layout_example_textview_resulttext);
		sendResultButton = (Button) findViewById(R.id.layout_example_button_sendresult);

		sendResultButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setResult(RESULT_OK, new Intent().putExtra(
						MainActivity.INTENT_RESULT_TEXT_KEY, resultTextView
								.getText().toString()));
				finish();
			}
		});
	}

}
