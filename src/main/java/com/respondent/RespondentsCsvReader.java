package com.respondent;

import com.opencsv.CSVReader;
import com.respondent.models.Respondent;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RespondentsCsvReader {

    private String pathToRespondentsCsvFile;

    public RespondentsCsvReader(String pathToRespondentsCsvFile) {

        this.pathToRespondentsCsvFile = pathToRespondentsCsvFile;
    }

    public List<Respondent> getRespondents() throws IOException {
        List<Respondent> respondents = new ArrayList();

        try (CSVReader csvReader = new CSVReader(new FileReader(pathToRespondentsCsvFile), ',')) {
            String[] record = null;
            int rowIndex = 0;

            while ((record = csvReader.readNext()) != null) {
                if (rowIndex > 0) {
                    respondents.add(
                            new Respondent(
                                    record[0],
                                    record[1],
                                    record[2],
                                    Double.parseDouble(record[3]),
                                    Double.parseDouble(record[4])
                            )
                    );
                }
                rowIndex++;
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("respondents.csv could not be found");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("respondents.csv could not be loaded");
        }

        return respondents;
    }
}
