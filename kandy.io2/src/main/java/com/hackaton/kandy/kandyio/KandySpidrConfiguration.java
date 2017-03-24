package com.hackaton.kandy.kandyio;

import com.google.gson.Gson;
import com.hackaton.kandy.kandyio.Entities.SpidrConfigurationResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by RanjanD on 3/20/2017.
 */

public class KandySpidrConfiguration {

    private final String apiHost = "https://api.kandy.io";
    private final String version = "v1.2";
    private final String apiURL = apiHost + '/' + version;
    private String domainUserAccessToken = "";

    public KandySpidrConfiguration(String domainUserAccessToken){
        this.domainUserAccessToken = domainUserAccessToken;
    }

    public SpidrConfigurationResponse GetSpidrConfiguration() throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        String url = apiURL + "/users/configurations/communications/spidr?key=%s";
        Request request = new Request.Builder()
                .url(String.format(url, domainUserAccessToken))
                .get()
                .addHeader("cache-control", "no-cache")
                .build();

        Response responses = null;

        try {
            responses = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonData = responses.body().string();
        JSONObject Jobject = new JSONObject(jsonData);
        JSONObject resultJson = Jobject.getJSONObject("result");

        SpidrConfigurationResponse spidrConfigurationResult = null;

        if(resultJson != null){
            Gson gson = new Gson();
            spidrConfigurationResult = gson.fromJson(resultJson.toString(), SpidrConfigurationResponse.class);
        }

        return spidrConfigurationResult;
    }
}
