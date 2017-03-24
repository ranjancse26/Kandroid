package com.hackaton.kandy.kandyio;

import org.json.JSONException;
import java.io.IOException;
import okhttp3.Request;

/**
 * Created by RanjanD on 3/3/2017.
 */

public class KandyUserAccountAccessToken extends BaseAccessToken {

    private final String baseAPIUrl = "https://api.kandy.io/v1.2/accounts/accesstokens?key=%s&account_api_secret=%s";
    private String apiKey = "";
    private String apiSecretKey = "";

    public KandyUserAccountAccessToken(String apiKey, String apiSecretKey){
        this.apiKey = apiKey;
        this.apiSecretKey = apiSecretKey;
    }

    public String GetUserAccountAccessToken() throws IOException, JSONException {
        Request request = new Request.Builder()
                .url(String.format(baseAPIUrl, apiKey, apiSecretKey))
                .get()
                .build();

        return ProcessRequestAccessToken("account", request);
    }
}
