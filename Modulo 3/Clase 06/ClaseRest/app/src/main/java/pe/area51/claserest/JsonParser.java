package pe.area51.claserest;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

    public Address parseAddress(final String json) throws JSONException {
        JSONObject responseJsonObject = new JSONObject(json);
        String displayName = responseJsonObject.getString("display_name");
        JSONObject addressJsonObject = responseJsonObject.getJSONObject("address");
        String city = addressJsonObject.getString("city");
        String country = addressJsonObject.getString("country");
        return new Address().setCity(city).setCountry(country).setDisplayName(displayName);
    }

}
