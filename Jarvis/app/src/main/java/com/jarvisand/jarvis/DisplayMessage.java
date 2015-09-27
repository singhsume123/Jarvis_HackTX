package com.jarvisand.jarvis;

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

public class DisplayMessage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();

        final TextView mt = (TextView) findViewById(R.id.maintext);
        final TextView mt1 = (TextView) findViewById(R.id.maintext1);
        final TextView mt2 = (TextView) findViewById(R.id.maintext2);
       // final TextView mt1 = new TextView(this);
        final ArrayList<JSONObject> myRestaurants = new ArrayList<JSONObject>();

        //  Make an async client
        AsyncHttpClient client123 = new AsyncHttpClient();
        client123. addHeader("Content-Type", "application/json");
        client123.get("https://whispering-reef-1270.herokuapp.com/restaurants/", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response) {
                AsyncHttpClient.log.w("wtf", "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
                Log.i("wtf,", response.toString());
                response.toString();
                    try {
                        JSONObject restaurant = response.getJSONObject(0);
                        Log.i("just logignt it", restaurant.getString("name"));
                        // will make it synchronous
                       // myRestaurants.add(restaurant);
                        String textToDisplay = "" ;
                        textToDisplay += "Restaurant Name: " + restaurant.getString("name");
                        textToDisplay += "Resturant Address: " + restaurant.getString("address");
                        textToDisplay += "Waiting Time is  " + restaurant.getString("avgwaittime");
                        mt.setText(textToDisplay);

                        restaurant = response.getJSONObject(1);
                        Log.i("just logignt it", restaurant.getString("name"));
                        // will make it synchronous
                       // myRestaurants.add(restaurant);
                        textToDisplay = "" ;
                        textToDisplay += "Restaurant Name: " + restaurant.getString("name");
                        textToDisplay += "Resturant Address: " + restaurant.getString("address");
                        textToDisplay += "Waiting Time is  " + restaurant.getString("avgwaittime");
                        mt1.setText(textToDisplay);

                        restaurant = response.getJSONObject(2);
                        Log.i("just logignt it", restaurant.getString("name"));
                        // will make it synchronous
                        // myRestaurants.add(restaurant);
                        textToDisplay = "" ;
                        textToDisplay += "Restaurant Name: " + restaurant.getString("name");
                        textToDisplay += "Resturant Address: " + restaurant.getString("address");
                        textToDisplay += "Waiting Time is  " + restaurant.getString("avgwaittime");
                        mt2.setText(textToDisplay);
                    }
                    catch (Exception ex) {

                    }

            }
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                AsyncHttpClient.log.w("wtf", "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
                Log.i("wtf,", response.toString());
            }
        });

        Log.i("is_it", "running");

    }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_message, menu);
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
