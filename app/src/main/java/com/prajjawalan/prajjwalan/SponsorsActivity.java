package com.prajjawalan.prajjwalan;

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


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.prajjawalan.prajjwalan.models.Sponsors;
import com.squareup.picasso.Picasso;

/**
 * Created by Alabhya Pandey on 13-04-2018.
 */

public class SponsorsActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    private RecyclerView mRecyclerV;
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<Sponsors, SponsorsActivity.SponsorsViewHolder> mRecyclerVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sponsors_main);

        progressBar = findViewById(R.id.sponsorsprogressbar);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        Toolbar toolbar = findViewById(R.id.sponsor_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        setTitle("Sponsors");

        //"News" here will reflect what you have called your database in Firebase.
        mDatabase = FirebaseDatabase.getInstance().getReference().child("sponsors");
        mDatabase.keepSynced(true);

        mRecyclerV = findViewById(R.id.sponsors_view);

        DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("sponsors");
        Query personsQuery = personsRef.orderByKey();

        mRecyclerV.hasFixedSize();
        mRecyclerV.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions personsOptions = new FirebaseRecyclerOptions.Builder<Sponsors>().setQuery(personsQuery, Sponsors.class).build();

        mRecyclerVAdapter = new FirebaseRecyclerAdapter<Sponsors, SponsorsActivity.SponsorsViewHolder>(personsOptions) {
            @Override
            protected void onBindViewHolder(SponsorsActivity.SponsorsViewHolder holder, final int position, final Sponsors model) {
                holder.setImage(model.getUrl());
                progressBar.setVisibility(ProgressBar.INVISIBLE);
            }

            @Override
            public SponsorsActivity.SponsorsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.sponsors_list, parent, false);

                return new SponsorsActivity.SponsorsViewHolder(view);
            }
        };
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

    public static class SponsorsViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public SponsorsViewHolder(View itemView){
            super(itemView);
            mView = itemView;
        }

        public void setImage(String image){
            ImageView post_image = mView.findViewById(R.id.sponsors_image);
            Picasso.get().load(image).into(post_image);
        }
    }
}

