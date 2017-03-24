package com.hackaton.kandy.kandyio;

import com.google.gson.Gson;
import com.hackaton.kandy.kandyio.Entities.Contact;
import com.hackaton.kandy.kandyio.Entities.Messages;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by RanjanD on 3/3/2017.
 */

public class KandyUserDevice {

    private final String baseAPIUrl = "https://api.kandy.io/v1.2/devices/messages?key=%s&device_id=%s";
    private String domainUserAccessToken = "";
    private String deviceId = "";

    public KandyUserDevice(String domainUserAccessToken, String deviceId){
        this.domainUserAccessToken = domainUserAccessToken;
        this.deviceId = deviceId;
    }

    public List<Messages> GetDeviceMessages() throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(String.format(baseAPIUrl, domainUserAccessToken, deviceId))
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

        List<Messages> messages = new ArrayList<Messages>();

        JSONArray messagesJsonArray = null;
        if(resultJson != null){
            messagesJsonArray = resultJson.getJSONArray("messages");
            Gson gson = new Gson();
            messages = Arrays.asList(gson.fromJson(messagesJsonArray.toString(), Messages[].class));
        }

        return messages;
    }
}
