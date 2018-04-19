package com.prajjawalan.prajjwalan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.prajjawalan.prajjwalan.models.Data;
import com.squareup.picasso.Picasso;

/**
 * Created by Alabhya Pandey on 09-04-2018.
 */

public class CommonActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private RecyclerView mRecyclerV;
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<Data, CommonActivity.DataViewHolder> mRecyclerVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_activity);

        Toolbar toolbar = findViewById(R.id.recycle_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        setTitle("Events");

        //"News" here will reflect what you have called your database in Firebase.
        mDatabase = FirebaseDatabase.getInstance().getReference().child("events");
        mDatabase.keepSynced(true);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        mRecyclerV = findViewById(R.id.events_view);

        DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("events");
        Query personsQuery = personsRef.orderByKey();

        mRecyclerV.hasFixedSize();
        mRecyclerV.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions personsOptions = new FirebaseRecyclerOptions.Builder<Data>().setQuery(personsQuery, Data.class).build();

        mRecyclerVAdapter = new FirebaseRecyclerAdapter<Data, CommonActivity.DataViewHolder>(personsOptions) {
            @Override
            protected void onBindViewHolder(CommonActivity.DataViewHolder holder, final int position, final Data model) {
                holder.setTitle(model.getName());
                holder.setImage(model.getUrl());
                progressBar.setVisibility(ProgressBar.INVISIBLE);

                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String details = model.getDetails();
                        final String name = model.getName();
                        final String url = model.getUrl();
                        final String coordinator = model.getCoordinator();
                        final String result = model.getResult();
                        final String schedule = model.getSchedule();
                        Intent intent = new Intent(getApplicationContext(), EventDetail.class);
                        intent.putExtra("url", url);
                        intent.putExtra("name",name);
                        intent.putExtra("details",details);
                        intent.putExtra("coordinator",coordinator);
                        intent.putExtra("result",result);
                        intent.putExtra("schedule",schedule);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public CommonActivity.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.event_list, parent, false);

                return new CommonActivity.DataViewHolder(view);
            }
        };

        mRecyclerVAdapter.notifyDataSetChanged();

        mRecyclerV.setAdapter(mRecyclerVAdapter);
    }



    @Override
    public void onStart() {
        super.onStart();
        mRecyclerVAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public DataViewHolder(View itemView){
            super(itemView);
            mView = itemView;
        }

        public void setTitle(String title){
            TextView post_title =mView.findViewById(R.id.event_name);
            post_title.setText(title);
        }

        public void setImage(String image){
            ImageView post_image = mView.findViewById(R.id.event_image);
            Picasso.get().load(image).into(post_image);
        }
    }
}
