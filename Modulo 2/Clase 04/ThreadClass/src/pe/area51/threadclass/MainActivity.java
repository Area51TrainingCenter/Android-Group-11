package pe.area51.threadclass;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btnExecuteMainThread;
	Button btnExecuteSecondaryThread;
	Button btnExecuteAsyncTask;
	Button btnExecuteIntentService;

	ProgressDialog progressDialog;

	MyBroadcastReceiver myBroadcastReceiver;

	private void showProgressDialog() {
		if (progressDialog == null
				|| (progressDialog != null && !progressDialog.isShowing())) {
			progressDialog = ProgressDialog.show(MainActivity.this, "Loading",
					"Loading...");
		}
	}

	private void dismissProgressDialog() {
		if (progressDialog != null && progressDialog.isShowing()) {
			progressDialog.dismiss();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnExecuteMainThread = (Button) findViewById(R.id.activity_main_btn_execute);
		btnExecuteSecondaryThread = (Button) findViewById(R.id.activity_main_btn_execute_secondary_thread);
		btnExecuteAsyncTask = (Button) findViewById(R.id.activity_main_btn_execute_async_task);
		btnExecuteIntentService = (Button) findViewById(R.id.activity_main_btn_execute_intent_service);

		btnExecuteMainThread.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showProgressDialog();
				longRoutine();
				dismissProgressDialog();
			}
		});

		btnExecuteSecondaryThread.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showProgressDialog();
				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						longRoutine();
						dismissProgressDialog();
					}
				});
				thread.start();
			}
		});

		btnExecuteAsyncTask.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new AsyncTask<Void, Void, Boolean>() {

					@Override
					protected void onPreExecute() {
						showProgressDialog();
					}

					@Override
					protected Boolean doInBackground(Void... params) {
						longRoutine();
						return true;
					}

					@Override
					protected void onPostExecute(Boolean result) {
						dismissProgressDialog();
					}

				}.execute();
			}
		});

		btnExecuteIntentService.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showProgressDialog();
				startService(new Intent(MainActivity.this,
						LongRoutineIntentService.class));
			}
		});

	}

	@Override
	protected void onResume() {
		super.onResume();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(LongRoutineIntentService.BROADCAST_INTENT);
		myBroadcastReceiver = new MyBroadcastReceiver();
		registerReceiver(myBroadcastReceiver, intentFilter);
	}

	@Override
	protected void onPause() {
		super.onPause();
		unregisterReceiver(myBroadcastReceiver);
	}

	private void longRoutine() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private class MyBroadcastReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals(
					LongRoutineIntentService.BROADCAST_INTENT)) {
				dismissProgressDialog();
			}
		}

	}

}
