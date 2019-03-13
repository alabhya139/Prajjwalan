package com.prajjawalan.app.models;

/**
 * Created by Alabhya Pandey on 09-04-2018.
 */

public class Data {
    private String coordinator;
    private String schedule;
    private String result;
    private String details;
    private String name;
    private String url;

    public Data(String coordinator, String schedule, String result, String details, String name, String url) {
        this.coordinator = coordinator;
        this.schedule = schedule;
        this.result = result;
        this.details = details;
        this.name = name;
        this.url = url;
    }

    public Data(){

    }

    public String getCoordinator() {
        return coordinator;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getResult() {
        return result;
    }

    public String getDetails() {
        return details;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setResult(String rules) {
        this.result = rules;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
