package com.prajjawalan.prajjwalan;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alabhya Pandey on 06-04-2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<EventItem> eventItems;

    public RecyclerAdapter(ArrayList<EventItem> eventItems){
        this.eventItems = eventItems;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public CardView eventCards;

        public ViewHolder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.event_name);
            imageView = itemView.findViewById(R.id.event_image);
            eventCards = itemView.findViewById(R.id.cards);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        EventItem eventsIt = eventItems.get(position);
        holder.textView.setText(eventsIt.geteventName());
        Picasso.get().load(eventsIt.getimageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return eventItems.size();
    }
}
