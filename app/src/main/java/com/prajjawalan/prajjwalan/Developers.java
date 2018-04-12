package com.prajjawalan.prajjwalan;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Alabhya Pandey on 04-04-2018.
 */

public class Developers extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_dev);
        TextView dev = findViewById(R.id.dev);
        Typeface font = Typeface.createFromAsset(
                this.getAssets(),
                "fonts/earwigfactory.ttf");
        dev.setTypeface(font);
        dev.setTextSize(50);
    }
}
