package com.prajjawalan.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.prajjawalan.app.models.Contact;

import java.util.ArrayList;

/**
 * Created by Alabhya Pandey on 13-04-2018.
 */

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);

        final ListView contactList = findViewById(R.id.contact_listview);

        Toolbar toolbar = findViewById(R.id.contact_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        setTitle("Contact Us");

        ArrayList<Object> list = new ArrayList<>();


        list.add(new String("ORGANIZING Committee"));
        list.add(new Contact("VISHAL PRATAP SINGH"));
        list.add(new Contact("DIVYANSHU SINGH"));
        list.add(new Contact("PRIYANSHU KUSHWAHA"));
        list.add(new Contact("UPENDRA KUMAR"));
        list.add(new Contact("ANUJ KUMAR"));
        list.add(new Contact("ASHISH KUMAR"));
        list.add(new Contact("VIKAS MADHESIYA"));
        list.add(new Contact("SHWETA GARG"));
        list.add(new Contact("PALLAVI GOYAL"));
        list.add(new Contact("SHIVANI BHASKAR"));
        list.add(new Contact("ARYAN RAJPUT"));
        list.add(new Contact("TARUN SHARMA"));
        list.add(new Contact("ANIRUDH SHARMA"));


        contactList.setAdapter(new ContactAdapter(this,list));
    }


}
