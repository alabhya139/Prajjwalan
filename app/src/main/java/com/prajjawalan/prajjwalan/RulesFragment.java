package com.prajjawalan.prajjwalan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Alabhya Pandey on 08-04-2018.
 */

public class RulesFragment extends Fragment {
    View view;

    public RulesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.rules_fragment,container,false);
        return view;
    }
}
