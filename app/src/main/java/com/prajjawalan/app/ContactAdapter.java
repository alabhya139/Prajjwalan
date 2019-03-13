package com.prajjawalan.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.prajjawalan.app.models.Contact;

import java.util.ArrayList;

/**
 * Created by Alabhya Pandey on 13-04-2018.
 */

public class ContactAdapter extends BaseAdapter {

    ArrayList<Object> list;
    private static final int CONTACT_ITEM = 0;
    private static final int HEADER = 1;
    private LayoutInflater layoutInflater;

    public ContactAdapter(Context context, ArrayList<Object> list){
        this.list = list;
        layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof Contact){
            return CONTACT_ITEM;
        }else return HEADER;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 1;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            switch (getItemViewType(position)){
                case CONTACT_ITEM :
                    convertView = layoutInflater.inflate(R.layout.contact_list,null);
                    break;
                case HEADER :
                    convertView = layoutInflater.inflate(R.layout.contact_header,null);
                    break;
            }
        }
        switch (getItemViewType(position)){
            case CONTACT_ITEM :
                TextView contactName = convertView.findViewById(R.id.contact_name);
                TextView contactPhone = convertView.findViewById(R.id.contact_phone);

                contactName.setText(((Contact)list.get(position)).getName());
                contactPhone.setText(((Contact)list.get(position)).getContact());
                break;
            case HEADER :
                TextView header = convertView.findViewById(R.id.contact_header);
                header.setText((String)list.get(position));
                break;
        }

        return convertView;
    }
}
