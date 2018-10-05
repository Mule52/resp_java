package com.respondent.models;

public class PrintableRespondent {

    private String firstName;
    private String gender;
    private String respondentLocation;
    private String fromLocationTitle;
    private Double distanceFromLocation;
    private boolean isMiles;

    public PrintableRespondent(
            String firstName,
            String gender,
            String respondentLocation,
            String fromLocationTitle,
            Double distanceFromLocation,
            boolean isMiles) {

        this.firstName = firstName;
        this.gender = gender;
        this.respondentLocation = respondentLocation;
        this.fromLocationTitle = fromLocationTitle;
        this.distanceFromLocation = distanceFromLocation;
        this.isMiles = isMiles;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return String.format("%s (%s from %s) is %.1f %s from %s",
                firstName,
                gender,
                respondentLocation,
                distanceFromLocation,
                isMiles ? "mi." : "km",
                fromLocationTitle);
    }
}
