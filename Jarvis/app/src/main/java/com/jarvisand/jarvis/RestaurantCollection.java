package com.jarvisand.jarvis;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by abhisheknayyar on 9/26/15.

public class RestaurantCollection {
    ArrayList<Restaurant> restaurants;

    public Restaurants()
    {
        restaurants = new ArrayList<Restaurant>();
    }
    public static RestaurantCollection parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        RestaurantCollection boxOfficeMovieResponse = gson.fromJson(response, Response.class);
        return boxOfficeMovieResponse;
    }
}

class Restaurant {
    Integer id;
    String name;
    String address;
    String email;
    Integer phone;
    Integer avgWaitTime;

    public int getId() {
        return id;
    }
    public String getName() {

        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public int getPhone() {
        return phone;
    }
    public int getAvgWaitTime() {
        return avgWaitTime;
    }
}*/