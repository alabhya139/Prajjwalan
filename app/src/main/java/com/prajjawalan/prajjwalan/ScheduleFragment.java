package com.prajjawalan.prajjwalan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prajjawalan.prajjwalan.R;

/**
 * Created by Alabhya Pandey on 10-04-2018.
 */

public class ScheduleFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.schedule_fragment,container,false);
        return view;
    }
}
