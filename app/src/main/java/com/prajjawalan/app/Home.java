package com.prajjawalan.app;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView displayImageView;
    private TextView nameTextView;
    private TextView emailTextView;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private CardView eventCard;
    private TextView updates;
    private TextView movingText;
    private CardView sponsorsCard;
    private CardView contactCard;
    private ImageView dialogClose;
    private CardView talkShow;
    private CardView workShop;
    private CardView talkShowCard;
    Animation animBlink;
    EditText editText;
    String text;


    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_update);

        dialogClose = dialog.findViewById(R.id.dialogbutton);
        dialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });



        talkShow = findViewById(R.id.talk_show);
        workShop = findViewById(R.id.workshop);

        talkShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, TalkShow.class));
            }
        });

        workShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Gallery.class));
            }
        });



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        sponsorsCard = findViewById(R.id.dev_cardview);
        sponsorsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, SponsorsActivity.class));
            }
        });

        contactCard = findViewById(R.id.contactCard);
        contactCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, ContactUs.class));
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View navHeaderView = navigationView.getHeaderView(0);
        eventCard = findViewById(R.id.eventcardId);


        eventCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, CommonActivity.class));
            }
        });

        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle("Prajjwalan");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    isShow = false;
                }
            }
        });

        displayImageView = navHeaderView.findViewById(R.id.name_image);
        nameTextView = navHeaderView.findViewById(R.id.name);
        emailTextView = navHeaderView.findViewById(R.id.email_address);
        text = getIntent().getStringExtra("text");

        nameTextView.setText(text);






        updates = findViewById(R.id.updates);
        animBlink = AnimationUtils.loadAnimation(this, R.anim.blink);
        updates.startAnimation(animBlink);

        movingText = findViewById(R.id.movingtext);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("updates");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                movingText.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        movingText.setSelected(true);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    boolean doubleBackToExitPressedOnce = false;


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_logout) {
            startActivity(new Intent(Home.this,SignIn.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.gallery) {
            startActivity(new Intent(Home.this, Gallery.class));
            // Handle the camera action
        } else if (id == R.id.register) {
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));

        } else if (id == R.id.developers) {
            startActivity(new Intent(getApplicationContext(), Developers.class));

        } else if (id == R.id.feedback) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "kabhya@gmail.com", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My Feedback about Prajjwalan App");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "");
            startActivity(Intent.createChooser(emailIntent, "Send email..."));

        } else if (id == R.id.sign_out) {
            startActivity(new Intent(Home.this,SignIn.class));

        } else if (id == R.id.nav_credit) {
            startActivity(new Intent(Home.this, Credit.class));

        } else if (id == R.id.nav_about) {
            startActivity(new Intent(Home.this, About.class));
        } else if (id == R.id.nav_share) {
            final String appPackageName = getPackageName();
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Prajjwalan");
                String sAux = "\nPlease Download Official App For our College Fest Prajjwalan 2k18\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=" + appPackageName;
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "Share using..."));
            } catch (Exception e) {
                //e.toString();
            }
        } else if (id == R.id.rewards) {
            startActivity(new Intent(Home.this, Rewards.class));
        } else if (id == R.id.nav_faq) {
            startActivity(new Intent(Home.this, Faqs.class));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
