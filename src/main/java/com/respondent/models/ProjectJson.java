package com.respondent.models;

import java.util.Comparator;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectJson {

    @SerializedName("cities")
    @Expose
    private List<City> cities = null;

    public List<City> getCities() {
        return cities;
    }

    public List<City> getCitiesSorted() {
        cities.sort(Comparator.comparing(a -> a.getLocation().toString()));
        return cities;
    }
}