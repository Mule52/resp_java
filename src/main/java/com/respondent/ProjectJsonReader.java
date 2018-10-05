package com.respondent;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.respondent.models.ProjectJson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProjectJsonReader {

    private String pathToProjectJsonFile;

    public ProjectJsonReader(String pathToProjectJsonFile){

        this.pathToProjectJsonFile = pathToProjectJsonFile;
    }

    public ProjectJson createProjectJson() throws IOException {
        Gson gson = new Gson();
        ProjectJson projectJson = null;

        try (JsonReader reader = new JsonReader(new FileReader(pathToProjectJsonFile))) {
            projectJson = gson.fromJson(reader, ProjectJson.class);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("project.json could not be found");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("project.json could not be loaded");
        }

        return projectJson;
    }
}
