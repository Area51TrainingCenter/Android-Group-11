package pe.area51.claseaudio;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    private MediaRecorder mediaRecorder;
    private TextView statusTextView;
    private Button recordButton;

    private boolean isRecording;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusTextView = (TextView) findViewById(R.id.activity_main_textview_status);
        recordButton = (Button) findViewById(R.id.activity_main_button_record);

        statusTextView.setText(getString(R.string.status, getString(R.string.stopped)));
        recordButton.setText(R.string.start_recording);
        isRecording = false;

        recordButton.setOnClickListener(new RecordButtonOnClickListener());
    }

    private void startRecording() throws IOException {
        initMediaRecorder();
        mediaRecorder.prepare();
        mediaRecorder.start();
    }

    private void stopRecording() {
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
    }

    private void initMediaRecorder(){
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        String outputPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/myRecording" + System.currentTimeMillis() + ".3gp";
        Log.d("Output path", outputPath);
        mediaRecorder.setOutputFile(outputPath);
    }

    private class RecordButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (isRecording) {
                stopRecording();
                statusTextView.setText(getString(R.string.status, getString(R.string.stopped)));
                recordButton.setText(R.string.start_recording);
                isRecording = false;
            } else {
                try {
                    startRecording();
                    statusTextView.setText(getString(R.string.status, getString(R.string.recording)));
                    recordButton.setText(R.string.stop_recording);
                    isRecording = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
