package com.respondent.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrintableRespondentTest {

    @Test
    public void toStringShouldReturnDetailsOfRespondentInMiles(){
        PrintableRespondent printableRespondent =
                new PrintableRespondent("John", "male",
                        "Lincoln, NE, USA",
                        "Los Angeles, CA, US",
                        1500.0,
                        true);

        String result = printableRespondent.toString();

        assertEquals("John (male from Lincoln, NE, USA) is 1500.0 mi. from Los Angeles, CA, US", result);
    }

    @Test
    public void toStringShouldReturnDetailsOfRespondentInKm(){
        PrintableRespondent printableRespondent =
                new PrintableRespondent("Sally", "female",
                        "Boise, ID, USA",
                        "Washington, DC, US",
                        2950.0,
                        false);

        String result = printableRespondent.toString();

        assertEquals("Sally (female from Boise, ID, USA) is 2950.0 km from Washington, DC, US", result);
    }
}
