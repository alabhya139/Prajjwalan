package com.prajjawalan.prajjwalan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.prajjawalan.prajjwalan.models.Contact;

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


        list.add(new String("Decoration Committee"));
        list.add(new Contact("SUNDAR GUPTA"));
        list.add(new Contact("MANISH SINGH"));
        list.add(new Contact("BHANU PRATAP SINGH"));
        list.add(new Contact("ANKIT PATEL"));
        list.add(new Contact("SWATI GUPTA"));
        list.add(new Contact("SHANTANU SAXENA"));
        list.add(new Contact("ABHISHEK YADAV"));
        list.add(new Contact("KRISHNA PRAKASH MANI"));
        list.add(new Contact("FARMAN AHMAD"));
        list.add(new Contact("ADEEBA ZUBEEN"));
        list.add(new Contact("KRATIKA GAUTAM"));
        list.add(new Contact("SUMRIDHI SINGH"));
        list.add(new Contact("ARISHAH KHAN"));
        list.add(new Contact("AMAN GUPTA"));
        list.add(new Contact("ANIKET AGARWAL"));
        list.add(new Contact("SURAJ PANDEY"));
        list.add(new Contact("CHIRAG MAHESHWARY"));
        list.add(new Contact("AMAN SINGH"));
        list.add(new Contact("HARDIK CHATURVEDI"));
        list.add(new Contact("AYUSH SHARMA"));
        list.add(new Contact("SWETA SINGH"));
        list.add(new Contact("KAJAL GUPTA"));
        list.add(new Contact("UTKARSH DUBEY"));
        list.add(new Contact("SIMRAN SINGH"));
        list.add(new Contact("DEEKSHA RANA"));
        list.add(new Contact("RAJAT CHAUDHARY"));
        list.add(new Contact("GURUPYARI SATSANGI"));
        list.add(new Contact("ISHA ROY"));
        list.add(new Contact("GUNJUN DIXIT"));

        list.add(new String("SPONSOR AND PUBLICITY TEAM"));
        list.add(new Contact("SHIVAM BHARDWAJ"));
        list.add(new Contact("NIKHIL SHRIVASTAVA"));
        list.add(new Contact("AYUSH SHARMA"));
        list.add(new Contact("DURG PAL SINGH"));
        list.add(new Contact("KARAN CHAUHAN"));
        list.add(new Contact("ANKIT PATEL"));
        list.add(new Contact("ABHISHEK YADAV"));
        list.add(new Contact("ARISHAH KHAN"));
        list.add(new Contact("ABHYANSHU GARG"));
        list.add(new Contact("ADEEBA ZUBEEN"));
        list.add(new Contact("KRATIKA GAUTAM"));
        list.add(new Contact("AMAN GUPTA"));
        list.add(new Contact("ANIKET AGARWAL"));
        list.add(new Contact("AMAN SINGH"));
        list.add(new Contact("BHAVESH KUMAR SHARMA"));
        list.add(new Contact("SOORVEER CHAHAR"));
        list.add(new Contact("UTKARSH DUBEY"));
        list.add(new Contact("CHIRAG MAHESHWARI"));
        list.add(new Contact("RAJAT CHAUDHARY"));

        list.add(new String("HOSPITALITY AND DISCIPLINE TEAM"));
        list.add(new Contact("AMAN PATEL"));
        list.add(new Contact("SHIVANAND YADAV"));
        list.add(new Contact("PANKAJ PRAJAPATI"));
        list.add(new Contact("NIYAZ AHMAD"));
        list.add(new Contact("AKASH KUMAR"));
        list.add(new Contact("ANKIT YADAV"));
        list.add(new Contact("RAJESH VERMA"));
        list.add(new Contact("ARK SRIVASTAVA"));
        list.add(new Contact("PRASHANT KASHYAP"));
        list.add(new Contact("SAUMY VERMA"));
        list.add(new Contact("ATUL KUMAR"));
        list.add(new Contact("NIKHIL SRIVASTAVA"));
        list.add(new Contact("SHIVAM RATHORE"));
        list.add(new Contact("PRAVEEN KUMAR"));
        list.add(new Contact("RAHUL RAI"));
        list.add(new Contact("ARUN THAKUR"));
        list.add(new Contact("AAKASH RAI"));
        list.add(new Contact("FARMAN AHMAD"));
        list.add(new Contact("GURUVENDRA SINGH"));
        list.add(new Contact("ANSHUMAN PANDEY"));
        list.add(new Contact("AMIT SHARMA"));
        list.add(new Contact("DEEPNARAYAN RAJPUT"));
        list.add(new Contact("RAJENDRA SINGH"));
        list.add(new Contact("ALABHYA PANDEY"));
        list.add(new Contact("RISHABH MISHRA"));
        list.add(new Contact("KRISHNA PRAKASH MANI"));
        list.add(new Contact("SUBHANA SAMAD"));
        list.add(new Contact("ABHISHEK KUMAR"));
        list.add(new Contact("CHIRAG MAHESHWARI"));
        list.add(new Contact("AMAN SINGH"));
        list.add(new Contact("CHITRANSHI SRIVASTAVA"));
        list.add(new Contact("ADEEBA ZUBEEN"));
        list.add(new Contact("AYUSHI SAGAR"));
        list.add(new Contact("SWETA SINGH"));
        list.add(new Contact("ANUTI GUPTA"));
        list.add(new Contact("KAJAL GUPTA"));
        list.add(new Contact("RAJAT CHAUDHARY"));
        list.add(new Contact("ARPITA ROY"));
        list.add(new Contact("MIRNAL SINGH"));
        list.add(new Contact("NEERAJ CAHAR"));

        list.add(new String("LOGISTIC AND EXPENSES TEAM"));
        list.add(new Contact("AMAN PATEL"));
        list.add(new Contact("GURUVENDRA SINGH"));
        list.add(new Contact("ABHISHEK YADAV"));
        list.add(new Contact("ARK SRIVASTAVA"));
        list.add(new Contact("ANKIT YADAV"));
        list.add(new Contact("ANSHUMAN PANDEY"));
        list.add(new Contact("AJAY SRIVASTAVA"));
        list.add(new Contact("RISHABH MISHRA"));
        list.add(new Contact("SHANTANU SAXENA"));
        list.add(new Contact("FARMAN AHMAD"));
        list.add(new Contact("SHIVANAND YADAV"));
        list.add(new Contact("KRISHNA PRAKASH MANI"));

        list.add(new String("MEDIA AND PHOTOGRAPHY TEAM"));
        list.add(new Contact("ANKIT PATEL"));
        list.add(new Contact("MOHIT PRATAP SINGH"));
        list.add(new Contact("RAJAT CHAUDHARY"));
        list.add(new Contact("AMAN GUPTA"));
        list.add(new Contact("SURAJ PANDEY"));
        list.add(new Contact("ARISHAH KHAN"));
        list.add(new Contact("ANIKET AGARWAL"));
        list.add(new Contact("BHAVESH SHARMA"));

        list.add(new String("WEB DEVELOPMENT TEAM"));
        list.add(new Contact("MANISH SINGH"));
        list.add(new Contact("HARDIK CHATURVEDI"));
        list.add(new Contact("SAUMY VERMA"));
        list.add(new Contact("NIKHIL SRIVASTAVA"));


        contactList.setAdapter(new ContactAdapter(this,list));
    }


}
