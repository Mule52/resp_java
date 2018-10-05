package com.respondent;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RespondentsCsvReaderTests {

    @Test(expected = FileNotFoundException.class)
    public void invalidFileShouldThrowFileNotFoundException() throws IOException {

        RespondentsCsvReader respondentsCsvReader =
                new RespondentsCsvReader("////bad-path-to-file");
        respondentsCsvReader.getRespondents();
    }
}
