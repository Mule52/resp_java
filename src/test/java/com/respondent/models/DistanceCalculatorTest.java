package com.respondent.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistanceCalculatorTest {

    double baltimoreLat = 39.2904;
    double baltimoreLong = -76.6122;

    double dcLat = 38.9072;
    double dcLong = -77.0369;

    double seattleLat = 47.6062;
    double seattleLong = -122.3321;

    double sydneyLat = -33.8688;
    double sydneyLong = 151.2093;

    // TODO: add perf tests
    // TODO: how large of files can be loaded, what are the response times?

    @Test
    public void distanceBetweenIdenticalLatLongPointsShouldBeZero(){
        double latitude = 40.7486;
        double longitude = -73.9864;

        double result = DistanceCalculator.getDistanceBetweenLatLongPoints(
                latitude, longitude, latitude, longitude, false);

        assertEquals(0, result, 0);
    }

    @Test
    public void distanceBetweenBaltimoreAndDcInKm(){

        double result = DistanceCalculator.getDistanceBetweenLatLongPoints(
                baltimoreLat, baltimoreLong, dcLat, dcLong, false);

        assertEquals(56.2, result, 0.1);
    }

    @Test
    public void distanceBetweenSeattleAndDcInKm(){

        double result = DistanceCalculator.getDistanceBetweenLatLongPoints(
                seattleLat, seattleLong, dcLat, dcLong, false);

        assertEquals(3736.3, result, 0.1);
    }

    @Test
    public void distanceBetweenDcAndSydneyInKm(){

        double result = DistanceCalculator.getDistanceBetweenLatLongPoints(
                dcLat, dcLong, sydneyLat, sydneyLong, false);

        assertEquals(15710.4, result, 0.1);
    }

    @Test
    public void distanceBetweenKmAndMilesShouldBeAFactorOfMilesDivisor(){
        double resultInKm = DistanceCalculator.getDistanceBetweenLatLongPoints(
                dcLat, dcLong, sydneyLat, sydneyLong, false);

        assertEquals(
                15710.4 * DistanceCalculator.milesFactor,
                resultInKm * DistanceCalculator.milesFactor,
                0.1);
    }

    @Test
    public void distanceBetweenSeattleAndSydneyInMiles(){

        double result = DistanceCalculator.getDistanceBetweenLatLongPoints(
                seattleLat, seattleLong, sydneyLat, sydneyLong, true);

        assertEquals(7748.7, result, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidUpperBoundLatitudeShouldThrowError(){
        double result = DistanceCalculator.getDistanceBetweenLatLongPoints(
                90.1, -180, 90 , 180, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidLowerBoundLatitudeShouldThrowError(){
        double result = DistanceCalculator.getDistanceBetweenLatLongPoints(
                90, -180, -90.1 , 180, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidUpperBoundLongitudeShouldThrowError(){
        double result = DistanceCalculator.getDistanceBetweenLatLongPoints(
                90, 180.1, 90 , -180, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidLowerBoundLongitudeShouldThrowError(){
        double result = DistanceCalculator.getDistanceBetweenLatLongPoints(
                90, 180, -90 , -180.1, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidUpperBoundLatitudeShouldThrowErrorForMiles(){
        double result = DistanceCalculator.getDistanceBetweenLatLongPoints(
                90.1, -180, 90 , 180, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidLowerBoundLatitudeShouldThrowErrorForMiles(){
        double result = DistanceCalculator.getDistanceBetweenLatLongPoints(
                90, -180, -90.1 , 180, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidUpperBoundLongitudeShouldThrowErrorForMiles(){
        double result = DistanceCalculator.getDistanceBetweenLatLongPoints(
                90, 180.1, 90 , -180, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidLowerBoundLongitudeShouldThrowErrorForMiles(){
        double result = DistanceCalculator.getDistanceBetweenLatLongPoints(
                90, 180, -90 , -180.1, true);
    }
}
