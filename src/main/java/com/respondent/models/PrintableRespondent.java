package com.respondent.models;

public class PrintableRespondent {

    private String firstName;
    private String gender;
    private String respondentLocation;
    private String distanceFromLocation;
    private Double distanceFromLocationInKm;

    public PrintableRespondent(
            String firstName,
            String gender,
            String respondentLocation,
            String distanceFromLocation,
            Double distanceFromLocationInKm) {

        this.firstName = firstName;
        this.gender = gender;
        this.respondentLocation = respondentLocation;
        this.distanceFromLocation = distanceFromLocation;
        this.distanceFromLocationInKm = distanceFromLocationInKm;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return String.format("%s (%s from %s) is %.2f km from %s",
                firstName,
                gender,
                respondentLocation,
                distanceFromLocationInKm,
                distanceFromLocation);
    }
}
