package pe.area51.clasesharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textViewMessage;
	EditText editTextName;
	Button buttonRegisterName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editTextName = (EditText) findViewById(R.id.activity_main_edittext_name);
		textViewMessage = (TextView) findViewById(R.id.activity_main_textview_message);
		buttonRegisterName = (Button) findViewById(R.id.activity_main_button_register);

		final SharedPreferences sharedPreferences = getSharedPreferences(
				"com.example.clasesharedpreferences", Context.MODE_PRIVATE);
		String lastRegisteredName = sharedPreferences.getString("name", "");

		if (!lastRegisteredName.equals("")) {
			textViewMessage.setText(getString(R.string.welcome_back_message,
					lastRegisteredName));
		}

		buttonRegisterName.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sharedPreferences.edit()
						.putString("name", editTextName.getText().toString())
						.commit();
				textViewMessage.setText(getString(
						R.string.welcome_back_message, editTextName.getText()
								.toString()));
			}
		});

	}
}
