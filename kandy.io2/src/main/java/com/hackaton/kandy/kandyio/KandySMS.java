package com.hackaton.kandy.kandyio;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by RanjanD on 3/3/2017.
 */

public class KandySMS {

    private final String apiHost = "https://api.kandy.io";
    private final String version = "v1.2";
    private final String apiURL = apiHost + '/' + version;
    private String domainUserAccessToken = "";

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public KandySMS(String domainUserAccessToken){
        this.domainUserAccessToken = domainUserAccessToken;
    }

    /*
        Make a REST API call to https://api.kandy.io/v1.2/devices/smss?key=%s&device_id=%s
        1. Build a JSON Object
        {
          "message":
          {
              "destination": "+1123456789",
              "source": "+12245556666",
              "message":
              {
                  "text": "Hello, Kandy SMS!"
              }
          }
        }
    */
    public String SendSMS(String deviceId, String from, String to, String text) throws JSONException, IOException {
        String kandySMSApiUrl = apiURL + "/devices/smss?" + "key=%s&device_id=%s";
        JSONObject smsRootObject = BuildSMSJsonObject(from, to, text);

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, String.valueOf(smsRootObject));
        Request request = new Request.Builder()
                .url(String.format(kandySMSApiUrl, domainUserAccessToken, deviceId))
                .post(body)
                .build();

        Response response = null;

        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    /*
        Building a JSON Object for sending SMS
    */
    private JSONObject BuildSMSJsonObject(String from, String to, String text) throws JSONException {
        JSONObject smsObject = new JSONObject();
        JSONObject messsageRootSMSObject = new JSONObject();

        JSONObject innerMessageObject = new JSONObject();
        innerMessageObject.put("text", text);

        smsObject.put("destination", to);
        smsObject.put("source", from);
        smsObject.put("message", innerMessageObject);

        messsageRootSMSObject.put("message", smsObject);
        return messsageRootSMSObject;
    }
}
