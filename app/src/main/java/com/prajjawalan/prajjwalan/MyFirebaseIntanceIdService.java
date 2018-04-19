package com.prajjawalan.prajjwalan;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Alabhya Pandey on 14-04-2018.
 */

public class MyFirebaseIntanceIdService extends FirebaseInstanceIdService {
    private static final String REG_TOKEN = "REG_TOKEN";

    @Override
    public void onTokenRefresh() {
        String recentTokens = FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN,recentTokens);

    }
}
