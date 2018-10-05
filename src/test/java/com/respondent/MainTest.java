package com.respondent;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class MainTest {

    String projectJson = "src/main/resources/project.json";
    String respondentsCsv = "src/main/resources/respondents.csv";

    @Test
    public void appCanBeRunWithDefaultArgs() throws Exception {

        String[] args = new String[]{
                "--projectJson=" + projectJson,
                "--respondentsCsv=" + respondentsCsv,
        };
        Main.main(args);
    }

    @Test
    public void appCanBeRunWithDefaultArgsAndDistance() throws Exception {

        String[] args = new String[]{
                "--projectJson=" + projectJson,
                "--respondentsCsv=" + respondentsCsv,
                "--distance=10"
        };
        Main.main(args);
    }

    @Test
    public void appCanBeRunWithDefaultArgsAndIsMiles() throws Exception {

        String[] args = new String[]{
                "--projectJson=" + projectJson,
                "--respondentsCsv=" + respondentsCsv,
                "--isMiles=true"
        };
        Main.main(args);
    }

    @Test
    public void appCanBeRunWithAllValidArgs() throws Exception {

        String[] args = new String[]{
                "--projectJson=" + projectJson,
                "--respondentsCsv=" + respondentsCsv,
                "--distance=10",
                "--isMiles=true"
        };
        Main.main(args);
    }

    @Test(expected=IllegalArgumentException.class)
    public void appWithInvalidUpperBoundDistanceThrowsIllegalArgumentException() throws Exception {

        String[] args = new String[]{
                "--projectJson=" + projectJson,
                "--respondentsCsv=" + respondentsCsv,
                "--distance=40076",
                "--isMiles=true"
        };
        Main.main(args);
    }

    @Test(expected=IllegalArgumentException.class)
    public void appWithInvalidLowerBoundDistanceThrowsIllegalArgumentException() throws Exception {

        String[] args = new String[]{
                "--projectJson=" + projectJson,
                "--respondentsCsv=" + respondentsCsv,
                "--distance=-1",
                "--isMiles=true"
        };
        Main.main(args);
    }

    @Test(expected=IllegalArgumentException.class)
    public void appWithNoArgsThrowsIllegalArgumentException() throws Exception {

        Main.main(new String[]{});
    }


    @Test(expected=IllegalArgumentException.class)
    public void appWithTooFewArgsThrowsIllegalArgumentException() throws Exception {

        String[] args = new String[]{
                "--projectJson=" + projectJson,
        };
        Main.main(args);
    }

    @Test(expected=IllegalArgumentException.class)
    public void appWithTooManyArgsThrowsIllegalArgumentException() throws Exception {

        String[] args = new String[]{
                "--projectJson=" + projectJson,
                "--respondentsCsv=" + respondentsCsv,
                "--distance=-1",
                "--isMiles=true",
                "--extra=arg"
        };
        Main.main(args);
    }

    @Test(expected=FileNotFoundException.class)
    public void appWithInvalidJsonFileThrowsFileNotFoundException() throws Exception {

        String[] args = new String[]{
                "--projectJson=////invalid.json",
                "--respondentsCsv=" + respondentsCsv,
        };
        Main.main(args);
    }

    @Test(expected=FileNotFoundException.class)
    public void appWithInvalidCsvFileThrowsFileNotFoundException() throws Exception {

        String[] args = new String[]{
                "--projectJson=" + projectJson,
                "--respondentsCsv=////invalid.csv",
        };
        Main.main(args);
    }
}
