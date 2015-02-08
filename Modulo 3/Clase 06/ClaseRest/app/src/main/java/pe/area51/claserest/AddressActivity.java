package pe.area51.claserest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AddressActivity extends Activity {

    TextView textViewDisplayName;
    TextView textViewCity;
    TextView textViewCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        textViewDisplayName = (TextView) findViewById(R.id.activity_address_textview_displayname);
        textViewCity = (TextView) findViewById(R.id.activity_address_textview_city);
        textViewCountry = (TextView) findViewById(R.id.activity_address_textview_country);

        textViewDisplayName.setText(getString(R.string.address, getIntent().getExtras().getString("displayName")));
        textViewCity.setText(getString(R.string.city, getIntent().getExtras().getString("city")));
        textViewCountry.setText(getString(R.string.country, getIntent().getExtras().getString("country")));
    }
}
