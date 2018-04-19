package com.prajjawalan.prajjwalan.models;

/**
 * Created by Alabhya Pandey on 13-04-2018.
 */

public class Contact {

    private String name;
    private String contact;

    public Contact(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public Contact(String name) {
        this.name = name;
    }

    public Contact() {
    }



    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
