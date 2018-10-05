package com.respondent.logging;

import com.respondent.models.PrintableRespondent;

import java.util.List;
import java.util.Map;

public class RespondentConsoleLogger {

    public RespondentConsoleLogger() {}

    public static void print(Map<String, String> locationMap, Map<String, List<PrintableRespondent>> respondentMap,
                             int distance, boolean isMiles) {
        // Print our sorted data
        System.out.println("");
        System.out.println(String.format(
                "The following is a list of project locations with respondents that are located within %d %s of that location.",
                distance, isMiles ? "mi." : "km"));

        for (Map.Entry<String, String> entry : locationMap.entrySet()) {
            System.out.println("");
            System.out.println(String.format("Project Location: %s", entry.getValue()));

            List<PrintableRespondent> printableRespondents = respondentMap.get(entry.getKey());
            printableRespondents.forEach(pr -> {
                System.out.println(String.format("\t%s", pr.toString()));
            });
        }

        System.out.println("");
    }
}
