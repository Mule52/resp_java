package com.respondent;

import com.respondent.logging.RespondentConsoleLogger;
import com.respondent.models.*;

import java.util.*;

public class Main {

    /***
     * We have some respondents in a text file (respondents.csv attached) one respondent per line
     that we would like to match with a project (project.json attached).
     We want to invite all respondents that fit in the cities of the project within a 100km radius.
     Write a program that will read the full list of respondents and output the names and distance of
     matching respondents (within 100km), sorted by name (ascending).
     */

    public static void main(String[] args) throws Exception {

        String pathToProjectJsonFile = "/home/alex/git/resp_java/src/main/resources/project.json";
        String pathToRespondentsCsvFile = "/home/alex/git/resp_java/src/main/resources/respondents.csv";

        // Load up the respondents.csv file into a List<Respondent>
        RespondentsCsvReader respondentsCsvReader = new RespondentsCsvReader(pathToRespondentsCsvFile);
        List<Respondent> respondents = respondentsCsvReader.getRespondents();

        // Load up the project.json into a ProjectJson object
        ProjectJsonReader projectJsonReader = new ProjectJsonReader(pathToProjectJsonFile);
        ProjectJson projectJson = projectJsonReader.createProjectJson();

        // Get the main cities from ProjectJson and sort them A-Z, the will be used for display.
        List<City> cities = projectJson.getCitiesSorted();

        Map<String, List<PrintableRespondent>> respondentMap = new HashMap<>();

        // insertion order matters for displaying A-Z by City, State, Country
        Map<String, String> locationMap = new LinkedHashMap<>();

        // for each city, get the respondents who reside within 100 km
        for (City city : cities) {
            locationMap.put(city.getLocation().getId(), city.getLocation().toString());
            List<PrintableRespondent> nearestRespondents = new ArrayList<>();
            Double cityLatitude = city.getLocation().getLocation().getLatitude();
            Double cityLongitude = city.getLocation().getLocation().getLongitude();

            for (Respondent respondent : respondents) {
                // calculate the distance between city and respondent city
                Double distance = DistanceCalculator.getDistanceInKilometersBetweenLatLongPoints(
                        cityLatitude,
                        cityLongitude,
                        respondent.getLatitude(),
                        respondent.getLongitude());

                if (distance <= 100) {
                    nearestRespondents.add(new PrintableRespondent(
                            respondent.getFirstName(),
                            respondent.getGender(),
                            respondent.getLocation(),
                            city.getLocation().toString(),
                            distance
                    ));
                }
            }

            nearestRespondents.sort(Comparator.comparing(a -> a.getFirstName().toLowerCase()));
            respondentMap.put(city.getLocation().getId(), nearestRespondents);
        }

        RespondentConsoleLogger.print(locationMap, respondentMap);
    }
}
