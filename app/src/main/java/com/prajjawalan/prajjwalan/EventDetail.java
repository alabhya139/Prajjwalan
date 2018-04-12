package com.prajjawalan.prajjwalan;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Alabhya Pandey on 08-04-2018.
 */

public class EventDetail extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView imageView;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);

        Toolbar toolbar = findViewById(R.id.event_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new EventDetailsFragment(),"Event Details");
        adapter.AddFragment(new RulesFragment(), "Rules");
        adapter.AddFragment(new ScheduleFragment(), "Schedule");
        adapter.AddFragment(new ResultFragment(), "Result");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        imageView = findViewById(R.id.event_detail_image);
        textView = findViewById(R.id.event_type);
        textView.setText(getIntent().getStringExtra("name"));

        Picasso.get().load(getIntent().getStringExtra("url")).into(imageView);

    }
}
