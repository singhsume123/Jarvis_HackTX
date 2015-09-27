package com.jarvisand.manager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.*;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.os.StrictMode;
import com.loopj.android.http.*;
import com.squareup.okhttp.*;
import com.squareup.okhttp.internal.framed.Header;
import android.net.Uri;
import android.widget.*;
import android.widget.AbsoluteLayout.LayoutParams;
import android.view.Gravity;
import android.util.TypedValue;
import android.graphics.Typeface;
import android.graphics.Color;



public class Response extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        String message = intent.getStringExtra(manager_main.EXTRA_MESSAGE);
        Log.i("My", message);

        RequestParams params = new RequestParams("avgwaittime", message);
        AsyncHttpClient client123 = new AsyncHttpClient();
        client123.addHeader("Content-Type", "application/json");
        params.setUseJsonStreamer(true);
        client123.put("https://whispering-reef-1270.herokuapp.com/restaurants/1", params, new JsonHttpResponseHandler() {

            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response) {
                AsyncHttpClient.log.w("wtf", "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
                Log.i("wtf,", response.toString());
            }
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                AsyncHttpClient.log.w("wtf", "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
                Log.i("wtf,", response.toString());
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_response, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
