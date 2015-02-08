package pe.area51.claserest;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    EditText editTextLatitude;
    EditText editTextLongitude;
    Button buttonSendRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLatitude = (EditText) findViewById(R.id.activity_main_edittext_latitude);
        editTextLongitude = (EditText) findViewById(R.id.activity_main_edittext_longitude);
        buttonSendRequest = (Button) findViewById(R.id.activity_main_button_sendrequest);

        buttonSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String latitude = editTextLatitude.getText().toString();
                String longitude = editTextLongitude.getText().toString();
                String url = getString(R.string.server_url) + "?format=json&lat=" + latitude + "&lon=" + longitude;
                new RequestAddressAsyncTask().execute(url);
            }
        });
    }

    private class RequestAddressAsyncTask extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(MainActivity.this, getString(R.string.progress_title), getString(R.string.progress_message));
        }

        @Override
        protected String doInBackground(String... params) {
            String url = params[0];
            try {
                return new HttpClientConnection().sendHttpGet(url);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String serverResponse) {
            progressDialog.dismiss();
            if (serverResponse != null) {
                try {
                    Address address = new JsonParser().parseAddress(serverResponse);
                    startActivity(new Intent(MainActivity.this, AddressActivity.class).putExtra("displayName", address.getDisplayName()).putExtra("city", address.getCity()).putExtra("country", address.getCountry()));
                } catch (JSONException e) {
                    new AlertDialog.Builder(MainActivity.this).setTitle(getString(R.string.response_error_dialog_title)).setMessage(R.string.response_error_dialog_message).create().show();
                }
            } else {
                new AlertDialog.Builder(MainActivity.this).setTitle(getString(R.string.server_error_dialog_title)).setMessage(R.string.server_error_dialog_message).create().show();
            }
        }
    }
}
