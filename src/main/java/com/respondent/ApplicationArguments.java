package com.respondent;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

public class ApplicationArguments {

    private String projectJson;
    private String respondentsCsv;
    private int distance;
    private boolean isMiles;

    public ApplicationArguments(String[] args) {

        if (args.length < 2 || args.length > 4){
            throw new IllegalArgumentException("Valid program arguments are --projectJson=/path/to/project.json " +
                    "--respondentsCsv=/path/to/respondents.csv --distance=100 (optional) --isMiles=true (optional)");
        }

        OptionParser parser = new OptionParser();
        parser.accepts("projectJson")
                .withRequiredArg()
                .ofType(String.class)
                .defaultsTo("/project.json")
                .required();

        parser.accepts("respondentsCsv")
                .withRequiredArg()
                .ofType(String.class)
                .defaultsTo("/respondents.csv")
                .required();

        parser.accepts( "distance" )
                .withOptionalArg()
                .ofType(Integer.class)
                .defaultsTo(100);

        parser.accepts("isMiles")
                .withOptionalArg()
                .ofType(Boolean.class)
                .defaultsTo(false);

        OptionSet options = parser.parse(args);
        projectJson = options.has("projectJson") ? options.valueOf("projectJson").toString() : null;
        respondentsCsv = options.has("respondentsCsv") ?
                options.valueOf("respondentsCsv").toString() : null;
        distance = options.has("distance") ?
                Integer.parseInt(options.valueOf("distance").toString()) : 100;
        isMiles = options.has("isMiles") ?
                Boolean.parseBoolean(options.valueOf("isMiles").toString()) : false;

        int maxKmAroundTheEarth = 40075;
        if (distance < 0 || distance > maxKmAroundTheEarth){
            throw new IllegalArgumentException("distance is an optional argument, with valid values from 0 - 40075.");
        }
    }

    public boolean hasProjectJson(){
        return projectJson != null;
    }

    public boolean hasRespondentsCsv(){
        return respondentsCsv != null;
    }

    public String getProjectJson() {
        return projectJson;
    }

    public String getRespondentsCsv() {
        return respondentsCsv;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isMiles() {
        return isMiles;
    }
}
