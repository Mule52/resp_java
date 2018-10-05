package com.respondent;

import com.respondent.models.Respondent;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RespondentsCsvReaderTest {

    // TODO: add more tests around the size of the respondents.csv file
    // TODO: how much data can be handled, how does it perform?

    String pathToFile = "src/main/resources/respondents.csv";
    RespondentsCsvReader respondentsCsvReader;

    @Before
    public void beforeEach(){
        respondentsCsvReader = new RespondentsCsvReader(pathToFile);
    }

    @Test(expected = FileNotFoundException.class)
    public void invalidFileShouldThrowFileNotFoundException() throws IOException {

        RespondentsCsvReader respondentsCsvReader =
                new RespondentsCsvReader("////bad-path-to-file");
        respondentsCsvReader.getRespondents();
    }

    @Test
    public void respondentsFileCanBeLoaded() throws IOException {
        assertNotNull(respondentsCsvReader.getRespondents());
    }

    @Test
    public void respondentsCanBeAccessed() throws IOException {
        List<Respondent> respondents = respondentsCsvReader.getRespondents();
        assertEquals(200, respondents.size());
    }

    @Test
    public void firstRespondentIsValid() throws IOException {
        List<Respondent> respondents = respondentsCsvReader.getRespondents();
        Respondent firstRespondent = respondents.get(0);
        // "Marko","male","Vodnjan, Hrvatska","44.96116449999999","13.85283949999996"

        assertEquals("Marko", firstRespondent.getFirstName());
        assertEquals("male", firstRespondent.getGender());
        assertEquals("Vodnjan, Hrvatska", firstRespondent.getLocation());
        assertEquals(44.96116449999999, firstRespondent.getLatitude(), 0.1);
        assertEquals(13.85283949999996, firstRespondent.getLongitude(), 0.1);
    }
}
