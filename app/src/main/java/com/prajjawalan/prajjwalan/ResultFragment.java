package com.prajjawalan.prajjwalan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Alabhya Pandey on 08-04-2018.
 */

public class ResultFragment extends Fragment {
    View view;
    private TextView textView;

    public ResultFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.result_fragment,container,false);
        textView = view.findViewById(R.id.coordinator);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateText(getActivity().getIntent().getStringExtra("result"));

    }

    public void updateText(String data){
        textView.setText(data);
    }
}
