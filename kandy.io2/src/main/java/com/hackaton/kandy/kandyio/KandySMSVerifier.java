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
 * Created by RanjanD on 3/12/2017.
 */

public class KandySMSVerifier {

    private final String apiHost = "https://api.kandy.io";
    private final String version = "v1.2";
    private final String apiURL = apiHost + '/' + version;
    private String domainAccessToken = "";

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public KandySMSVerifier(String domainAccessToken){
        this.domainAccessToken = domainAccessToken;
    }

    /*
    * @method SendSMSVerification
    * Send validation code to phone
    * @param {String} phoneNumber Phone number to send validation SMS to.
    */
    public String SendSMSVerificationCode(String phoneNumber, String countryCode) throws JSONException {
        String kandySMSApiUrl = apiURL + "/domains/verifications/smss?" + "key=%s";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_phone_number", phoneNumber);
        jsonObject.put("user_country_code", countryCode);

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, String.valueOf(jsonObject));
        Request request = new Request.Builder()
                .url(String.format(kandySMSApiUrl, domainAccessToken))
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
      * @method ValidateSMSCode
      * Send validation code to phone
      * @param {String} validationCode Validation code sent to phone.
    */
    public Boolean ValidateSMSCode(String validationCode,String phoneNumber, String countryCode) throws Exception {
        String kandySMSApiUrl = apiURL + "/domains/verifications/codes?"
                + "key=%s&validation_code=%s&user_phone_number=%s&user_country_code=%s";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(String.format(kandySMSApiUrl,
                        domainAccessToken, validationCode, phoneNumber, countryCode))
                .get()
                .build();

        Response response = null;

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonData = response.body().string();
        JSONObject Jobject = new JSONObject(jsonData);

        // Status code 10 is Error
        if(Jobject.getString("status") == "10")
            throw new Exception(Jobject.getString("message"));

        JSONObject resultJson = (JSONObject) Jobject.get("result");
        if(resultJson != null)
            return resultJson.getBoolean("valid");

        return false;
    }
}
