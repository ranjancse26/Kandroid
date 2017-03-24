package com.hackaton.kandy.kandyio;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by RanjanD on 3/5/2017.
 */

public class BaseAccessToken {

    public String ProcessRequestAccessToken(String accessType, Request request) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();
        Response responses = null;

        try {
            responses = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonData = responses.body().string();
        JSONObject Jobject = new JSONObject(jsonData);
        JSONObject resultJson = (JSONObject) Jobject.get("result");

        if(resultJson != null)
            return resultJson.getString(accessType + "_access_token");

        return "";
    }
}
