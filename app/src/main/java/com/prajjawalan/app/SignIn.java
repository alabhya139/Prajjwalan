package com.prajjawalan.app;

/**
 * Created by Alabhya Pandey on 21-03-2018.
 */

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SignIn extends AppCompatActivity{


    private static final String TAG = SignIn.class.getSimpleName();
    private static final int RC_SIGN_IN = 9001; //Request code for signing in
    private GoogleSignInOptions mGso;
    private TextView countdown;
    CountDownTimer countDownTimer;
    SimpleDateFormat simpleDateFormat;
    Button signIn;
    TextView untilFinished;
    EditText editText;
    String text;

    Button button;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        countdown =findViewById(R.id.countdown);
        untilFinished = findViewById(R.id.remaining_text);

        long totalTimeCount = (1523939805000L) - System.currentTimeMillis()-86400000;
        countDownTimer = new CountDownTimer(totalTimeCount,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                simpleDateFormat = new SimpleDateFormat("dd:hh:mm:ss");
                Date date = new Date(millisUntilFinished);
                String dateText = simpleDateFormat.format(date);
                countdown.setText(dateText);
            }

            @Override
            public void onFinish() {
                countdown.setVisibility(View.INVISIBLE);
                untilFinished.setVisibility(View.INVISIBLE);

            }
        }.start();

        Typeface font = Typeface.createFromAsset(
                this.getAssets(),
                "fonts/digital.ttf");
        countdown.setTypeface(font);
        countdown.setTextSize(60);

        button = findViewById(R.id.buttonsignin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this,Home.class));
                finish();
            }
        });

    }
}
