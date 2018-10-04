package com.respondent.models;

public class Respondent {

    private String firstName;
    private String gender;
    private String location;
    private Double latitude;
    private Double longitude;

    public Respondent(String firstName, String gender, String location,
                      Double latitude, Double longitude) {

        this.firstName = firstName;
        this.gender = gender;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
