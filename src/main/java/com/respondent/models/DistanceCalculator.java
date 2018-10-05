package com.respondent.models;

// This uses the ‘haversine’ formula to calculate the great-circle distance between two points – that is,
// // the shortest distance over the earth’s surface – giving an ‘as-the-crow-flies’ distance between the points;
// http://www.movable-type.co.uk/scripts/latlong.html
// https://en.wikipedia.org/wiki/Haversine_formula
//
// Latitude/Longitude rules
// Precede South latitudes and West longitudes with a minus sign.
// Latitudes range from -90 to 90.
// Longitudes range from -180 to 180.

public class DistanceCalculator {

    private static final double pi = 3.14159;

    // 6371 km is the generally accepted value for the earth’s mean radius.
    private static final double radiusOfEarth = 6371;

    // For miles, divide km by 1.609344
    // 1 km = 0.621371 miles
    public static final double milesFactor = 0.621371;

    public static double getDistanceBetweenLatLongPoints(
            double fromLatitude,
            double fromLongitude,
            double toLatitude,
            double toLongitude,
            boolean isMiles) {

        if (!isLatitudeValid(fromLatitude)) {
            throw new IllegalArgumentException("fromLatitude is invalid, Latitudes range from -90 to 90.");
        }

        if (!isLatitudeValid(toLatitude)) {
            throw new IllegalArgumentException("toLatitude is invalid, Latitudes range from -90 to 90.");
        }

        if (!isLongitudeValid(fromLongitude)) {
            throw new IllegalArgumentException("fromLongitude is invalid, Latitudes range from -90 to 90.");
        }

        if (!isLongitudeValid(toLongitude)) {
            throw new IllegalArgumentException("toLongitude is invalid, Latitudes range from -90 to 90.");
        }

        double latDistance = Math.toRadians(fromLatitude - toLatitude);
        double lngDistance = Math.toRadians(fromLongitude - toLongitude);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(fromLatitude)) * Math.cos(Math.toRadians(toLatitude))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = c * radiusOfEarth;

        if (isMiles) {
            distance *= milesFactor;
        }

        return distance;
    }

    private static boolean isLatitudeValid(double latitude) {
        return -90 <= latitude && latitude <= 90;
    }

    private static boolean isLongitudeValid(double longitude) {
        return -180 <= longitude && longitude <= 180;
    }
}
