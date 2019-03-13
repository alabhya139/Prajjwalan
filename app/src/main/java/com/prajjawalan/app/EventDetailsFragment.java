package com.prajjawalan.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Alabhya Pandey on 08-04-2018.
 */

public class EventDetailsFragment extends Fragment {
    View view;
    private TextView textView;
    public EventDetailsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.event_details_fragment,container,false);
        textView = view.findViewById(R.id.event_det);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateText(getActivity().getIntent().getStringExtra("details"));

    }

    public void updateText(String data){
        textView.setText(data);
    }
}
