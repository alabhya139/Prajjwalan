package com.prajjawalan.prajjwalan.models;

/**
 * Created by Alabhya Pandey on 09-04-2018.
 */

public class Data {
    private String details;
    private String name;
    private String url;

    public Data(String details, String name, String url) {
        this.details = details;
        this.name = name;
        this.url = url;
    }

    public Data(){

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
