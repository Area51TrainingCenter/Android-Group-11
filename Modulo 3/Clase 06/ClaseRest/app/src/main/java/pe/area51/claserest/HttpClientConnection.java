package pe.area51.claserest;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class HttpClientConnection {

    public String sendHttpGet(String url) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "application/json");
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        return httpClient.execute(httpGet, responseHandler);
    }

}
