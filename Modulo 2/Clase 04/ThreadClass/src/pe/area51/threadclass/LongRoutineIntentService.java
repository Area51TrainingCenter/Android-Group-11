package pe.area51.threadclass;

import android.app.IntentService;
import android.content.Intent;

public class LongRoutineIntentService extends IntentService {

	public static final String BROADCAST_INTENT = "pe.area51.threadclass.LongRoutineIntentService";

	public LongRoutineIntentService() {
		super("pe.area51.threadclass.LongRoutineIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		longRoutine();
		sendBroadcast(new Intent(BROADCAST_INTENT));
	}

	private void longRoutine() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
