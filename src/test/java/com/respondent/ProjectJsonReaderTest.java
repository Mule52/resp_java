package com.respondent;

import com.respondent.models.City;
import com.respondent.models.ProjectJson;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProjectJsonReaderTest {

    // TODO: add more tests around the sie of the project.json file
    // TODO: how much data can be handled, how does it perform

    private String pathToFile = "src/main/resources/project.json";
    private ProjectJsonReader projectJsonReader;

    @Before
    public void beforeEach(){
        projectJsonReader = new ProjectJsonReader(pathToFile);
    }

    @Test(expected = FileNotFoundException.class)
    public void invalidFileShouldThrowFileNotFoundException() throws IOException {
        ProjectJsonReader projectJsonReader = new ProjectJsonReader("////bad-path-to-file");
        projectJsonReader.createProjectJson();
    }

    @Test
    public void fileCanBeLoaded() throws IOException {
        ProjectJson projectJson = projectJsonReader.createProjectJson();
        assertNotNull(projectJson);
    }

    @Test
    public void citiesCanBeAccessed() throws IOException {
        ProjectJson projectJson = projectJsonReader.createProjectJson();
        List<City> cities = projectJson.getCities();

        String[] expectedCities = new String[]{
                "New York, NY, US",
                "Philadelphia, PA, US",
                "Miami, FL, US",
                "Dallas, TX, US",
                "Los Angeles, CA, US",
                "San Francisco, CA, US",
                "Boston, MA, US",
                "Washington, DC, US",
        } ;

        for (int i=0; i<cities.size(); i++) {
            assertEquals(expectedCities[i], cities.get(i).getLocation().toString());
        }
    }

    @Test
    public void citiesCanBeAccessedAsSorted() throws IOException {
        ProjectJson projectJson = projectJsonReader.createProjectJson();
        List<City> cities = projectJson.getCitiesSorted();

        String[] sortedCitiesExpected = new String[]{
                "Boston, MA, US",
                "Dallas, TX, US",
                "Los Angeles, CA, US",
                "Miami, FL, US",
                "New York, NY, US",
                "Philadelphia, PA, US",
                "San Francisco, CA, US",
                "Washington, DC, US",
        } ;

        for (int i=0; i<cities.size(); i++) {
            assertEquals(sortedCitiesExpected[i], cities.get(i).getLocation().toString());
        }
    }
}
