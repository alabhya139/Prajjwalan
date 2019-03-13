package com.prajjawalan.app;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Alabhya Pandey on 04-04-2018.
 */

public class Developers extends AppCompatActivity {

    private ImageView phone_one;
    private ImageView phone_two;
    private ImageView phone_three;
    private ImageView phone_new;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_dev);

        Toolbar toolbar = findViewById(R.id.credit_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView dev = findViewById(R.id.dev);
        Typeface font = Typeface.createFromAsset(
                this.getAssets(),
                "fonts/earwigfactory.ttf");
        dev.setTypeface(font);
        dev.setTextSize(50);

        phone_new = findViewById(R.id.phone1);
        phone_one = findViewById(R.id.phone0);
        phone_two = findViewById(R.id.phone2);
        phone_three = findViewById(R.id.phone3);

        phone_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919457483864"));
                try{
                    startActivity(intent);
                }catch (SecurityException e){
                    Toast.makeText(Developers.this,"Cant Make Call",Toast.LENGTH_SHORT).show();
                }
            }
        });

        phone_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919559517399"));
                try{
                    startActivity(intent);
                }catch (SecurityException e){
                    Toast.makeText(Developers.this,"Cant Make Call",Toast.LENGTH_SHORT).show();
                }
            }
        });

        phone_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919451081293"));
                try{
                    startActivity(intent);
                }catch (SecurityException e){
                    Toast.makeText(Developers.this,"Cant Make Call",Toast.LENGTH_SHORT).show();
                }
            }
        });

        phone_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918887166913"));
                try{
                    startActivity(intent);
                }catch (SecurityException e){
                    Toast.makeText(Developers.this,"Cant Make Call",Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageView dev_new = findViewById(R.id.facebook1);
        dev_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100009602431699"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100009602431699")));
                }
            }
        });

        ImageView dev_one = findViewById(R.id.facebook0);
        dev_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100005715548014"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/alabhya.pandey.14")));
                }
            }
        });

        ImageView dev_two = findViewById(R.id.facebook2);
        dev_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100003715707402"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/karan.chauhan.9878")));
                }
            }
        });

        ImageView dev_three = findViewById(R.id.facebook3);
        dev_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100003352318964"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/pandit.panday")));
                }
            }
        });
    }
}
