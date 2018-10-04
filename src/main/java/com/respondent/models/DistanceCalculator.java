package com.respondent.models;

// This uses the ‘haversine’ formula to calculate the great-circle distance between two points – that is,
// // the shortest distance over the earth’s surface – giving an ‘as-the-crow-flies’ distance between the points;
// http://www.movable-type.co.uk/scripts/latlong.html
// https://en.wikipedia.org/wiki/Haversine_formula

public class DistanceCalculator {

    private static final double pi = 3.14159;
    private static final double radiusOfEarth = 6371;

    public static double getDistanceInKilometersBetweenLatLongPoints(
            double fromLatitude,
            double fromLongitude,
            double toLatitude,
            double toLongitude) {

        double latDistance = Math.toRadians(fromLatitude - toLatitude);
        double lngDistance = Math.toRadians(fromLongitude - toLongitude);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(fromLatitude)) * Math.cos(Math.toRadians(toLatitude))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return c * radiusOfEarth;
    }
}
