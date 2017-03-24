package com.hackaton.kandy.kandyio;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.UUID;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by RanjanD on 3/3/2017.
 */

public class KandyInstantMessage {

    private final String apiHost = "https://api.kandy.io";
    private final String version = "v1.2";
    private final String apiURL = apiHost + '/' + version;
    private String domainUserAccessToken = "";

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public KandyInstantMessage(String domainUserAccessToken){
        this.domainUserAccessToken = domainUserAccessToken;
    }

    /*
        Make a REST API call to https://api.kandy.io/v1.2/devices/messages?key=%s&device_id=%s
        1. Build an Instant Message Object
        {
          "message": {
            "content_type": "text",
            "destination": "972542205056@domain.com",
            "UUID": "abc2fa752c3c4edf97de8b0a12f622f0",
            "message": {
              "mimeType": "text/plain",
              "text": "let's meet tonight"
            }
          }
        }
    */
    public String SendInstantMessage(String deviceId, String destination, String text) throws JSONException, IOException {
        String kandyInstantMessageApiUrl = apiURL + "/devices/messages?" + "key=%s&device_id=%s";
        JSONObject instantMessageRootObject = BuildIMJsonObject(destination, text);

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, String.valueOf(instantMessageRootObject));
        Request request = new Request.Builder()
                .url(String.format(kandyInstantMessageApiUrl, domainUserAccessToken, deviceId))
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
        Building a JSON Object for sending instant message
    */
    private JSONObject BuildIMJsonObject(String destination, String text) throws JSONException {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        JSONObject IMObject = new JSONObject();
        JSONObject messsageRootIMObject = new JSONObject();

        JSONObject innerMessageObject = new JSONObject();
        innerMessageObject.put("mimeType", "text/plain");
        innerMessageObject.put("text", text);

        IMObject.put("contentType", "text");
        IMObject.put("destination", destination);
        IMObject.put("UUID", randomUUIDString);
        IMObject.put("message", innerMessageObject);

        messsageRootIMObject.put("message", IMObject);
        return messsageRootIMObject;
    }
}
