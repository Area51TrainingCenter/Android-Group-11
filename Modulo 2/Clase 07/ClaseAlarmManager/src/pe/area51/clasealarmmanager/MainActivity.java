package pe.area51.clasealarmmanager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	public static final String BROADCAST_ACTION = "pe.area51.clasealarmmanager.SHOW_MESSAGE";

	EditText messageEditText;
	EditText timeEditText;
	Button launchButton;

	AlarmManager alarmManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		messageEditText = (EditText) findViewById(R.id.activity_main_edittext_menssage);
		timeEditText = (EditText) findViewById(R.id.activity_main_edittext_time);
		launchButton = (Button) findViewById(R.id.activity_main_button_launch);

		alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

		launchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int timeInSeconds = Integer.parseInt(timeEditText.getText()
						.toString());
				setAlarm(messageEditText.getText().toString(), timeInSeconds);
			}

		});
	}

	@TargetApi(Build.VERSION_CODES.KITKAT)
	private void setAlarm(final String message, final int timeInSeconds) {
		// El parámetro "requestCode" no tiene ninguna utilidad (al menos
		// hastala versión 4 de Android).
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
				new Intent(BROADCAST_ACTION).putExtra("message", message),
				PendingIntent.FLAG_UPDATE_CURRENT);
		// RTC, llamar a System.currentTimeMillis().
		// ELAPSED_REALTIME, llamar a SystemClock.elapsedRealtime().
		// A partir de la versión 19, el comportamiento de este método cambió:
		// http://developer.android.com/reference/android/app/AlarmManager.html
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
			alarmManager.set(AlarmManager.RTC, System.currentTimeMillis()
					+ timeInSeconds * 1000, pendingIntent);
		} else {
			alarmManager.setExact(AlarmManager.RTC, System.currentTimeMillis()
					+ timeInSeconds * 1000, pendingIntent);
		}
	}
}
