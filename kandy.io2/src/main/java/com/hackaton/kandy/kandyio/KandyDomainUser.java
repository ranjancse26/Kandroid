package com.hackaton.kandy.kandyio;

import com.google.gson.Gson;
import com.hackaton.kandy.kandyio.Entities.DomainUserDetails;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by RanjanD on 3/3/2017.
 */

public class KandyDomainUser extends BaseAccessToken {

    private final String apiHost = "https://api.kandy.io";
    private final String version = "v1.2";
    private final String apiURL = apiHost + '/' + version;

    private String apiKey = "";
    private String apiSecretKey = "";

    public KandyDomainUser(String apiKey, String apiSecretKey){
        this.apiKey = apiKey;
        this.apiSecretKey = apiSecretKey;
    }

    public String GetDomainUserAccountAccessToken(String userId) throws IOException, JSONException {
        String url = apiURL+ "/domains/users/accesstokens?key=%s&domain_api_secret=%s&user_id=%s";
        Request request = new Request.Builder()
                .url(String.format(url, apiKey, apiSecretKey, userId))
                .get()
                .build();

        return ProcessRequestAccessToken("user", request);
    }

    public DomainUserDetails GetDomainUserDetails(String domainUserAccessToken) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        String url = apiURL+ "/domains/users/details?key=%s&user_access_token=%s";
        Request request = new Request.Builder()
                .url(String.format(url, apiKey, domainUserAccessToken))
                .get()
                .addHeader("cache-control", "no-cache")
                .build();

        Response responses = null;

        try {
            responses = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DomainUserDetails domainUserDetails = new DomainUserDetails();
        String jsonData = responses.body().string();
        JSONObject Jobject = new JSONObject(jsonData);
        JSONObject resultJson = Jobject.getJSONObject("result");

        if(resultJson != null){
            JSONObject userJSON = resultJson.getJSONObject("user");
            Gson gson = new Gson();
            domainUserDetails = gson.fromJson(userJSON.toString(), DomainUserDetails.class);
        }

        return domainUserDetails;
    }
}
