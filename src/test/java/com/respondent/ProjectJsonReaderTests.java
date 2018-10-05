package com.respondent;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ProjectJsonReaderTests {

    @Test(expected = FileNotFoundException.class)
    public void invalidFileShouldThrowFileNotFoundException() throws IOException {

        ProjectJsonReader projectJsonReader = new ProjectJsonReader("////bad-path-to-file");
        projectJsonReader.createProjectJson();
    }
}
