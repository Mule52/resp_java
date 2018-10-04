package com.respondent.logging;

import com.respondent.models.PrintableRespondent;

import java.util.List;
import java.util.Map;

public class RespondentConsoleLogger {

    public RespondentConsoleLogger() {}

    public static void print(Map<String, String> locationMap, Map<String, List<PrintableRespondent>> respondentMap) {
        // Print our sorted data
        System.out.println("Project Location:");

        for (Map.Entry<String, String> entry : locationMap.entrySet()) {
            System.out.println(String.format("\t%s", entry.getValue()));

            List<PrintableRespondent> printableRespondents = respondentMap.get(entry.getKey());
            printableRespondents.forEach(pr -> {
                System.out.println(String.format("\t\t%s", pr.toString()));
            });
        }
    }
}
