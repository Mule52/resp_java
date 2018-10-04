package com.respondent.models;

import java.util.Comparator;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectJson {

    @SerializedName("numberOfParticipants")
    @Expose
    private Integer numberOfParticipants;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("cities")
    @Expose
    private List<City> cities = null;
    @SerializedName("genders")
    @Expose
    private String genders;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("respondentRemuneration")
    @Expose
    private Integer respondentRemuneration;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("internalName")
    @Expose
    private String internalName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("professionalJobTitles")
    @Expose
    private List<String> professionalJobTitles = null;

    public Integer getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(Integer numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public String getGenders() {
        return genders;
    }

    public void setGenders(String genders) {
        this.genders = genders;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getRespondentRemuneration() {
        return respondentRemuneration;
    }

    public void setRespondentRemuneration(Integer respondentRemuneration) {
        this.respondentRemuneration = respondentRemuneration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getProfessionalJobTitles() {
        return professionalJobTitles;
    }

    public void setProfessionalJobTitles(List<String> professionalJobTitles) {
        this.professionalJobTitles = professionalJobTitles;
    }

    public List<City> getCitiesSorted() {
        cities.sort(Comparator.comparing(a -> a.getLocation().toString()));
        return cities;
    }
}