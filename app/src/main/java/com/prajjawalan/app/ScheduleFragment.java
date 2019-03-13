package com.prajjawalan.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Alabhya Pandey on 10-04-2018.
 */

public class ScheduleFragment extends Fragment {
    View view;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.schedule_fragment,container,false);
        textView = view.findViewById(R.id.schedule);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateText(getActivity().getIntent().getStringExtra("schedule"));

    }

    public void updateText(String data){
        textView.setText(data);
    }
}
