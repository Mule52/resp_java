package com.respondent;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

public class ApplicationArguments {

    private String projectJson;
    private String respondentsCsv;
    private int distanceInKilometers;

    public ApplicationArguments(String[] args) {

        // TODO: used only for local debugging
        args = new String[]{"--projectJson=/home/alex/git/resp_java/src/main/resources/project.json",
                "--respondentsCsv=/home/alex/git/resp_java/src/main/resources/respondents.csv",
                "--distanceInKilometers=50"};

        if (args.length < 2 || args.length > 3){
            throw new IllegalArgumentException("Valid program arguments are --projectJson=/path/to/project.json " +
                    "--respondentsCsv=/path/to/respondents.csv --distanceInKilometers=100 (optional)");
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

        parser.accepts( "distanceInKilometers" )
                .withOptionalArg()
                .ofType(Integer.class)
                .defaultsTo(100);

        OptionSet options = parser.parse(args);
        projectJson = options.has("projectJson") ? options.valueOf("projectJson").toString() : null;
        respondentsCsv = options.has("respondentsCsv") ? options.valueOf("respondentsCsv").toString() : null;
        distanceInKilometers = options.has("distanceInKilometers") ?
                Integer.parseInt(options.valueOf("distanceInKilometers").toString()) : 100;
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

    public int getDistanceInKilometers() {
        return distanceInKilometers;
    }
}
