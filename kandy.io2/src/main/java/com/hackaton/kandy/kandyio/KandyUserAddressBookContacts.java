package com.hackaton.kandy.kandyio;

import com.google.gson.Gson;
import com.hackaton.kandy.kandyio.Entities.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by RanjanD on 3/11/2017.
 */

public class KandyUserAddressBookContacts {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private String userAccessToken = "";

    private final String apiHost = "https://api.kandy.io";
    private final String version = "v1.2";
    private final String apiURL = apiHost + '/' + version;

    public KandyUserAddressBookContacts(String userAccessToken){
        this.userAccessToken = userAccessToken;
    }

    /*
        Get Kandy Personal User Address Book Contacts
    */
    public List<Contact> GetContacts() throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        String url = apiURL + "/users/addressbooks/personal?key=%s";
        Request request = new Request.Builder()
                .url(String.format(url, userAccessToken))
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

        JSONArray contactsJsonArray = null;
        List<Contact> contacts = new ArrayList<Contact>();

        if(resultJson != null){
            contactsJsonArray = resultJson.getJSONArray("contacts");
            Gson gson = new Gson();
            contacts = Arrays.asList(gson.fromJson(contactsJsonArray.toString(), Contact[].class));
        }

        return contacts;
    }

    public String AddContact(Contact contact) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        Gson gson = new Gson();
        String jsonInString = gson.toJson(contact);
        RequestBody body = RequestBody.create(JSON, " {\"contact\":" +
                jsonInString  + "\n}");

        String url = apiURL + "/users/addressbooks/personal?key=%s";
        Request request = new Request.Builder()
                .url(String.format(url, userAccessToken))
                .post(body)
                .build();

        Response response = null;

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(response != null){
            String jsonData = response.body().string();
            JSONObject Jobject = new JSONObject(jsonData);
            JSONObject resultJson = Jobject.getJSONObject("result");

            if(resultJson != null){
                return resultJson.getString("contact_id");
            }
        }

        return "";
    }

    public String DeleteContact(String contactId) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        String url = apiURL + "/users/addressbooks/personal?key=" + userAccessToken +
                "&contact_id=" + contactId;

        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();

        Response response = null;

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(response != null){
            String jsonData = response.body().string();
            if(jsonData != null){
                JSONObject Jobject = new JSONObject(jsonData);
                return Jobject.getString("message");
            }
        }

        return "";
    }
}
