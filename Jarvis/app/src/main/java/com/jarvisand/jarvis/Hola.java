package com.jarvisand.jarvis;

/**
 * Created by abhisheknayyar on 9/27/15.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.*;
import java.io.OutputStreamWriter;
import android.os.StrictMode;
import com.loopj.android.http.*;
import com.squareup.okhttp.*;
import com.squareup.okhttp.internal.framed.Header;

public class Hola {
    private static final String BASE_URL = "https://vast-crag-4697.herokuapp.com/restaurants";

    public static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        //client.post(getAbsoluteUrl(url), params, responseHandler);
        client.setURLEncodingEnabled(false);
        //client.set
        client.addHeader("Content-Type", "application/json");
        client.put("https://vast-crag-4697.herokuapp.com/restaurants/2/tables/2", params, responseHandler);
        //client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
