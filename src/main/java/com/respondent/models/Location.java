package com.respondent.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("location")
    @Expose
    private Location_ location;

    public String getId() {
        return id;
    }

    public Location_ getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", city, state, country);
    }

}
