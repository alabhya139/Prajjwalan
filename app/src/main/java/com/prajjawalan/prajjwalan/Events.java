package com.prajjawalan.prajjwalan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Alabhya Pandey on 03-04-2018.
 */

public class Events extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_activity);
        ArrayList<EventItem> eventList = new ArrayList<>();
        eventList.add(new EventItem("https://firebasestorage.googleapis.com/v0/b/prajjwalan-9ade7.appspot.com/o/events_item%2Frobots.png?alt=media&token=62f8572f-a915-4b97-b8b2-5541da18933d","Robotics"));
        eventList.add(new EventItem("https://firebasestorage.googleapis.com/v0/b/prajjwalan-9ade7.appspot.com/o/events_item%2Frobowars.jpg?alt=media&token=ad9e41d3-b9fc-47b7-ae67-a0d658c83f13", "RoboWar"));

        mRecyclerView = findViewById(R.id.events_view);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(eventList);
        mRecyclerView.setAdapter(adapter);
    }
}
