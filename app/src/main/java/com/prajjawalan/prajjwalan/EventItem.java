package com.prajjawalan.prajjwalan;

/**
 * Created by Alabhya Pandey on 03-04-2018.
 */

public class EventItem {
    private String url;
    private String name;

    public EventItem(String imageUrl, String eventName){
        name = eventName;
        url = imageUrl;
    }
    public String geteventName(){
        return name;
    }

    public String getimageUrl(){
        return url;
    }



}
